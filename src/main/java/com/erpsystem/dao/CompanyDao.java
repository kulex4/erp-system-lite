package com.erpsystem.dao;

import com.erpsystem.model.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 29.11.2014.
 */
public interface CompanyDao {

    void insert(Company company) throws SQLException, ClassNotFoundException;

    void update(Company company);

    Company findByName(String name);

    List<Company> findAll();
}
