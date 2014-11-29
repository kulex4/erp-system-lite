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
    public void insert(Company company) {

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            context.insertInto(COMPANY)
                    .set(COMPANY.NAME, company.getName())
                    .set(COMPANY.DESCRIPTION, company.getDescription())
                    .set(COMPANY.NUMBER_OF_MANAGERS, company.getNumberOfManagers())
                    .set(COMPANY.NUMBER_OF_QUALIFIED_MANAGERS, company.getNumberOfQualifiedManagers())
                    .set(COMPANY.NUMBER_OF_NOT_QUALIFIED_MANAGERS, company.getNumberOfNotQualifiedManagers())
                    .set(COMPANY.TRAINING_COST, company.getTrainingCost())
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
    public void update(Company company) {
        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            context.update(COMPANY)
                    .set(COMPANY.NAME, company.getName())
                    .set(COMPANY.DESCRIPTION, company.getDescription())
                    .set(COMPANY.NUMBER_OF_MANAGERS, company.getNumberOfManagers())
                    .set(COMPANY.NUMBER_OF_QUALIFIED_MANAGERS, company.getNumberOfQualifiedManagers())
                    .set(COMPANY.NUMBER_OF_NOT_QUALIFIED_MANAGERS, company.getNumberOfNotQualifiedManagers())
                    .set(COMPANY.TRAINING_COST, company.getTrainingCost())
                    .where(COMPANY.ID.equal(company.getId()))
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
    public List<Company> findAll() {
        List<Company> companies = new ArrayList<>();

        Connection dbConnection = null;
        try {
            dbConnection = DatabaseManager.getDBConnection();
            DSLContext context = DSL.using(dbConnection, SQLDialect.MYSQL);

            Result<Record> records = context.select().from(COMPANY).fetch();
            for(Record r : records) {
                Company company = new Company(
                        r.getValue(COMPANY.ID),
                        r.getValue(COMPANY.NAME),
                        r.getValue(COMPANY.DESCRIPTION),
                        r.getValue(COMPANY.NUMBER_OF_MANAGERS),
                        r.getValue(COMPANY.NUMBER_OF_QUALIFIED_MANAGERS),
                        r.getValue(COMPANY.NUMBER_OF_NOT_QUALIFIED_MANAGERS),
                        r.getValue(COMPANY.TRAINING_COST));
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

    public static void main(String[] args) {
        CompanyDaoImpl dao = new CompanyDaoImpl();
        /*Company company = new Company("Home UPDATED", "Home Company", 11, 8, 2, 100.0);
        company.setId(8);

        dao.update(company);*/
        List<Company> companies = dao.findAll();
        System.out.println(companies.size());
    }
}
