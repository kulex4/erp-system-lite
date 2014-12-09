package com.erpsystem.model;

import javafx.beans.property.*;

/**
 * Created on 15.11.2014.
 */
public class Company {

    private IntegerProperty idCompany;
    private StringProperty name;
    private StringProperty description;
    private IntegerProperty numberOfManagers;
    private IntegerProperty numberOfQualifiedManagers;
    private IntegerProperty numberOfNotQualifiedManagers;
    private DoubleProperty trainingCost;

    public Company(Integer idCompany, String name, String description, int numberOfManagers, int numberOfQualifiedManagers,
                   int numberOfNotQualifiedManagers, double trainingCost) {

        this.idCompany = new SimpleIntegerProperty(idCompany);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.numberOfManagers = new SimpleIntegerProperty(numberOfManagers);
        this.numberOfQualifiedManagers = new SimpleIntegerProperty(numberOfQualifiedManagers);
        this.numberOfNotQualifiedManagers = new SimpleIntegerProperty(numberOfNotQualifiedManagers);
        this.trainingCost = new SimpleDoubleProperty(trainingCost);
    }

    public Company(String name, String description, int numberOfManagers, int numberOfQualifiedManagers,
                   int numberOfNotQualifiedManagers, double trainingCost) {

        this(0, name, description, numberOfManagers, numberOfQualifiedManagers,
                numberOfNotQualifiedManagers, trainingCost);
    }

    public int getIdCompany() {
        return idCompany.get();
    }

    public IntegerProperty idCompanyProperty() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany.set(idCompany);
    }


    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }


    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }


    public int getNumberOfManagers() {
        return numberOfManagers.get();
    }

    public IntegerProperty numberOfManagersProperty() {
        return numberOfManagers;
    }

    public void setNumberOfManagers(int numberOfManagers) {
        this.numberOfManagers.set(numberOfManagers);
    }


    public int getNumberOfQualifiedManagers() {
        return numberOfQualifiedManagers.get();
    }

    public IntegerProperty numberOfQualifiedManagersProperty() {
        return numberOfQualifiedManagers;
    }

    public void setNumberOfQualifiedManagers(int numberOfQualifiedManagers) {
        this.numberOfQualifiedManagers.set(numberOfQualifiedManagers);
    }


    public int getNumberOfNotQualifiedManagers() {
        return numberOfNotQualifiedManagers.get();
    }

    public IntegerProperty numberOfNotQualifiedManagersProperty() {
        return numberOfNotQualifiedManagers;
    }

    public void setNumberOfNotQualifiedManagers(int numberOfNotQualifiedManagers) {
        this.numberOfNotQualifiedManagers.set(numberOfNotQualifiedManagers);
    }


    public double getTrainingCost() {
        return trainingCost.get();
    }

    public DoubleProperty trainingCostProperty() {
        return trainingCost;
    }

    public void setTrainingCost(double trainingCost) {
        this.trainingCost.set(trainingCost);
    }
}
