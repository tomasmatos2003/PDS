package lab03.Fly;

public class Seat implements SeatInterface {
    private int reserv_num;

    public Seat() {
        this.reserv_num = 0;
    }

    public boolean addReservation(int reserv_num) {
        if (this.reserv_num == 0 && reserv_num > 0) {
            this.reserv_num = reserv_num;
            return true;
        }
        return false;
    }

    public boolean cancelReservation(int reserv_num) {
        if (this.reserv_num == reserv_num) {
            this.reserv_num = 0;
            return true;
        }
        return false;
    }

    public boolean isOccupied() {
        return this.reserv_num != 0;
    }

    @Override
    public String toString() {
        return Integer.toString(reserv_num);
    }
}
