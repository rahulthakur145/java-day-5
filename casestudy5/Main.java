package casestudy5;

public class Main {

    public static void main(String[] args) {

        Payroll payroll = new Payroll();

        Employee e1 = new Employee("E101", "Rahul", "Manager", 50000);
        Employee e2 = new Employee("E102", "Amit", "Developer", 40000);
        Employee e3 = new Employee("E103", "Neha", "Designer", 35000);
        Employee e4 = new Employee("E104", "Riya", "Intern", 20000);

        payroll.addEmployee(e1);
        payroll.addEmployee(e2);
        payroll.addEmployee(e3);
        payroll.addEmployee(e4);

        System.out.println("Employee Salaries:");
        payroll.calculateAllSalaries();

        System.out.println("Applying Deduction to E102 (2000)");
        Employee emp = payroll.findEmployeeById("E102");

        if (emp != null) {
            emp.applyDeduction(2000);
            emp.displayEmployeeDetails();
        }
    }
}
