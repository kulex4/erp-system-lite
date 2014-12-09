package com.erpsystem.dao;

import com.erpsystem.model.Competence;
import java.util.List;

/**
 * Created on 09.12.2014.
 */
public interface CompetenceDao {

    int insert(Competence competence);

    int update(Competence competence);

    Competence findById(int id);

    List<Competence> findAll();
}
