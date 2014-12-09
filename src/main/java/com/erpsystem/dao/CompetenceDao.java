package com.erpsystem.dao;

import com.erpsystem.model.Competence;
import java.util.List;

/**
 * Created on 09.12.2014.
 */
public interface CompetenceDao {

    void insert(Competence competence);

    void update(Competence competence);

    Competence findById(int id);

    List<Competence> findAll();
}
