package lab03.Fly;

public class Flight implements FlightInterface {

    private String flight_code;
    // number of the next reservation
    private int reserv_num = 1;
    private Seat[][] executive_seats;
    private Seat[][] tourist_seats;
    private boolean has_executive_seats;

    public Flight(String flight_code, int tourist_rows, int tourist_cols, int executive_rows, int executive_cols) {
        this(flight_code, tourist_rows, tourist_cols);
        executive_seats = new Seat[executive_rows][executive_cols];
        has_executive_seats = true;
        for (int i = 0; i < executive_rows; i++) {
            for (int j = 0; j < executive_cols; j++) {
                executive_seats[i][j] = new Seat();
            }
        }
    }

    public Flight(String flight_code, int tourist_rows, int tourist_cols) {
        this.flight_code = flight_code;
        tourist_seats = new Seat[tourist_rows][tourist_cols];
        for (int i = 0; i < tourist_rows; i++) {
            for (int j = 0; j < tourist_cols; j++) {
                tourist_seats[i][j] = new Seat();
            }
        }
        has_executive_seats = false;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código de voo ");
        sb.append(flight_code);
        sb.append(". Lugares Disponíveis: ");
        if (has_executive_seats) {
            sb.append(executive_seats.length * executive_seats[0].length);
            sb.append(" lugares em classe Executiva; ");
            sb.append(tourist_seats.length * tourist_seats[0].length);
            sb.append(" lugares em classe Turística.\n");
        } else {
            sb.append(tourist_seats.length * tourist_seats[0].length);
            sb.append(" lugares em classe Turística.\n");
            sb.append("Classe Executiva não disponível neste voo.\n");
        }
        return sb.toString();
    }

    public boolean addReservation(Category category, int num_seats) {
        if (category == Category.EXECUTIVE) {
            if (has_executive_seats) {
                for (int row = 0; row < executive_seats.length; row++) {
                    if (isFreeRow(row, category)) {
                        return fillReservation(row, 0, num_seats, category);
                    }
                }
                return fillReservation(0, 0, num_seats, category);
            } else {
                return false;
            }
        } else if (category == Category.TOURIST) {
            for (int row = 0; row < tourist_seats.length; row++) {
                if (isFreeRow(row, category)) {
                    return fillReservation(row, 0, num_seats, category);
                }
            }
            return fillReservation(0, 0, num_seats, category);
        } else {
            return false;
        }
    }

    public boolean cancelReservation(int reserv_n) {
        if (reserv_n > reserv_num) {
            return false;
        } else {
            for (int i = 0; i < tourist_seats.length; i++) {
                for (int j = 0; j < tourist_seats[i].length; j++) {
                    tourist_seats[i][j].cancelReservation(reserv_n);
                }
            }
            if (has_executive_seats) {
                for (int i = 0; i < executive_seats.length; i++) {
                    for (int j = 0; j < executive_seats[i].length; j++) {
                        executive_seats[i][j].cancelReservation(reserv_n);
                    }
                }
            }
        }
        return true;
    }

    // private functions to keep functions clean:
    private boolean isFreeRow(int row, Category c) {
        if (c == Category.EXECUTIVE) {
            for (int i = 0; i < executive_seats[row].length; i++) {
                if (executive_seats[row][i].isOccupied()) {
                    return false;
                }
            }
            return true;
        } else if (c == Category.TOURIST) {
            for (int i = 0; i < tourist_seats[row].length; i++) {
                if (tourist_seats[row][i].isOccupied()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean fillReservation(int row, int col, int num_seats, Category category) {
        if (num_seats == 0) {
            reserv_num++;
            return true;
        }

        if (category == Category.EXECUTIVE) {
            if (row >= executive_seats.length) { // abort
                cancelReservation(reserv_num);
                return false;
            }

            if (!executive_seats[row][col].isOccupied()) {
                executive_seats[row][col].addReservation(reserv_num);
                num_seats--;
            }
            col++;
            if (col >= executive_seats[row].length) {
                col = 0;
                row++;
            }
        } else if (category == Category.TOURIST) {
            if (row >= tourist_seats.length) { // abort
                cancelReservation(reserv_num);
                return false;
            }

            if (!tourist_seats[row][col].isOccupied()) {
                tourist_seats[row][col].addReservation(reserv_num);
                num_seats--;
            }
            col++;
            if (col >= tourist_seats[row].length) {
                col = 0;
                row++;
            }
        } else {
            return false;
        }
        return fillReservation(row, col, num_seats, category);
    }

    @Override
    public String toString() {
        int max_rows = tourist_seats.length;
        int max_cols = tourist_seats[0].length;

        StringBuilder sb = new StringBuilder();
        if (has_executive_seats) {
            max_rows += executive_seats.length;
            if (executive_seats[0].length > max_cols) {
                max_cols = executive_seats[0].length;
            }
        }
        sb.append("   ");
        for (int i = 0; i < max_rows; i++) {
            sb.append(String.format(" %2d", i + 1));
        }
        sb.append("\n");
        for (int col = 0; col < max_cols; col++) {
            sb.append((char) (col + 65));
            sb.append("  ");
            if (has_executive_seats) {
                for (int row = 0; row < executive_seats.length; row++) {
                    if (col < executive_seats[row].length) {
                        sb.append(String.format(" %2s", executive_seats[row][col].toString()));
                    } else {
                        sb.append("   ");
                    }
                }
            }
            for (int row = 0; row < tourist_seats.length; row++) {
                if (col < tourist_seats[row].length) {
                    sb.append(String.format(" %2s", tourist_seats[row][col].toString()));
                } else {
                    sb.append("   ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();

    }

    @Override
    public int hashCode() {
        return flight_code.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Flight) {
            return flight_code == ((Flight) o).flight_code;
        }
        return false;
    }

}
