package com.bean;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "animal_id")
    private int animalId;

    @Column(name = "animal_name")
    private String animalName;

    @Column(name = "animal_type")
    private String animalType;

    @Column(name = "animal_age")
    private float animalAge;

    @ManyToOne(cascade = CascadeType.ALL)
    private Zoo zoo;

    public Animal() {
    }

    public Animal(int animalId, String animalName, String animalType, float animalAge, Zoo zoo) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalAge = animalAge;
        this.zoo = zoo;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public float getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(float animalAge) {
        this.animalAge = animalAge;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", animalName='" + animalName + '\'' +
                ", animalType='" + animalType + '\'' +
                ", animalAge=" + animalAge +
                '}';
    }
}
