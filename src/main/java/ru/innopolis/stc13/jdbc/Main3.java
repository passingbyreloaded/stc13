package ru.innopolis.stc13.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main3 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "930000");

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mobile SET price=5000 WHERE id = ?");
        for (String arg : args) {
            preparedStatement.setInt(1, Integer.parseInt(arg));
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }
}
