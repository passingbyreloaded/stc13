package ru.innopolis.stc13.hw12jdbc.dao;

import ru.innopolis.stc13.hw12jdbc.connectionManager.ConnectionManager;
import ru.innopolis.stc13.hw12jdbc.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13.hw12jdbc.pojo.Manufacturer;
import ru.innopolis.stc13.hw12jdbc.pojo.Mobile;

import java.sql.*;

public class MobileDaoJdbcImpl implements MobileDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    private static ManufacturerDao manufacturerDao = new ManufacturerDaoJdbcImpl();

    @Override
    public boolean add(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mobile VALUES (DEFAULT ,?,?,?)");
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            setParameterForManufacturer(preparedStatement, mobile.getManufacturer());
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
                        manufacturerDao.getById(resultSet.getInt("manufacturer")));
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
            setParameterForManufacturer(preparedStatement, mobile.getManufacturer());
            preparedStatement.setInt(4, mobile.getId());
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

    private boolean manufacturerExists(Manufacturer manufacturer) {
        if (manufacturerDao.getById(manufacturer.getId()) == null) {
            return manufacturerDao.add(manufacturer);
        }
        return true;
    }

    private void setParameterForManufacturer(PreparedStatement preparedStatement, Manufacturer manufacturer) throws SQLException {
        if (manufacturerExists(manufacturer)) {
            preparedStatement.setInt(3, manufacturer.getId());
        } else {
            preparedStatement.setNull(3, Types.INTEGER);
        }
    }
}
