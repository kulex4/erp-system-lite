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
    public int insert(Competence competence) {

        int id;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.insertInto(COMPETENCE)
                    .set(COMPETENCE.RESPONSIBILITY, competence.getResponsibility())
                    .set(COMPETENCE.COMPETENCE_, competence.getCompetence())
                    .set(COMPETENCE.COMMUNICABILITY, competence.getCommunicability())
                    .set(COMPETENCE.TESTING_RESULT, competence.getTestingResult())
                    .set(COMPETENCE.NUMBER_OF_QUALIFICATIONS, competence.getNumberOfQualifications())
                    .set(COMPETENCE.EFFECTIVENESS, competence.getEffectiveness())
                    .returning(COMPETENCE.ID_COMPETENCE)
                    .fetchOne();
            id = record.getValue(COMPETENCE.ID_COMPETENCE);

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
            competence = manageChildObjects(record);

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
                Competence competence = manageChildObjects(r);
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

    private Competence manageChildObjects(Record record) {

        Competence competence = null;

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
        return competence;
    }

}
