package org.example.repository;

import org.example.model.Countries;

import java.sql.SQLException;
import java.util.List;

public interface CountryRepository {
    void create() throws SQLException;

    void save(Countries countries) throws SQLException;

    List<Countries> findAll() throws SQLException;
}