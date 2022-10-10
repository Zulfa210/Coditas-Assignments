package com.dao;

import com.bean.Animal;
import com.bean.Zoo;
import com.utils.GetEntityManager;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class ZooDaoImplementation  implements ZooDao{
    EntityManagerFactory entityManagerFactory= GetEntityManager.getEntityManagerFactory();

    @Override
    public void insertZoo(Zoo zoo) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(zoo);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateZoo(Zoo zoo) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Zoo fetchZoo = entityManager.find(Zoo.class, zoo.getZooId());
        fetchZoo.setZooName(zoo.getZooName());
        fetchZoo.setZooCity(zoo.getZooCity());
        entityManager.persist(fetchZoo);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteZoo(int zooId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Zoo zoo = entityManager.find(Zoo.class, zooId);

        if(zoo!= null) {
            List<Animal> animals = zoo.getAnimalList();

            for(Animal animal: animals){
                entityManager.remove(animal);
            }
            entityManager.remove(zoo);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Library Deleted Successfully");
        }
        else{
            System.out.println("Invalid id");
        }
//        Query query = (Query) entityManager.createQuery("delete from Zoo where zooId = " + zooId);
//        query.executeUpdate();

    }

    @Override
    public Zoo getZoo(int zooId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Zoo zoo = entityManager.find(Zoo.class, zooId);

        entityManager.getTransaction().commit();
        entityManager.close();
        return zoo;
    }

    @Override
    public void getAllZoo() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    List<Zoo> zooList = entityManager.createQuery("from Zoo").getResultList();

    for(Zoo zoo: zooList){
        System.out.println(zoo);
    }
    }

    @Override
    public void getAnimals() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Animal> zooList = entityManager.createQuery("from Animal where animal_age >4").getResultList();

        for(Animal zoo: zooList){
            System.out.println(zoo);
        }
    }
    }

