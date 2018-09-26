package ru.innopolis.stc13.hw12jdbc.dao;

import ru.innopolis.stc13.hw12jdbc.pojo.Mobile;

public interface MobileDao {

    boolean add(Mobile mobile);

    Mobile getById(Integer id);

    boolean updateById(Mobile mobile);

    boolean deleteById(Integer id);
}
