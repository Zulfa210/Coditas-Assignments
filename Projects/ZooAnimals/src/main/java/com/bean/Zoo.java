package com.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */

@Entity
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "zoo_id")
    private int zooId;

    @Column(name = "zoo_name")
    private String zooName;

    @Column(name = "zoo_city")
    private String zooCity;

    @OneToMany(mappedBy = "zoo",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Animal> animalList;


    public Zoo() {
       animalList = new ArrayList<>();
    }

    public Zoo(int zooId, String zooName, String zooCity, List<Animal> animalList) {
        this.zooId = zooId;
        this.zooName = zooName;
        this.zooCity = zooCity;
        this.animalList = animalList;
    }

    public int getZooId() {
        return zooId;
    }

    public void setZooId(int zooId) {
        this.zooId = zooId;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public String getZooCity() {
        return zooCity;
    }

    public void setZooCity(String zooCity) {
        this.zooCity = zooCity;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "zooId=" + zooId +
                ", zooName='" + zooName + '\'' +
                ", zooCity='" + zooCity + '\'' +
                ", animalList=" + animalList +
                '}';
    }
}
