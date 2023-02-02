package org.example.repository;

import org.example.configuration.DbConnect;
import org.example.model.Presidents;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresidentRepoImpl implements PresidentRepository {

    private final Connection connection;

    public PresidentRepoImpl() throws SQLException {
        connection = new DbConnect().getConnection();
    }

    @Override
    public void create() throws SQLException {
        String createQuery = """
                create table if not exists presidents(
                id serial primary key,
                president_name varchar not null
                );
                """;
        Statement statement = connection.createStatement();
        statement.execute(createQuery);
        statement.close();
        System.out.println("The table has created !!!");
    }

    @Override
    public void save(Presidents presidents) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into presidents(president_name) values (?)");
        preparedStatement.setString(1, presidents.getName());
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("Values saved");
    }

    @Override
    public List<Presidents> findAll() throws SQLException {
        List<Presidents> presidents = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from presidents");
        while (resultSet.next()) {
            Presidents presidents1 = new Presidents();
            presidents1.setId(resultSet.getLong("id"));
            presidents1.setName(resultSet.getString("president_name"));
            presidents.add(presidents1);
        }
        return presidents;
    }
}