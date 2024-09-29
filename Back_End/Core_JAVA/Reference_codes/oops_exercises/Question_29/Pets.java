/* 29. Write a Java program to create a class called "Pet" with attributes for name, species, and age. Create 
subclasses "Dog" and "Bird" that add specific attributes like favorite toy for dogs and wing span for birds. 
Implement methods to display pet details and calculate the pet's age in human years.
 */

package Java_refference.oops_exercises.Question_29;

public class Pets {
    private String name;
    private String colour;
    private int age;

    public Pets(String name, String colour, int age){
        this.name = name;
        this.colour = colour;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getDetails(){
        System.out.println("Name: " + name + "\nColour: " + colour + "\nAge: " + age);
    }
}
