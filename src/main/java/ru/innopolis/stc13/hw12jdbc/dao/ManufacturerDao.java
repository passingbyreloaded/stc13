package ru.innopolis.stc13.hw12jdbc.dao;

import ru.innopolis.stc13.hw12jdbc.pojo.Manufacturer;

public interface ManufacturerDao {

    boolean add(Manufacturer manufacturer);

    Manufacturer getById(Integer id);

    boolean updateById(Manufacturer manufacturer);

    boolean deleteById(Integer id);
}
