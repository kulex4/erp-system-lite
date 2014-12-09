package com.erpsystem.utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created on 09.12.2014.
 */
public class TableViewObject {

    private StringProperty fio;
    private StringProperty education;
    private IntegerProperty responsibility;
    private IntegerProperty competence;
    private IntegerProperty communicability;

    public TableViewObject(String fio, String education, int responsibility, int competence, int communicability) {
        this.fio = new SimpleStringProperty(fio);
        this.education = new SimpleStringProperty(education);
        this.responsibility = new SimpleIntegerProperty(responsibility);
        this.competence = new SimpleIntegerProperty(competence);
        this.communicability = new SimpleIntegerProperty(communicability);
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

    public String getEducation() {
        return education.get();
    }

    public StringProperty educationProperty() {
        return education;
    }

    public void setEducation(String education) {
        this.education.set(education);
    }

    public int getResponsibility() {
        return responsibility.get();
    }

    public IntegerProperty responsibilityProperty() {
        return responsibility;
    }

    public void setResponsibility(int responsibility) {
        this.responsibility.set(responsibility);
    }

    public int getCompetence() {
        return competence.get();
    }

    public IntegerProperty competenceProperty() {
        return competence;
    }

    public void setCompetence(int competence) {
        this.competence.set(competence);
    }

    public int getCommunicability() {
        return communicability.get();
    }

    public IntegerProperty communicabilityProperty() {
        return communicability;
    }

    public void setCommunicability(int communicability) {
        this.communicability.set(communicability);
    }
}
