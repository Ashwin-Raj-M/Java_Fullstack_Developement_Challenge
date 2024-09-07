/* 29. Write a Java program to create a class called "Pet" with attributes for name, species, and age. Create 
subclasses "Dog" and "Bird" that add specific attributes like favorite toy for dogs and wing span for birds. 
Implement methods to display pet details and calculate the pet's age in human years.
 */

package Java_refference.oops_exercises.Question_29;

public class Dogs extends Pets{
    private String toy;
    private String species;

    public Dogs(String name, String colour, int age, String toy, String species){
        super(name, colour, age);
        this.toy = toy;
        this.species = species;
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int hAgeCalc(){
        return 7 * super.getAge();
    }

    @Override
    public void getDetails(){
        super.getDetails();
        System.out.println("Favorite Toy: " + toy + "\nSpecies: " + species+ "\nHuman Age: " + hAgeCalc());
        
    }
}
