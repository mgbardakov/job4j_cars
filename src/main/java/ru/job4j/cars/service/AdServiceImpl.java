package ru.job4j.cars.service;

import ru.job4j.cars.model.Advertisement;
import ru.job4j.cars.model.CarBody;
import ru.job4j.cars.model.CarBrand;
import ru.job4j.cars.repository.*;

public class AdServiceImpl implements AdService {

    private final AdRepositoryDAO adRepositoryDAO = HbmAdRepositoryDAO.instOf();
    private final CarBrandDAO carBrandDAO = HbmCarBrandDAO.instOf();
    private final CarBodyDAO carBodyDAO = HbmCarBodyDAO.instOf();

    @Override
    public void addNewAd(Advertisement advertisement) {
        var body = carBodyDAO.read(CarBody.class, advertisement.getCarBody().getId());
        var brand = carBrandDAO.read(CarBrand.class, advertisement.getCarBrand().getId());
        advertisement.setCarBody(body);
        advertisement.setCarBrand(brand);
        adRepositoryDAO.create(advertisement);
    }
}
