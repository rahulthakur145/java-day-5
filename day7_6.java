import java.util.ArrayList;

class Student {
    String name;
    ArrayList<Double> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        double sum = 0;
        for (double g : grades) sum += g;
        return grades.size() == 0 ? 0 : sum / grades.size();
    }

    void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
    }
}
