package com.dao;

import com.bean.Animal;
import com.bean.Zoo;
import com.utils.GetEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class AnimalDaoImplementation implements AnimalDao{

    EntityManagerFactory entityManagerFactory= GetEntityManager.getEntityManagerFactory();
    @Override
    public void insertAnimal(Animal animal, int zooId) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Zoo zoo = entityManager.find(Zoo.class, zooId);

        if(zoo.getAnimalList()!= null) {
            List<Animal> animalList = zoo.getAnimalList();

            animalList.add(animal);
            //entityManager.persist(zoo);
        }
        else{
            List<Animal> animals = new ArrayList<>();
            animals.add(animal);
            zoo.setAnimalList(animals);
        }
        animal.setZoo(zoo);
        entityManager.persist(animal);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public void updateAnimal(Animal animal) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Animal newAnimal = entityManager.find(Animal.class, animal.getAnimalId());
        if(newAnimal!= null) {
            newAnimal.setAnimalName(animal.getAnimalName());
            newAnimal.setAnimalType(animal.getAnimalType());
            newAnimal.setAnimalAge(animal.getAnimalAge());
        }
        else{
            System.out.println("Animal not found");
        }

       // entityManager.persist(animal);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteAnimal(int animalId, int zooId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Animal animal = entityManager.find(Animal.class, animalId);
        Zoo zoo = entityManager.find(Zoo.class, zooId);
        List<Animal> animalList = zoo.getAnimalList();
        if(animalList!= null) {
            animalList.remove(animal);
        }
        else{
            System.out.println("Animal not found");
        }

        entityManager.remove(animal);

        entityManager.persist(zoo);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


    @Override
    public Animal getAnimal(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Animal animal = entityManager.find(Animal.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return animal;
    }
}
