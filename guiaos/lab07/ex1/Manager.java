package lab07.ex1;

import java.util.Date;

public class Manager extends EmployeeDecorator {
    public Manager(EmployeeInterface employee) {
        super(employee);
    }

    @Override
    public void work() {
        super.work();
        System.out.print(" as Manager");
    }

    public void start(Date date) {
        System.out.println("\n(Manager) Started " +
                this.getName() + "\nDate: " + date.toString());
    }

    public void terminate(Date date) {
        System.out.println("\n(Manager) Terminated " +
                this.getName() + "\nDate: " + date.toString());
    }

    public void manage() {
        System.out.println("\n -- managing -- \n");
    }

}
