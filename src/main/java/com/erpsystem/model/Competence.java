package com.erpsystem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created on 09.12.2014.
 */
public class Competence {

    private IntegerProperty idCompetence;
    private IntegerProperty responsibility;
    private IntegerProperty competence;
    private IntegerProperty communicability;
    private IntegerProperty testingResult;
    private IntegerProperty numberOfQualifications;
    private IntegerProperty effectiveness;

    public Competence(Integer idCompetence, int responsibility, int competence, int communicability, int testingResult,
                      int numberOfQualifications, int effectiveness) {

        this.idCompetence = new SimpleIntegerProperty(idCompetence);
        this.responsibility = new SimpleIntegerProperty(responsibility);
        this.competence = new SimpleIntegerProperty(competence);
        this.communicability = new SimpleIntegerProperty(communicability);
        this.testingResult = new SimpleIntegerProperty(testingResult);
        this.numberOfQualifications = new SimpleIntegerProperty(numberOfQualifications);
        this.effectiveness = new SimpleIntegerProperty(effectiveness);
    }

    public Competence(int responsibility, int competence, int communicability, int testingResult,
                      int numberOfQualifications, int effectiveness) {

        new Competence(null, responsibility, competence, communicability,
                testingResult, numberOfQualifications, effectiveness);
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


    public int getTestingResult() {
        return testingResult.get();
    }

    public IntegerProperty testingResultProperty() {
        return testingResult;
    }

    public void setTestingResult(int testingResult) {
        this.testingResult.set(testingResult);
    }


    public int getNumberOfQualifications() {
        return numberOfQualifications.get();
    }

    public IntegerProperty numberOfQualificationsProperty() {
        return numberOfQualifications;
    }

    public void setNumberOfQualifications(int numberOfQualifications) {
        this.numberOfQualifications.set(numberOfQualifications);
    }


    public int getEffectiveness() {
        return effectiveness.get();
    }

    public IntegerProperty effectivenessProperty() {
        return effectiveness;
    }

    public void setEffectiveness(int effectiveness) {
        this.effectiveness.set(effectiveness);
    }
}
