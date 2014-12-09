package com.erpsystem.dao;

import static com.erpsystem.generated.Tables.*;

import com.erpsystem.model.Competence;
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
public class CompetenceDaoImpl implements CompetenceDao {

    @Override
    public void insert(Competence competence) {

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            context.insertInto(COMPETENCE)
                    .set(COMPETENCE.RESPONSIBILITY, competence.getResponsibility())
                    .set(COMPETENCE.COMPETENCE_, competence.getCompetence())
                    .set(COMPETENCE.COMMUNICABILITY, competence.getCommunicability())
                    .set(COMPETENCE.TESTING_RESULT, competence.getTestingResult())
                    .set(COMPETENCE.NUMBER_OF_QUALIFICATIONS, competence.getNumberOfQualifications())
                    .set(COMPETENCE.EFFECTIVENESS, competence.getEffectiveness())
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
    public void update(Competence competence) {

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            context.update(COMPETENCE)
                    .set(COMPETENCE.RESPONSIBILITY, competence.getResponsibility())
                    .set(COMPETENCE.COMPETENCE_, competence.getCompetence())
                    .set(COMPETENCE.COMMUNICABILITY, competence.getCommunicability())
                    .set(COMPETENCE.TESTING_RESULT, competence.getTestingResult())
                    .set(COMPETENCE.NUMBER_OF_QUALIFICATIONS, competence.getNumberOfQualifications())
                    .set(COMPETENCE.EFFECTIVENESS, competence.getEffectiveness())
                    .where(COMPETENCE.ID_COMPETENCE.equal(competence.getIdCompetence()))
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
    public Competence findById(int id) {
        Competence competence = null;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.select().from(COMPETENCE).where(COMPETENCE.ID_COMPETENCE.equal(id)).fetchOne();

            if(record != null) {
                competence = new Competence(
                        record.getValue(COMPETENCE.ID_COMPETENCE),
                        record.getValue(COMPETENCE.RESPONSIBILITY),
                        record.getValue(COMPETENCE.COMPETENCE_),
                        record.getValue(COMPETENCE.COMMUNICABILITY),
                        record.getValue(COMPETENCE.TESTING_RESULT),
                        record.getValue(COMPETENCE.NUMBER_OF_QUALIFICATIONS),
                        record.getValue(COMPETENCE.EFFECTIVENESS));
            }

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return competence;
    }

    @Override
    public List<Competence> findAll() {
        List<Competence> competences = new ArrayList<>();

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Result<Record> records = context.select().from(COMPETENCE).fetch();
            for(Record r : records) {
                Competence competence = new Competence(
                        r.getValue(COMPETENCE.ID_COMPETENCE),
                        r.getValue(COMPETENCE.RESPONSIBILITY),
                        r.getValue(COMPETENCE.COMPETENCE_),
                        r.getValue(COMPETENCE.COMMUNICABILITY),
                        r.getValue(COMPETENCE.TESTING_RESULT),
                        r.getValue(COMPETENCE.NUMBER_OF_QUALIFICATIONS),
                        r.getValue(COMPETENCE.EFFECTIVENESS));
                competences.add(competence);
            }

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return competences;
    }
}
