package Lab5;

import Lab3.MedicineGetable;
import Lab3.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO implements DAO<Medicine>, MedicineGetable {
    static Connection connection;

    public MedicineDAO() {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = getDefaultConnection();
        }

        return connection;
    }

    @Override
    public Medicine create(Medicine entity) {
        String query = "INSERT INTO Medicines(name, price, producer, requires_doctor_sign) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.setString(3, entity.getProducer());
            preparedStatement.setBoolean(4, entity.isRequireDoctor());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            entity.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public boolean update(Medicine entity) {
        boolean result = false;
        String query = "UPDATE Medicines SET name = ?, price = ?, producer = ?, requires_doctor_sign = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.setString(3, entity.getProducer());
            preparedStatement.setBoolean(4, entity.isRequireDoctor());
            preparedStatement.setInt(5, entity.getId());

            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM Medicines WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Medicine findById(int id) {
        Medicine foundMedicine = null;
        String query = "SELECT * FROM Medicines WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            String producer = resultSet.getString("producer");
            boolean isRequiresDoctor = resultSet.getBoolean("requires_doctor_sign");

            foundMedicine = new Medicine(name, price, producer, isRequiresDoctor);
            foundMedicine.setId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundMedicine;
    }


    @Override
    public List<Medicine> getAll() {
        List<Medicine> medicines = null;
        String query = "SELECT * FROM Medicines";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            medicines = getMedicinesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicines;
    }

    private List<Medicine> getMedicinesFromResultSet(ResultSet resultSet) throws SQLException {
        List<Medicine> result = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            String producer = resultSet.getString("producer");
            boolean isRequireDoctor = resultSet.getBoolean("requires_doctor_sign");

            Medicine medicine = new Medicine(name, price, producer, isRequireDoctor);
            medicine.setId(id);
            result.add(medicine);
        }

        return result;
    }

    @Override
    public List<Medicine> getMedicineByName(String name) {
        List<Medicine> medicines = null;
        String query = "SELECT * FROM Medicines WHERE name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            medicines = getMedicinesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicines;
    }

    @Override
    public List<Medicine> getMedicineByPrice(int price) {
        List<Medicine> medicines = null;
        String query = "SELECT * FROM Medicines WHERE price = " + price;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            medicines = getMedicinesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicines;
    }

    @Override
    public List<Medicine> getMedicineByProducer(String producer) {
        List<Medicine> medicines = null;
        String query = "SELECT * FROM Medicines WHERE producer = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, producer);
            ResultSet resultSet = preparedStatement.executeQuery();

            medicines = getMedicinesFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicines;
    }

    @Override
    public Medicine getMedicine(String name, int price, String producer) {
        Medicine medicine = null;
        String query = "SELECT * FROM Medicines WHERE name = ? AND price = ? AND producer = ? LIMIT 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, producer);

            ResultSet resultSet = preparedStatement.executeQuery();
            int id = resultSet.getInt("id");
            String foundName = resultSet.getString("name");
            int foundPrice = resultSet.getInt("price");
            String foundProducer = resultSet.getString("producer");
            boolean isRequireDoctor = resultSet.getBoolean("requires_doctor_sign");

            medicine = new Medicine(foundName, foundPrice, foundProducer, isRequireDoctor);
            medicine.setId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicine;
    }
}
