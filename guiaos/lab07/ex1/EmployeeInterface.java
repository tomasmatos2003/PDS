package lab07.ex1;

import java.util.Date;

public interface EmployeeInterface {
    void start(Date date);
    void terminate(Date date);
    void work();
    String getName();
}
