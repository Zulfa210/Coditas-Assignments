package com.dao;

import com.bean.Zoo;

/**
 * @author Zulfa Attar
 */
public interface ZooDao {
    void insertZoo(Zoo zoo);
    void updateZoo(Zoo zoo);
    void deleteZoo(int zooId);

    Zoo getZoo(int zooId);

    void getAllZoo();

    void getAnimals();

    public void getAnimalsUsingCriteria();

}
