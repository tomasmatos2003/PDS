package lab07.ex1;

import java.util.Date;

public class TeamLeader extends EmployeeDecorator {
    public TeamLeader(EmployeeInterface employee) {
        super(employee);
    }

    @Override
    public void work() {
        super.work();
        System.out.print(" as TeamLeader");
    }

    public void start(Date date) {
        System.out.println("\n(TeamLeader) Started " + this.getName() +
                "\nDate: " + date.toString());
    }

    public void terminate(Date date) {
        System.out.println("\n(TeamLeader) Terminated " + this.getName() +
                "\nDate: " + date.toString());
    }

    public void plan() {
        System.out.println("\n -- planning --\n");
    }

}
