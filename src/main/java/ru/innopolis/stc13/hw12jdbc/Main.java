package ru.innopolis.stc13.hw12jdbc;

import ru.innopolis.stc13.hw12jdbc.dao.MobileDao;
import ru.innopolis.stc13.hw12jdbc.dao.MobileDaoJdbcImpl;
import ru.innopolis.stc13.hw12jdbc.pojo.Manufacturer;
import ru.innopolis.stc13.hw12jdbc.pojo.Mobile;

public class Main {

    public static void main(String[] args) {

        Mobile mobile = new Mobile();
        mobile.setModel("htc");
        mobile.setPrice(6500.0f);
        mobile.setManufacturer(new Manufacturer(4, "htc", "taiwan"));
        MobileDao mobileDao = new MobileDaoJdbcImpl();
        mobileDao.add(mobile);
    }
}
