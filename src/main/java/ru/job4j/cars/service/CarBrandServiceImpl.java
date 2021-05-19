package ru.job4j.cars.service;

import ru.job4j.cars.model.CarBrand;
import ru.job4j.cars.repository.CarBrandDAO;
import ru.job4j.cars.repository.HbmCarBrandDAO;

import java.util.List;

public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandDAO carBrandDAO = HbmCarBrandDAO.instOf();

    @Override
    public void addNewCarBrand(CarBrand carBrand) {
        carBrandDAO.create(carBrand);
    }

    @Override
    public List<CarBrand> getCarBrandList() {
        return carBrandDAO.findAll(CarBrand.class);
    }
}
