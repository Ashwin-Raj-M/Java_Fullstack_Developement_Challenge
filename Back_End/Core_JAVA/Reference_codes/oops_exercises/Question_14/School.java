package Java_refference.oops_exercises.Question_14;

import java.util.ArrayList;

public class School {
    private ArrayList<Integer> classes;
    private ArrayList<String> students;
    private ArrayList<String> teachers;

    public School(){
        classes = new ArrayList<Integer>();
        students = new ArrayList<String>();
        teachers = new ArrayList<String>();
    }

    public ArrayList<Integer> getClasses() {
        return classes;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public void addStudents(String student){
        students.add(student);
    }

    public void removeStudents(String student){
        students.add(student);
    }

    public void addTeachers(String student){
        students.add(student);
    }

    public void removeTeachers(String student){
        students.add(student);
    }
}
