package com.bean;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressID;

    @Column(name = "address_flat_no")
    private String addressFlatNo;

    @Column(name = "address_street_name")
    private String addressStreetName;

    @Column(name = "address_city")
    private String addressCity;

    @ManyToOne()
    private  Student student;

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddressFlatNo() {
        return addressFlatNo;
    }

    public void setAddressFlatNo(String addressFlatNo) {
        this.addressFlatNo = addressFlatNo;
    }

    public String getAddressStreetName() {
        return addressStreetName;
    }

    public void setAddressStreetName(String addressStreetName) {
        this.addressStreetName = addressStreetName;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID=" + addressID +
                ", addressFlatNo='" + addressFlatNo + '\'' +
                ", addressStreetName='" + addressStreetName + '\'' +
                ", addressCity='" + addressCity + '\'' +
                '}';
    }
}
