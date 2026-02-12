package casestudy2;
public class Main {

    public static void main(String[] args) {

        GradeManager manager = new GradeManager();

        Student s1 = new Student("Rahul");
        Student s2 = new Student("Amit");

        manager.addStudent(s1);
        manager.addStudent(s2);

        s1.addGrade(85);
        s1.addGrade(90);
        s1.addGrade(78);

        s2.addGrade(88);
        s2.addGrade(92);

        System.out.println("All Students Details:");
        manager.displayAllStudents();

        System.out.println("Searching for Rahul:");
        Student found = manager.findStudentByName("Rahul");

        if (found != null) {
            found.displayStudentDetails();
        } else {
            System.out.println("Student not found.");
        }
    }
}

