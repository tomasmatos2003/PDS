package lab07.ex1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("Rica Fazeres", 2);
        e.start(new Date());

        TeamMember t = new TeamMember(e);
        t.work();
        t.colaborate();

        t.terminate(new Date());
        e.terminate(new Date());

        Manager m = new Manager(new Employee("Silvia", 1));
        TeamLeader tl = new TeamLeader(m);

        tl.work();
        tl.start(new Date());
        tl.plan();

        TeamMember tm = new TeamMember(tl);
        tm.work();
        tm.colaborate();
    }
}
