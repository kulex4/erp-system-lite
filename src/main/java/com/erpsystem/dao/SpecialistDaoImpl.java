package com.erpsystem.dao;

import static com.erpsystem.generated.Tables.*;

import com.erpsystem.model.Company;
import com.erpsystem.model.Competence;
import com.erpsystem.model.Education;
import com.erpsystem.model.Specialist;
import com.erpsystem.utils.DatabaseManager;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 07.12.2014.
 */
public class SpecialistDaoImpl implements SpecialistDao {

    @Override
    public int insert(Specialist specialist) {

        int id;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.insertInto(SPECIALIST)
                    .set(SPECIALIST.FIO, specialist.getFio())
                    .set(SPECIALIST.AGE, specialist.getAge())
                    .set(SPECIALIST.EXPERIENCE, specialist.getExperience())
                    .set(SPECIALIST.NUMBER_OF_EMPLOEES, specialist.getNumberOfEmployees())
                    .set(SPECIALIST.NUMBER_OF_SHIFTS, specialist.getNumberOfShifts())
                    .set(SPECIALIST.NUMBER_OF_INTERNSHIPS, specialist.getNumberOfInternships())
                    .set(SPECIALIST.ID_COMPANY, specialist.getCompany().getIdCompany())
                    .set(SPECIALIST.ID_EDUCATION, specialist.getEducation().getIdEducation())
                    .set(SPECIALIST.ID_COMPETENCE, specialist.getCompetence().getIdCompetence())
                    .returning(SPECIALIST.ID)
                    .fetchOne();
            id = record.getValue(SPECIALIST.ID);

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return id;
    }

    @Override
    public int update(Specialist specialist) {

        int id;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.update(SPECIALIST)
                    .set(SPECIALIST.FIO, specialist.getFio())
                    .set(SPECIALIST.AGE, specialist.getAge())
                    .set(SPECIALIST.EXPERIENCE, specialist.getExperience())
                    .set(SPECIALIST.NUMBER_OF_EMPLOEES, specialist.getNumberOfEmployees())
                    .set(SPECIALIST.NUMBER_OF_SHIFTS, specialist.getNumberOfShifts())
                    .set(SPECIALIST.NUMBER_OF_INTERNSHIPS, specialist.getNumberOfInternships())
                    .set(SPECIALIST.ID_COMPANY, specialist.getCompany().getIdCompany())
                    .set(SPECIALIST.ID_EDUCATION, specialist.getEducation().getIdEducation())
                    .set(SPECIALIST.ID_COMPETENCE, specialist.getCompetence().getIdCompetence())
                    .where(SPECIALIST.ID.equal(specialist.getId()))
                    .returning(SPECIALIST.ID)
                    .fetchOne();
            id = record.getValue(SPECIALIST.ID);

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return id;
    }

    @Override
    public Specialist findByFio(String fio) {
        Specialist specialist = null;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.select().from(SPECIALIST).where(SPECIALIST.FIO.equal(fio)).fetchOne();
            specialist = manageChildObjects(record);

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return specialist;
    }

    @Override
    public List<Specialist> findAllByCompanyId(int id) {
        List<Specialist> specialists = new ArrayList<>();

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Result<Record> records = context.select().from(SPECIALIST).where(SPECIALIST.ID_COMPANY.equal(id)).fetch();

            for(Record r : records) {
                Specialist specialist = manageChildObjects(r);
                specialists.add(specialist);
            }

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return specialists;
    }

    @Override
    public List<Specialist> findAll() {
        List<Specialist> specialists = new ArrayList<>();

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Result<Record> records = context.select().from(SPECIALIST).fetch();
            for(Record r : records) {
                Specialist specialist = manageChildObjects(r);
                specialists.add(specialist);
            }

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return specialists;
    }

    private Specialist manageChildObjects(Record record) {

        Specialist specialist = null;

        if(record != null) {
            CompanyDao companyDao = new CompanyDaoImpl();
            Company company = companyDao.findById(record.getValue(COMPANY.ID_COMPANY));

            EducationDao educationDao = new EducationDaoImpl();
            Education education = educationDao.findById(record.getValue(EDUCATION.ID_EDUCATION));

            CompetenceDao competenceDao = new CompetenceDaoImpl();
            Competence competence = competenceDao.findById(record.getValue(COMPETENCE.ID_COMPETENCE));

            specialist = new Specialist(
                    record.getValue(SPECIALIST.ID),
                    record.getValue(SPECIALIST.FIO),
                    record.getValue(SPECIALIST.AGE),
                    record.getValue(SPECIALIST.EXPERIENCE),
                    record.getValue(SPECIALIST.NUMBER_OF_EMPLOEES),
                    record.getValue(SPECIALIST.NUMBER_OF_SHIFTS),
                    record.getValue(SPECIALIST.NUMBER_OF_INTERNSHIPS),
                    company, education, competence);
        }
        return specialist;
    }
}
