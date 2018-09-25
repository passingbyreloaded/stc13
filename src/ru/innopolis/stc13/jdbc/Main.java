package ru.innopolis.stc13.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "930000");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mobile");
        while (resultSet.next()) {
            System.out.print("model=" + resultSet.getString("model"));
            System.out.print("; price=" + resultSet.getFloat("price"));
            System.out.println("; manufacturer_id=" + resultSet.getInt("manufacturer_id"));
        }
        connection.close();
    }
}
