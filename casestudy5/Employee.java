package casestudy5;

public class Employee {

    private String employeeId;
    private String name;
    private String role;
    private double baseSalary;
    private double finalSalary;

    public Employee(String employeeId, String name, String role, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double calculateSalary() {

        switch (role) {

            case "Manager":
                finalSalary = baseSalary + (baseSalary * 0.20);
                break;

            case "Developer":
                finalSalary = baseSalary + (baseSalary * 0.10);
                break;

            case "Designer":
                finalSalary = baseSalary + (baseSalary * 0.05);
                break;

            case "Intern":
                finalSalary = 1000;
                break;

            default:
                finalSalary = baseSalary;
                break;
        }

        return finalSalary;
    }

    public void applyDeduction(double amount) {
        finalSalary -= amount;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Final Salary: " + finalSalary);
        System.out.println("-----------------------------");
    }
}

