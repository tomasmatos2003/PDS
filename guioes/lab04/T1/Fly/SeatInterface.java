package lab03.Fly;

public interface SeatInterface {
    public boolean addReservation(int reserv_num);
    public boolean cancelReservation(int reserv_num);
    public boolean isOccupied();
}
