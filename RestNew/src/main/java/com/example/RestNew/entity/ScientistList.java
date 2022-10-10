package com.example.RestNew.entity;



/**
 * @author Zulfa Attar
 */

public class ScientistList {

    private int scientistId;
    private String scientistName;

    public int getScientistId() {
        return scientistId;
    }

    public void setScientistId(int scientistId) {
        this.scientistId = scientistId;
    }

    public String getScientistName() {
        return scientistName;
    }

    public void setScientistName(String scientistName) {
        this.scientistName = scientistName;
    }

    @Override
    public String toString() {
        return "ScientistList{" +
                "scientistId=" + scientistId +
                ", scientistName='" + scientistName + '\'' +
                '}';
    }

    public ScientistList(int scientistId, String scientistName) {
        this.scientistId = scientistId;
        this.scientistName = scientistName;
    }

    public ScientistList() {
    }
}
