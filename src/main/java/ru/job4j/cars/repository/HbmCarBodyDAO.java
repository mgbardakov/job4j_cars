package ru.job4j.cars.repository;

import ru.job4j.cars.model.CarBody;

public class HbmCarBodyDAO extends HbmDao<CarBody, Integer> implements CarBodyDAO {

    private HbmCarBodyDAO() {
    }

    private static final class Lazy {
        private static final CarBodyDAO INST = new HbmCarBodyDAO();
    }

    public static CarBodyDAO instOf() {
        return HbmCarBodyDAO.Lazy.INST;
    }
}
