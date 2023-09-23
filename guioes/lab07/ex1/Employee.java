package lab07.ex1;

import java.util.Date;

public class Employee implements EmployeeInterface {
    private String name;
    private int employeeNumber;

    public Employee(String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void start(Date date) {
        System.out.println("\n" + this.name + " started\nDate: " + date.toString());
    }

    @Override
    public void terminate(Date date) {
        System.out.println("\n" + this.name + " terminated\nDate: " +
                date.toString());
    }

    @Override
    public void work() {
        System.out.print("\n" + this.name + " is working ");
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

}
