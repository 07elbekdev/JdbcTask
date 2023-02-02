package org.example.repository;

import org.example.model.Presidents;

import java.sql.SQLException;
import java.util.List;

public interface PresidentRepository {
    void create() throws SQLException;

    void save(Presidents presidents) throws SQLException;

    List<Presidents> findAll() throws SQLException;
}