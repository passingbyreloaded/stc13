package ru.innopolis.stc13.jdbcRealExample.connectionManager;

import java.sql.Connection;

public interface ConnectionManager {

    Connection getConnection();
}
