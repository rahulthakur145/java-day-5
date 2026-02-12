package casestudy2;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<Double>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.size() == 0) {
            return 0.0;
        }

        double sum = 0;
        for (double g : grades) {
            sum += g;
        }

        return sum / grades.size();
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
        System.out.println("----------------------------");
    }
}

