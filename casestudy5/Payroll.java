package casestudy5;

import java.util.ArrayList;

public class Payroll {

    private ArrayList<Employee> employees;

    public Payroll() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeById(String employeeId) {
        for (Employee e : employees) {
            if (e.getEmployeeId().equals(employeeId)) {
                return e;
            }
        }
        return null;
    }

    public void calculateAllSalaries() {
        for (Employee e : employees) {
            e.calculateSalary();
            e.displayEmployeeDetails();
        }
    }
}
