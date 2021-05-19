package ru.job4j.cars.service;

import ru.job4j.cars.model.CarBrand;

import java.util.List;

public interface CarBrandService {
    void addNewCarBrand(CarBrand carBrand);
    List<CarBrand> getCarBrandList();
}
