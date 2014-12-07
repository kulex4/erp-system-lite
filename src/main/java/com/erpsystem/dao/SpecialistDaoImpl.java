package com.erpsystem.dao;

import static com.erpsystem.generated.Tables.*;

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
    public void insert(Specialist specialist) {

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            context.insertInto(SPECIALIST)
                    .set(SPECIALIST.FIO, specialist.getFio())
                    .set(SPECIALIST.AGE, specialist.getAge())
                    .set(SPECIALIST.EXPERIENCE, specialist.getExperience())
                    .set(SPECIALIST.NUMBER_OF_EMPLOEES, specialist.getNumberOfEmploees())
                    .set(SPECIALIST.NUMBER_OF_SHIFTS, specialist.getNumberOfShifts())
                    .set(SPECIALIST.NUMBER_OF_INTERNSHIPS, specialist.getNumberOfInternships())
                    .set(SPECIALIST.ID_COMPANY, specialist.getIdCompany())
                    .set(SPECIALIST.ID_EDUCATION, specialist.getIdEducation())
                    .set(SPECIALIST.ID_COMPETENCE, specialist.getIdCompetence())
                    .execute();

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
    }

    @Override
    public void update(Specialist specialist) {

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            context.update(SPECIALIST)
                    .set(SPECIALIST.FIO, specialist.getFio())
                    .set(SPECIALIST.AGE, specialist.getAge())
                    .set(SPECIALIST.EXPERIENCE, specialist.getExperience())
                    .set(SPECIALIST.NUMBER_OF_EMPLOEES, specialist.getNumberOfEmploees())
                    .set(SPECIALIST.NUMBER_OF_SHIFTS, specialist.getNumberOfShifts())
                    .set(SPECIALIST.NUMBER_OF_INTERNSHIPS, specialist.getNumberOfInternships())
                    .set(SPECIALIST.ID_COMPANY, specialist.getIdCompany())
                    .set(SPECIALIST.ID_EDUCATION, specialist.getIdEducation())
                    .set(SPECIALIST.ID_COMPETENCE, specialist.getIdCompetence())
                    .where(SPECIALIST.ID.equal(specialist.getId()))
                    .execute();

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
    }

    @Override
    public Specialist findByFio(String fio) {
        Specialist specialist = null;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.select().from(SPECIALIST).where(SPECIALIST.FIO.equal(fio)).fetchOne();

            if(record != null) {
                specialist = new Specialist(
                        record.getValue(SPECIALIST.ID),
                        record.getValue(SPECIALIST.FIO),
                        record.getValue(SPECIALIST.AGE),
                        record.getValue(SPECIALIST.EXPERIENCE),
                        record.getValue(SPECIALIST.NUMBER_OF_EMPLOEES),
                        record.getValue(SPECIALIST.NUMBER_OF_SHIFTS),
                        record.getValue(SPECIALIST.NUMBER_OF_INTERNSHIPS),
                        record.getValue(SPECIALIST.ID_COMPANY),
                        record.getValue(SPECIALIST.ID_EDUCATION),
                        record.getValue(SPECIALIST.ID_COMPETENCE));
            }

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
                Specialist specialist = new Specialist(
                        r.getValue(SPECIALIST.ID),
                        r.getValue(SPECIALIST.FIO),
                        r.getValue(SPECIALIST.AGE),
                        r.getValue(SPECIALIST.EXPERIENCE),
                        r.getValue(SPECIALIST.NUMBER_OF_EMPLOEES),
                        r.getValue(SPECIALIST.NUMBER_OF_SHIFTS),
                        r.getValue(SPECIALIST.NUMBER_OF_INTERNSHIPS),
                        r.getValue(SPECIALIST.ID_COMPANY),
                        r.getValue(SPECIALIST.ID_EDUCATION),
                        r.getValue(SPECIALIST.ID_COMPETENCE));
                specialists.add(specialist);
            }

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return null;
    }

    @Override
    public List<Specialist> findAll() {
        List<Specialist> specialists = new ArrayList<>();

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Result<Record> records = context.select().from(COMPANY).fetch();
            for(Record r : records) {
                Specialist specialist = new Specialist(
                        r.getValue(SPECIALIST.ID),
                        r.getValue(SPECIALIST.FIO),
                        r.getValue(SPECIALIST.AGE),
                        r.getValue(SPECIALIST.EXPERIENCE),
                        r.getValue(SPECIALIST.NUMBER_OF_EMPLOEES),
                        r.getValue(SPECIALIST.NUMBER_OF_SHIFTS),
                        r.getValue(SPECIALIST.NUMBER_OF_INTERNSHIPS),
                        r.getValue(SPECIALIST.ID_COMPANY),
                        r.getValue(SPECIALIST.ID_EDUCATION),
                        r.getValue(SPECIALIST.ID_COMPETENCE));
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
}
