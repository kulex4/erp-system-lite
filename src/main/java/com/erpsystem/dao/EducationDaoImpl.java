package com.erpsystem.dao;

import static com.erpsystem.generated.Tables.*;

import com.erpsystem.model.Education;
import com.erpsystem.utils.DatabaseManager;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 09.12.2014.
 */
public class EducationDaoImpl implements EducationDao {

    @Override
    public int insert(Education education) {

        int id;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.insertInto(EDUCATION)
                    .set(EDUCATION.NAME, education.getName())
                    .set(EDUCATION.FACTOR, education.getFactor())
                    .returning(EDUCATION.ID_EDUCATION)
                    .fetchOne();
            id = record.getValue(EDUCATION.ID_EDUCATION);

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
    public int update(Education education) {

        int id;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.update(EDUCATION)
                    .set(EDUCATION.NAME, education.getName())
                    .set(EDUCATION.FACTOR, education.getFactor())
                    .where(EDUCATION.ID_EDUCATION.equal(education.getIdEducation()))
                    .returning(EDUCATION.ID_EDUCATION)
                    .fetchOne();
            id = record.getValue(EDUCATION.ID_EDUCATION);

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
    public Education findById(int id) {
        Education education = null;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.select().from(EDUCATION).where(EDUCATION.ID_EDUCATION.equal(id)).fetchOne();
            education = manageChildObjects(record);

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return education;
    }

    @Override
    public List<Education> findAll() {
        List<Education> educations = new ArrayList<>();

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Result<Record> records = context.select().from(EDUCATION).fetch();
            for(Record r : records) {
                Education education = manageChildObjects(r);
                educations.add(education);
            }

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return educations;
    }

    private Education manageChildObjects(Record record) {

        Education education = null;

        if(record != null) {
            education = new Education(
                    record.getValue(EDUCATION.ID_EDUCATION),
                    record.getValue(EDUCATION.NAME),
                    record.getValue(EDUCATION.FACTOR));
        }
        return education;
    }
}
