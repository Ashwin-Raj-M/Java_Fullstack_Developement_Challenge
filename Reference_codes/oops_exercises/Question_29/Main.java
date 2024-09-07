/* 29. Write a Java program to create a class called "Pet" with attributes for name, species, and age. Create 
subclasses "Dog" and "Bird" that add specific attributes like favorite toy for dogs and wing span for birds. 
Implement methods to display pet details and calculate the pet's age in human years.
 */
package Java_refference.oops_exercises.Question_29;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop();

        shop.addPets(new Dogs("Jimmy", "black", 5, "ball", "lab"));
        shop.addPets(new Birds("Twek", "white", 1, 1, "hawk")); 
        shop.addPets(new Dogs("Oatmeal", "brown", 3, "chew", "pitbull"));
        shop.addPets(new Birds("Hecker", "white", 2, 0.3, "pegion")); 

        for(Birds bird: shop.getBirds()){
            shop.details(bird);
        }

        for(Dogs dog: shop.getDogs()){
            shop.details(dog);
        }  
            
    }
}
