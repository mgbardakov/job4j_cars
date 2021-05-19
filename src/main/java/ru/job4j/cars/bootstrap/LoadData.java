package ru.job4j.cars.bootstrap;

import ru.job4j.cars.model.Advertisement;
import ru.job4j.cars.model.CarBody;
import ru.job4j.cars.model.CarBrand;
import ru.job4j.cars.model.Image;
import ru.job4j.cars.service.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class LoadData implements ServletContextListener{

    private final AdService adService = new AdServiceImpl();
    private final CarBodyService carBodyService = new CarBodyServiceImpl();
    private final CarBrandService carBrandService = new CarBrandServiceImpl();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if(carBrandService.getCarBrandList().size() == 0) {
            loadBrands();
            loadCarBodies();
            loadAds();
        }
    }

    private void loadBrands() {
        var brands = List.of(new CarBrand("Toyota"),
                new CarBrand("BMW"), new CarBrand("Peugeot"),
                new CarBrand("Ferrari"), new CarBrand("Aston Martin"));
        brands.forEach(carBrandService::addNewCarBrand);
    }

    private void loadCarBodies() {
        var bodies = List.of(new CarBody("Седан"),
                new CarBody("Хэтчбек"), new CarBody("Купе"),
                new CarBody("Минивен"));
        bodies.forEach(carBodyService::addNewCarBody);
    }

    private void loadAds() {
        var ads = List.of(new Advertisement("Продам пежо седан",
                new CarBody(1), new CarBrand(3), null),
                new Advertisement("Продам тойоту купе", new CarBody(3),
                        new CarBrand(1), new Image()),
                new Advertisement("Продам феррари минивен", new CarBody(4),
                        new CarBrand(4), new Image()));
        ads.forEach(adService::addNewAd);
    }
}
