package casestudy2;

import java.util.ArrayList;
import java.util.List;

public class GradeManager {

    private List<Student> students;

    public GradeManager() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.size() == 0) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                s.displayStudentDetails();
            }
        }
    }
}
