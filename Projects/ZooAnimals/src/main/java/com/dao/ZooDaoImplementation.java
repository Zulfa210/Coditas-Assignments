package com.dao;

import com.bean.Animal;
import com.bean.Zoo;
import com.utils.GetEntityManager;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;

/**
 * @author Zulfa Attar
 */
public class ZooDaoImplementation implements ZooDao {
    EntityManagerFactory entityManagerFactory = GetEntityManager.getEntityManagerFactory();

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

        if (zoo != null) {
            List<Animal> animals = zoo.getAnimalList();

            for (Animal animal : animals) {
                entityManager.remove(animal);
            }
            entityManager.remove(zoo);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Library Deleted Successfully");
        } else {
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

        for (Zoo zoo : zooList) {
            System.out.println(zoo);
        }
    }

    @Override
    public void getAnimals() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Animal> zooList = entityManager.createQuery("from Animal where animal_age >4").getResultList();

        System.out.println(zooList);
    }

    @Override
    public void getAnimalsUsingCriteria() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Animal> criteriaQuery = criteriaBuilder.createQuery(Animal.class);
        Root<Animal> animalRoot = criteriaQuery.from(Animal.class);
        ParameterExpression<Float> expression = criteriaBuilder.parameter(Float.class);
        criteriaQuery.select(animalRoot).where(criteriaBuilder.gt(animalRoot.get("animalAge"), expression));

        TypedQuery<Animal> query = entityManager.createQuery(criteriaQuery);
        query.setParameter(expression, 4.0f);
        System.out.println("Age greater than 4 :");
        System.out.println(query.getResultList());

        ParameterExpression<Float> expression2 = criteriaBuilder.parameter(Float.class);
        criteriaQuery.select(animalRoot).where(criteriaBuilder.between(animalRoot.get("animalAge"), expression, expression2));

        TypedQuery<Animal> newQuery = entityManager.createQuery(criteriaQuery);
        newQuery.setParameter(expression, 2.0f);
        newQuery.setParameter(expression2, 6.0f);
        System.out.println("Age between 2 and 6");
        System.out.println(newQuery.getResultList());


//        criteriaQuery.select(criteriaBuilder.min(animalRoot.get("animalAge")));
//        TypedQuery<Animal> query1 = entityManager.createQuery(criteriaQuery);
//        System.out.println("Min");
//        System.out.println(query1.getResultList());

        criteriaQuery.select(animalRoot).where(criteriaBuilder.like(animalRoot.get("animalType"), "%Wild"));
        TypedQuery<Animal> query2 = entityManager.createQuery(criteriaQuery);
        System.out.println("Wild Animals");
        System.out.println(query2.getResultList());
//
//        CriteriaQuery<Double> cr = cb.createQuery(Double.class);
//        Root<Item> root = cr.from(Item.class);
//        cr.select(cb.avg(root.get("itemPrice")));
//        Query<Double> query = session.createQuery(cr);
//        List avgItemPriceList = query.getResultList();
//        Copy


    }


}
