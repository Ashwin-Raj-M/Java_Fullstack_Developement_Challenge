/* 29. Write a Java program to create a class called "Pet" with attributes for name, species, and age. Create 
subclasses "Dog" and "Bird" that add specific attributes like favorite toy for dogs and wing span for birds. 
Implement methods to display pet details and calculate the pet's age in human years.
 */

package Java_refference.oops_exercises.Question_29;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Dogs> dogs;
    private ArrayList<Birds> birds;

    public Shop(){
        dogs = new ArrayList<Dogs>();
        birds = new ArrayList<Birds>();
    }

    public void addPets(Dogs dog){
        dogs.add(dog);
    }

    public void addPets(Birds bird){
        birds.add(bird);
    }

    public ArrayList<Dogs> getDogs() {
        return dogs;
    }

    public ArrayList<Birds> getBirds() {
        return birds;
    }

    public void details(Pets pet){
        pet.getDetails();
    }
}
