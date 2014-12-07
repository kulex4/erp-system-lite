package com.erpsystem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created on 07.12.2014.
 */
public class Specialist {

    private IntegerProperty id;
    private StringProperty fio;
    private IntegerProperty age;
    private IntegerProperty experience;
    private IntegerProperty numberOfEmploees;
    private IntegerProperty numberOfShifts;
    private IntegerProperty numberOfInternships;
    private IntegerProperty idCompany;
    private IntegerProperty idEducation;
    private IntegerProperty idCompetence;

    public Specialist(Integer id, String fio, int age, int experience, int numberOfEmploees, int numberOfShifts,
                      int numberOfInternships, int idCompany, int idEducation, int idCompetence) {
        this.id = new SimpleIntegerProperty(id);
        this.fio = new SimpleStringProperty(fio);
        this.age = new SimpleIntegerProperty(age);
        this.experience = new SimpleIntegerProperty(experience);
        this.numberOfEmploees = new SimpleIntegerProperty(numberOfEmploees);
        this.numberOfShifts = new SimpleIntegerProperty(numberOfShifts);
        this.numberOfInternships = new SimpleIntegerProperty(numberOfInternships);
        this.idCompany = new SimpleIntegerProperty(idCompany);
        this.idEducation = new SimpleIntegerProperty(idEducation);
        this.idCompetence = new SimpleIntegerProperty(idCompetence);
    }

    public Specialist(String fio, int age, int experience, int numberOfEmploees, int numberOfShifts,
                      int numberOfInternships, int idCompany, int idEducation, int idCompetence) {

        new Specialist(null, age, experience, numberOfEmploees, numberOfShifts, numberOfInternships,
                idCompany, idEducation, idCompetence);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }


    public String getFio() {
        return fio.get();
    }

    public StringProperty fioProperty() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }


    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }


    public int getExperience() {
        return experience.get();
    }

    public IntegerProperty experienceProperty() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience.set(experience);
    }


    public int getNumberOfEmploees() {
        return numberOfEmploees.get();
    }

    public IntegerProperty numberOfEmploeesProperty() {
        return numberOfEmploees;
    }

    public void setNumberOfEmploees(int numberOfEmploees) {
        this.numberOfEmploees.set(numberOfEmploees);
    }


    public int getNumberOfShifts() {
        return numberOfShifts.get();
    }

    public IntegerProperty numberOfShiftsProperty() {
        return numberOfShifts;
    }

    public void setNumberOfShifts(int numberOfShifts) {
        this.numberOfShifts.set(numberOfShifts);
    }


    public int getNumberOfInternships() {
        return numberOfInternships.get();
    }

    public IntegerProperty numberOfInternshipsProperty() {
        return numberOfInternships;
    }

    public void setNumberOfInternships(int numberOfInternships) {
        this.numberOfInternships.set(numberOfInternships);
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


    public int getIdEducation() {
        return idEducation.get();
    }

    public IntegerProperty idEducationProperty() {
        return idEducation;
    }

    public void setIdEducation(int idEducation) {
        this.idEducation.set(idEducation);
    }


    public int getIdCompetence() {
        return idCompetence.get();
    }

    public IntegerProperty idCompetenceProperty() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence.set(idCompetence);
    }
}
