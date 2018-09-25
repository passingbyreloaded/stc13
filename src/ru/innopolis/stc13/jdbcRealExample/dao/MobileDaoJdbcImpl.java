package ru.innopolis.stc13.jdbcRealExample.dao;

import ru.innopolis.stc13.jdbcRealExample.connectionManager.ConnectionManager;
import ru.innopolis.stc13.jdbcRealExample.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13.jdbcRealExample.pojo.Mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDaoJdbcImpl implements MobileDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean add(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mobile VALUES (DEFAULT ,?,?,?)");
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Mobile getById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mobile WHERE id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Mobile mobile = new Mobile(resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("manufacturer"));
                return mobile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateById(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mobile SET model=?,price=?,manufacturer_id=? WHERE id =?");
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer());
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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mobile WHERE id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
