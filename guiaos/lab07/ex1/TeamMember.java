package lab07.ex1;

import java.util.Date;

public class TeamMember extends EmployeeDecorator {

    public TeamMember(EmployeeInterface employee) {
        super(employee);
    }

    @Override
    public void work() {
        super.work();
        System.out.print(" as TeamMember");
    }

    public void start(Date date) {
        System.out.println("\n(TeamMember) Started " + this.getName() +
                "\nDate: " + date.toString());
    }

    public void terminate(Date date) {
        System.out.println("\n(TeamMember) Terminated " + this.getName() +
                "\nDate: " + date.toString());
    }

    public void colaborate() {
        System.out.println("\n -- Collaborating -- \n");
    }

}
