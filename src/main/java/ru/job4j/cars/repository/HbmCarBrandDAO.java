package ru.job4j.cars.repository;

import ru.job4j.cars.model.CarBrand;

public class HbmCarBrandDAO extends HbmDao<CarBrand, Integer> implements CarBrandDAO {

    private HbmCarBrandDAO() {
    }

    private static final class Lazy {
        private static final CarBrandDAO INST = new HbmCarBrandDAO();
    }

    public static CarBrandDAO instOf() {
        return HbmCarBrandDAO.Lazy.INST;
    }

}
