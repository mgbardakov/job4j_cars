package ru.job4j.cars.repository;

import ru.job4j.cars.model.Advertisement;
import ru.job4j.cars.model.CarBrand;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HbmAdRepositoryDAO extends HbmDao<Advertisement, Integer> implements AdRepositoryDAO {

    private HbmAdRepositoryDAO() {
    }

    private static final class Lazy {
        private static final AdRepositoryDAO INST = new HbmAdRepositoryDAO();
    }

    public static AdRepositoryDAO instOf() {
        return HbmAdRepositoryDAO.Lazy.INST;
    }

    @Override
    public Advertisement create(Advertisement model) {

        return super.create(model);
    }

    @Override
    public List<Advertisement> getLastDayAds() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date date = calendar.getTime();
        return txFunc(session -> session.createQuery("select a from Advertisement a" +
                    " where a.created > :param", Advertisement.class)
                .setParameter("param", date).list());
    }

    @Override
    public List<Advertisement> getAdsWithPhoto() {
        return txFunc(session -> session.createQuery("select a from Advertisement a" +
                " where a.image is not null", Advertisement.class).list());
    }

    @Override
    public List<Advertisement> getAdsByCarBrand(CarBrand carBrand) {
        return txFunc(session -> session.createQuery("select a  from Advertisement a " +
                "where a.carBrand = :fBrand", Advertisement.class)
                .setParameter("fBrand", carBrand)
                .list());
    }
}
