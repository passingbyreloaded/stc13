package ru.innopolis.stc13.jdbcRealExample.dao;

import ru.innopolis.stc13.jdbcRealExample.pojo.Mobile;

public interface MobileDao {

    boolean add(Mobile mobile);

    Mobile getById(Integer id);

    boolean updateById(Mobile mobile);

    boolean deleteById(Integer id);
}
