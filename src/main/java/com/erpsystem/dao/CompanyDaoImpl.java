package com.erpsystem.dao;

import static com.erpsystem.generated.Tables.*;

import com.erpsystem.model.Company;
import com.erpsystem.utils.DatabaseManager;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 29.11.2014.
 */
public class CompanyDaoImpl implements CompanyDao {

    @Override
    public int insert(Company company) {

        int id;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.insertInto(COMPANY)
                    .set(COMPANY.NAME, company.getName())
                    .set(COMPANY.DESCRIPTION, company.getDescription())
                    .set(COMPANY.NUMBER_OF_MANAGERS, company.getNumberOfManagers())
                    .set(COMPANY.NUMBER_OF_QUALIFIED_MANAGERS, company.getNumberOfQualifiedManagers())
                    .set(COMPANY.NUMBER_OF_NOT_QUALIFIED_MANAGERS, company.getNumberOfNotQualifiedManagers())
                    .set(COMPANY.TRAINING_COST, company.getTrainingCost())
                    .returning(COMPANY.ID_COMPANY)
                    .fetchOne();
            id = record.getValue(COMPANY.ID_COMPANY);

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
    public int update(Company company) {

        int id;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.update(COMPANY)
                    .set(COMPANY.NAME, company.getName())
                    .set(COMPANY.DESCRIPTION, company.getDescription())
                    .set(COMPANY.NUMBER_OF_MANAGERS, company.getNumberOfManagers())
                    .set(COMPANY.NUMBER_OF_QUALIFIED_MANAGERS, company.getNumberOfQualifiedManagers())
                    .set(COMPANY.NUMBER_OF_NOT_QUALIFIED_MANAGERS, company.getNumberOfNotQualifiedManagers())
                    .set(COMPANY.TRAINING_COST, company.getTrainingCost())
                    .where(COMPANY.ID_COMPANY.equal(company.getIdCompany()))
                    .returning(COMPANY.ID_COMPANY)
                    .fetchOne();
            id = record.getValue(COMPANY.ID_COMPANY);

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
    public Company findByName(String name) {
        Company company = null;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.select().from(COMPANY).where(COMPANY.NAME.equal(name)).fetchOne();
            company = manageChildObjects(record);

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return company;
    }

    @Override
    public Company findById(int id) {
        Company company = null;
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Record record = context.select().from(COMPANY).where(COMPANY.ID_COMPANY.equal(id)).fetchOne();
            company = manageChildObjects(record);

        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return company;
    }


    @Override
    public List<Company> findAll() {
        List<Company> companies = new ArrayList<>();

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Result<Record> records = context.select().from(COMPANY).fetch();
            for(Record r : records) {
                Company company = manageChildObjects(r);
                companies.add(company);
            }
        } finally {
            if(dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ignore) { }
            }
        }
        return companies;
    }

    private Company manageChildObjects(Record record) {

        Company company = null;

        if(record != null) {
            company = new Company(
                    record.getValue(COMPANY.ID_COMPANY),
                    record.getValue(COMPANY.NAME),
                    record.getValue(COMPANY.DESCRIPTION),
                    record.getValue(COMPANY.NUMBER_OF_MANAGERS),
                    record.getValue(COMPANY.NUMBER_OF_QUALIFIED_MANAGERS),
                    record.getValue(COMPANY.NUMBER_OF_NOT_QUALIFIED_MANAGERS),
                    record.getValue(COMPANY.TRAINING_COST));
        }
        return company;
    }
}
