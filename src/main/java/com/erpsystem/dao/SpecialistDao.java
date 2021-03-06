package com.erpsystem.dao;

import com.erpsystem.model.Specialist;
import java.util.List;

/**
 * Created on 07.12.2014.
 */
public interface SpecialistDao {

    int insert(Specialist specialist);

    void update(Specialist specialist);

    Specialist findByFio(String fio);

    List<Specialist> findAllByCompanyId(int id);

    List<Specialist> findAll();
}
