/* 29. Write a Java program to create a class called "Pet" with attributes for name, species, and age. Create 
subclasses "Dog" and "Bird" that add specific attributes like favorite toy for dogs and wing span for birds. 
Implement methods to display pet details and calculate the pet's age in human years.
 */

package Java_refference.oops_exercises.Question_29;

public class Birds extends Pets{
    private double wingSpan;
    private String species;

    public Birds(String name, String colour, int age, double wingSpan, String species){
        super(name, colour, age);
        this.wingSpan = wingSpan;
        this.species = species;
    }

    public double getWingSpan(){
        return wingSpan;
    }

    public void setWingSpan(int wingSpan){
        this.wingSpan = wingSpan;
    }

    public String getSpecies(){
        return species;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public int hAgeCalc(){
        return 2 * super.getAge();
    }

    @Override
    public void getDetails(){
        super.getDetails();
        System.out.println("WingSpan: " + wingSpan + "\nSpecies: " + species + "\nHuman Age: " + hAgeCalc()); 
    }
}