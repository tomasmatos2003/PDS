package lab03.Fly;

public interface FlightInterface {
    public boolean addReservation(Category category, int num_seats);
    public boolean cancelReservation(int reserv_num);
}
