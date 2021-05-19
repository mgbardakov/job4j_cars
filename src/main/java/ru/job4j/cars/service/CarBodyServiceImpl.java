package ru.job4j.cars.service;

import ru.job4j.cars.model.CarBody;
import ru.job4j.cars.repository.CarBodyDAO;
import ru.job4j.cars.repository.HbmCarBodyDAO;

public class CarBodyServiceImpl implements CarBodyService {

    private final CarBodyDAO carBodyDAO = HbmCarBodyDAO.instOf();

    @Override
    public void addNewCarBody(CarBody carBody) {
        carBodyDAO.create(carBody);
    }
}
