package com.bean;

import javax.persistence.*;

/**
 * @author Zulfa Attar
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @Column(name="user_name")
    private String userName;
    @Column(name = "user_city")
    private String userCity;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                "\t userName='" + userName + '\'' +
                "\t userCity='" + userCity + '\'' +
                '}';
    }
}
