package lab03.Fly;

public interface PlaneInterface {
    public void addFlight(String flight_code, int turist_rows, int turist_cols, int executive_rows, int executive_cols);

    public void addFlight(String flight_code, int turist_rows, int turist_cols);

    public boolean addReservation(String flight_code, Category category, int num_seats);

    public void cancelReservation(String flight_code, int reserv_num);

    public void printFlight(String flight_code);
}