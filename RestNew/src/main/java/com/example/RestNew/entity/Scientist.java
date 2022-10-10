package com.example.RestNew.entity;


import java.util.List;

/**
 * @author Zulfa Attar
 */

public class Scientist {

    private int scientistId;
    private String scientistName;
    private String scientistDateOfBirth;
    private String scientistDateOfDeath;
    private String scientistProfilePicture;
    private String scientistBio;
    private String scientistEducation;
    private String scientistUniversity;
    private String scientistCountries;
    private String scientistFieldOfStudy;
    private List<String> scientistAwards;
    private List<String> scientistKnownFor;

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

    public String getScientistDateOfBirth() {
        return scientistDateOfBirth;
    }

    public void setScientistDateOfBirth(String scientistDateOfBirth) {
        this.scientistDateOfBirth = scientistDateOfBirth;
    }

    public String getScientistDateOfDeath() {
        return scientistDateOfDeath;
    }

    public void setScientistDateOfDeath(String scientistDateOfDeath) {
        this.scientistDateOfDeath = scientistDateOfDeath;
    }

    public String getScientistProfilePicture() {
        return scientistProfilePicture;
    }

    public void setScientistProfilePicture(String scientistProfilePicture) {
        this.scientistProfilePicture = scientistProfilePicture;
    }

    public String getScientistBio() {
        return scientistBio;
    }

    public void setScientistBio(String scientistBio) {
        this.scientistBio = scientistBio;
    }

    public String getScientistEducation() {
        return scientistEducation;
    }

    public void setScientistEducation(String scientistEducation) {
        this.scientistEducation = scientistEducation;
    }

    public String getScientistUniversity() {
        return scientistUniversity;
    }

    public void setScientistUniversity(String scientistUniversity) {
        this.scientistUniversity = scientistUniversity;
    }

    public String getScientistCountries() {
        return scientistCountries;
    }

    public void setScientistCountries(String scientistCountries) {
        this.scientistCountries = scientistCountries;
    }

    public String getScientistFieldOfStudy() {
        return scientistFieldOfStudy;
    }

    public void setScientistFieldOfStudy(String scientistFieldOfStudy) {
        this.scientistFieldOfStudy = scientistFieldOfStudy;
    }

    public List<String> getScientistAwards() {
        return scientistAwards;
    }

    public void setScientistAwards(List<String> scientistAwards) {
        this.scientistAwards = scientistAwards;
    }

    public List<String> getScientistKnownFor() {
        return scientistKnownFor;
    }

    public void setScientistKnownFor(List<String> scientistKnownFor) {
        this.scientistKnownFor = scientistKnownFor;
    }


}
