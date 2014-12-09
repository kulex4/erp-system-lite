package com.erpsystem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created on 09.12.2014.
 */
public class Education {

    private IntegerProperty idEducation;
    private StringProperty name;
    private IntegerProperty factor;

    public Education(Integer idEducation, String name, int factor) {
        this.idEducation = new SimpleIntegerProperty(idEducation);
        this.name = new SimpleStringProperty(name);
        this.factor = new SimpleIntegerProperty(factor);
    }

    public Education(String name, int factor) {
        new Education(null, name, factor);
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


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public int getFactor() {
        return factor.get();
    }

    public IntegerProperty factorProperty() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor.set(factor);
    }
}
