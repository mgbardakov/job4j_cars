package ru.job4j.cars.repository;

import ru.job4j.cars.model.Advertisement;
import ru.job4j.cars.model.CarBrand;

import java.util.List;

public interface AdRepositoryDAO extends DAO<Advertisement, Integer> {
    List<Advertisement> getLastDayAds();
    List<Advertisement> getAdsWithPhoto();
    List<Advertisement> getAdsByCarBrand(CarBrand carBrand);
}
