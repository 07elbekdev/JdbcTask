package org.example.repository;

import org.example.configuration.DbConnect;
import org.example.model.Countries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryRepoImpl implements CountryRepository {

    private final Connection connection;

    public CountryRepoImpl() throws SQLException {
        connection = new DbConnect().getConnection();
    }

    @Override
    public void create() throws SQLException {
        String createQuery = """
                create table if not exists countries(
                id serial primary key,
                country_name varchar (50) not null
                );
                """;
        Statement statement = connection.createStatement();
        statement.execute(createQuery);
        statement.close();
        System.out.println("Table Countries successfully created !!! ");
    }

    @Override
    public void save(Countries countries) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into countries(country_name) values (?)");
        preparedStatement.setString(1, countries.getName());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("All values saved successfully in table countries !!!");
    }

    @Override
    public List<Countries> findAll() throws SQLException {
        List<Countries> countries = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from countries");
        while (resultSet.next()) {
            Countries countries1 = new Countries();
            countries1.setId(resultSet.getLong("id"));
            countries1.setName(resultSet.getString("country_name"));
            countries.add(countries1);
        }
        return countries;
    }
}