package ru.innopolis.stc13.hw12jdbc.dao;

import ru.innopolis.stc13.hw12jdbc.connectionManager.ConnectionManager;
import ru.innopolis.stc13.hw12jdbc.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13.hw12jdbc.pojo.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerDaoJdbcImpl implements ManufacturerDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean add(Manufacturer manufacturer) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO manufacturer VALUES (? ,?,?)");
            preparedStatement.setInt(1, manufacturer.getId());
            preparedStatement.setString(2, manufacturer.getName());
            preparedStatement.setString(3, manufacturer.getCountry());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Manufacturer getById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM manufacturer WHERE id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Manufacturer manufacturer = new Manufacturer(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"));
                return manufacturer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateById(Manufacturer manufacturer) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE manufacturer SET name=?,country=? WHERE id =?");
            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM manufacturer WHERE id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
