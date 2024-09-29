/* 9. Write a Java program to create a class called "Employee" with a name, salary,
and hire date attributes, and a method to calculate years of service. */

package Java_refference.oops_exercises.Question_9;

import java.time.LocalDate;

public class Main{
    public static void main(String[] args){
        Employee employee1 = new Employee("Ashwin", 10000, LocalDate.parse("2000-12-12"));
        Employee employee2 = new Employee("Ashwin Raj", 1000000, LocalDate.parse("2003-12-12"));
        Employee employee3 = new Employee("Ashwin Marimuthu", 20000, LocalDate.parse("2013-12-12"));

        System.out.println(employee1.years());
        System.out.println(employee2.years());
        System.out.println(employee3.years());
    }
}
