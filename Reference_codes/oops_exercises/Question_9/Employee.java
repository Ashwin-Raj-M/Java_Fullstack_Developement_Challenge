package Java_refference.oops_exercises.Question_9;

import java.time.Period;
import java.time.LocalDate;

public class Employee {
    String name;
    float salary;
    LocalDate date;

    public Employee(String name, float salary, LocalDate date){
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    public int years(){
        return Period.between(LocalDate.now(), date).getYears();
    }
}
