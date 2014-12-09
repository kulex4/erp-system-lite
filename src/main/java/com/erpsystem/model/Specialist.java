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
    private IntegerProperty numberOfEmployees;
    private IntegerProperty numberOfShifts;
    private IntegerProperty numberOfInternships;
    private Company company;
    private Education education;
    private Competence competence;

    public Specialist(Integer id, String fio, int age, int experience, int numberOfEmployees, int numberOfShifts,
                      int numberOfInternships, Company company, Education education, Competence competence) {
        this.id = new SimpleIntegerProperty(id);
        this.fio = new SimpleStringProperty(fio);
        this.age = new SimpleIntegerProperty(age);
        this.experience = new SimpleIntegerProperty(experience);
        this.numberOfEmployees = new SimpleIntegerProperty(numberOfEmployees);
        this.numberOfShifts = new SimpleIntegerProperty(numberOfShifts);
        this.numberOfInternships = new SimpleIntegerProperty(numberOfInternships);
        this.company = company;
        this.education = education;
        this.competence = competence;
    }

    public Specialist(String fio, int age, int experience, int numberOfEmployees, int numberOfShifts,
                      int numberOfInternships, Company company, Education education, Competence competence) {

        this(0, fio, age, experience, numberOfEmployees, numberOfShifts, numberOfInternships,
                company, education, competence);
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


    public int getNumberOfEmployees() {
        return numberOfEmployees.get();
    }

    public IntegerProperty numberOfEmployeesProperty() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees.set(numberOfEmployees);
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


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }


    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}
