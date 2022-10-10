package com.dao;

import com.bean.Animal;

/**
 * @author Zulfa Attar
 */
public interface AnimalDao {

    void insertAnimal(Animal animal, int zooId);
    void updateAnimal(Animal animal);
    void deleteAnimal(int animalId, int zooId);



    Animal getAnimal(int id);
}
