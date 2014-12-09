package com.erpsystem.dao;

import com.erpsystem.model.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 29.11.2014.
 */
public interface CompanyDao {

    int insert(Company company);

    int update(Company company);

    Company findByName(String name);

    Company findById(int id);

    List<Company> findAll();
}
