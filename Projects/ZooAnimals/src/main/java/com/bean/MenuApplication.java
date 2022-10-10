package com.bean;

import com.dao.AnimalDao;
import com.dao.AnimalDaoImplementation;
import com.dao.ZooDao;
import com.dao.ZooDaoImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Zulfa Attar
 */
public class MenuApplication {

public void menu(){

    ZooDao zooDao = new ZooDaoImplementation();
    AnimalDao animalDao = new AnimalDaoImplementation();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try{

        int choice;
        do {
            System.out.println("0. Exit \n1. Add Zoo \n2. Add Animals \n3. Get Zoo \n4. Delete Animals" +
                    "\n5. Delete zoo\n6. Update Zoo\n7. Update Animal\n8. Show All Zoo \n9. Show Animals with age>4");
            choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice){
                case 1:
                    System.out.println("Enter Zoo name, Zoo city: ");
                    Zoo zoo = new Zoo();
                    zoo.setZooName(bufferedReader.readLine());
                    zoo.setZooCity(bufferedReader.readLine());

                    zooDao.insertZoo(zoo);
                    break;

                case 2:
                    System.out.println("Enter Zoo id: ");
                    int zooId = Integer.parseInt(bufferedReader.readLine());
                    Animal animal = new Animal();
                    System.out.println("Enter newAnimal Name, newAnimal type, newAnimal age: ");
                    animal.setAnimalName(bufferedReader.readLine());
                    animal.setAnimalType(bufferedReader.readLine());
                    animal.setAnimalAge(Float.parseFloat(bufferedReader.readLine()));

                    animalDao.insertAnimal(animal, zooId);
                    break;

                case 3:
                    System.out.println("Enter zoo Id:");
                    int zooId1 = Integer.parseInt(bufferedReader.readLine());
                    Zoo zoo1 = zooDao.getZoo(zooId1);
                    System.out.println(zoo1);
                    break;

                case 4:
                    System.out.println("Enter zoo id: ");
                    int zooDelete = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Enter Animal Id: ");
                    int animalDelete = Integer.parseInt(bufferedReader.readLine());
                    animalDao.deleteAnimal(animalDelete, zooDelete);
                    break;

                case 5:
                    System.out.println("Enter zoo Id:");
                    zooDao.deleteZoo(Integer.parseInt(bufferedReader.readLine()));
                    break;

                case 6:
                    Zoo newZoo = new Zoo();
                    System.out.println("Enter zoo ID:");
                    newZoo.setZooId(Integer.parseInt(bufferedReader.readLine()));
                    System.out.println("Enter new Zoo name, Zoo city: ");
                    newZoo.setZooName(bufferedReader.readLine());
                    newZoo.setZooCity(bufferedReader.readLine());

                    zooDao.updateZoo(newZoo);
                    break;

                case 7:
                    Animal newAnimal = new Animal();
                    System.out.println("Enter animal ID:");
                    newAnimal.setAnimalId(Integer.parseInt(bufferedReader.readLine()));
                    System.out.println("Enter new Animal Name, Animal type, Animal age: ");
                    newAnimal.setAnimalName(bufferedReader.readLine());
                    newAnimal.setAnimalType(bufferedReader.readLine());
                    newAnimal.setAnimalAge(Float.parseFloat(bufferedReader.readLine()));

                    animalDao.updateAnimal(newAnimal);
                    break;

                case 8:
                    zooDao.getAllZoo();
                    break;

                case 9:
                    zooDao.getAnimals();


                default:
                    System.out.println("Invalid Choice");
            }

        }while (choice!=0);

    }catch (Exception e){
        e.printStackTrace();
    }

}
}
