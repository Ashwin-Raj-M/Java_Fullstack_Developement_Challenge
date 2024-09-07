/* 14. Write a Java program to create a class called "School" with attributes 
for students, teachers, and classes, and methods to add and remove students and teachers, and to create classes.
 */
package Java_refference.oops_exercises.Question_14;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        School school1 = new School();
        School school2 = new School();
        School school3 = new School();

        school1.addStudents("Ashwin");
        school1.addStudents("Dheepauk");
        school1.addStudents("Veera");

        school2.addStudents("Ash");
        school2.addStudents("Dheep");
        school2.addStudents("Veer");

        school3.addStudents("A");
        school3.addStudents("D");
        school3.addStudents("V");

        ArrayList<String> students = school1.getStudents();

        for(String student : students){
            System.out.print(student + " ");
        }
    }
}
