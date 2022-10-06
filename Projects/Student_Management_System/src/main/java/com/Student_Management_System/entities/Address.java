package com.Student_Management_System.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "pincode")
    private int pincode;



//@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentTemporaryAddress")

    @OneToMany(cascade = CascadeType.ALL )
    private List<Student> student;

    public Address() {
    }

    public Address(Integer addressId, int houseNumber, String areaName, String cityName, int pincode, List<Student> student) {
        this.addressId = addressId;
        this.houseNumber = houseNumber;
        this.areaName = areaName;
        this.cityName = cityName;
        this.pincode = pincode;
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", houseNumber=" + houseNumber +
                ", areaName='" + areaName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", pincode=" + pincode +
                ", student=" + student +
                '}';
    }
}
