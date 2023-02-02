package org.example.repository;

import org.example.model.Cities;

import java.sql.SQLException;
import java.util.List;

public interface Repository {
    void create() throws SQLException;

    void save(Cities cities) throws SQLException;

    List<Cities> findAll() throws SQLException;

    Cities getById(Long id) throws SQLException;
}