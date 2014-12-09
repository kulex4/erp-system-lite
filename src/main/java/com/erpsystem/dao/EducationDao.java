package com.erpsystem.dao;

import com.erpsystem.model.Education;
import java.util.List;

/**
 * Created on 09.12.2014.
 */
public interface EducationDao {

    int insert(Education education);

    void update(Education education);

    Education findById(int id);

    List<Education> findAll();
}
