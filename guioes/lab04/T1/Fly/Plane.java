package lab03.Fly;

import java.util.HashMap;
import java.util.Map;

public class Plane implements PlaneInterface {
    private Map<String, Flight> flights;

    public Plane() {
        this.flights = new HashMap<>();
    }

    public void addFlight(String flight_code, int tourist_rows, int tourist_cols, int executive_rows,
            int executive_cols) {
        if (!flights.containsKey(flight_code)) {
            Flight flight = new Flight(flight_code, tourist_rows, tourist_cols, executive_rows, executive_cols);
            flights.put(flight_code, flight);
            System.out.print(flight.getInfo());
        } else {
            System.err.println("Voo já existe");
        }
    }

    public void addFlight(String flight_code, int tourist_rows, int tourist_cols) {
        if (!flights.containsKey(flight_code)) {
            Flight flight = new Flight(flight_code, tourist_rows, tourist_cols);
            flights.put(flight_code, flight);
            System.out.print(flight.getInfo());
        } else {
            System.err.println("Voo já existe");
        }
    }

    public boolean addReservation(String flight_code, Category category, int num_seats) {
        if (flights.containsKey(flight_code)) {
            return flights.get(flight_code).addReservation(category, num_seats);
        } else {
            return false;
        }
    }

    public void cancelReservation(String flight_code, int reserv_num) {
        if (flights.containsKey(flight_code)) {
            if (!flights.get(flight_code).cancelReservation(reserv_num)) {
                System.err.println("Reserva não existe");
            }
        } else {
            System.err.println("Voo não existe");
        }
    }

    public void printFlight(String flight_code) {
        if (flights.containsKey(flight_code)) {
            System.out.println(flights.get(flight_code).toString());
            System.out.println(" ");
        } else {
            System.err.println("Voo não existe");
        }
    }
}
