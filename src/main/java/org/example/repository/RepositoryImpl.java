package org.example.repository;

import org.example.configuration.DbConnect;
import org.example.model.Cities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {

    private final Connection connection;

    public RepositoryImpl() throws SQLException {
        connection = new DbConnect().getConnection();
    }

    public void create() throws SQLException {
        String createQuery = """
                create table if not exists cities(
                id serial primary key,
                city_name varchar not null
                   );
                    """;
        Statement statement = connection.createStatement();
        statement.execute(createQuery);
        statement.close();
        System.out.println("Table cities successfully created !!! ");
    }

    public void save(Cities cities) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into cities(city_name) values (?)");
        preparedStatement.setString(1, cities.getNameOfCountry());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("All values are successfully saved !!! ");
    }

    public List<Cities> findAll() throws SQLException {
        List<Cities> cities = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from cities ;");
        while (resultSet.next()) {
            Cities cities1 = new Cities();
            cities1.setId(resultSet.getLong("id"));
            cities1.setNameOfCountry(resultSet.getString("city_name"));
            cities.add(cities1);
        }
        return cities;
    }

    public Cities getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from cities where id = " + id + ";");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (!resultSet.next()) {
            System.out.println("siuuu");
        }
        Cities cities = new Cities();
        cities.setId(resultSet.getLong("id"));
        cities.setNameOfCountry(resultSet.getString("city_name"));
        return cities;
    }
}