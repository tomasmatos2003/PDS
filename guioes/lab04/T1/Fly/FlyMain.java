package lab03.Fly;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FlyMain {
    public static void main(String[] args) {
        Plane plane = new Plane();
        Scanner sc;
        String[] line;
        boolean cont = true;

        if (args.length == 0) {
            sc = new Scanner(System.in);
        } else if (args.length == 1) {
            try {
                sc = new Scanner(new File("lab03/Fly/" + args[0]), "UTF-8");
            } catch (Exception e) {
                System.err.println("Error opening file " + args[0] + ":");
                e.printStackTrace();
                return;
            }
        } else {
            System.err.println("Usage: java FlyMain [ficheiro de comandos]");
            return;
        }

        while (cont) {
            System.out.println("Escolha uma opção: (H para ajuda)");
            line = sc.nextLine().split(" ");
            switch (line[0]) {
                case "H":
                    System.out.println("H - Mostrar esta ajuda");
                    System.out.println("I <ficheiro> - Lê o voo e as reservas (opcional) de um ficheiro");
                    System.out.println("M <código voo> - Mostra o mapa do voo");
                    System.out.println("F <código voo> <nº lugares executivo> <nº lugares turista> - Adiciona um voo");
                    System.out.println("R <código voo> <classe> <nº lugares> - Adiciona uma reserva");
                    System.out.println("C <código voo> <nº reserva> - Cancela uma reserva");
                    System.out.println("Q - Termina o programa");
                    break;
                case "Q":
                    System.out.println("Saindo...");
                    cont = false;
                    break;
                case "I":
                    fileRead(Arrays.copyOfRange(line, 1, line.length), plane);
                    break;
                case "M":
                    printFlight(Arrays.copyOfRange(line, 1, line.length), plane);
                    break;
                case "F":
                    addFlight(Arrays.copyOfRange(line, 1, line.length), plane);
                    break;
                case "R":
                    addReservation(Arrays.copyOfRange(line, 1, line.length), plane);
                    break;
                case "C":
                    cancelReservation(Arrays.copyOfRange(line, 1, line.length), plane);
                    break;
                default:
                    System.out.println("Comando inválido");
                    break;
            }
        }
        sc.close();
    }

    private static void fileRead(String[] line, Plane plane) {
        if (line.length == 1) {
            try {
                String flight_code = "";
                File fp = new File("lab03/Fly/" + line[0]);
                Scanner sc = new Scanner(fp, "UTF-8");
                String[] fileLine;
                fileLine = sc.nextLine().split(" ");
                if (fileLine[0].startsWith(">")) {
                    fileLine[0] = fileLine[0].substring(1);
                    if (fileLine.length == 3 || fileLine.length == 2) {
                        addFlight(fileLine, plane);
                        flight_code = fileLine[0];
                    } else {
                        System.err.println("Erro: tem de ter 2 ou 3 argumentos");
                    }
                } else {
                    System.err.println("Erro: tem de começar com '>'");
                }
                while (sc.hasNextLine()) {
                    fileLine = sc.nextLine().split(" ");
                    addReservation(fileLine, plane, flight_code);
                }
            } catch (Exception e) {
                System.err.println("Error opening file " + line[0] + ":");
                e.printStackTrace();
            }
        } else {
            System.err.println("Uso: I <ficheiro>");
        }
    }

    private static void printFlight(String[] line, Plane plane) {
        try {
            plane.printFlight(line[0]);
        } catch (Exception e) {
            System.err.println("Uso: M <código voo>");
        }
    }

    private static void addFlight(String[] line, Plane plane) {
        String tourist_seats[];
        String executive_seats[];
        try {
            if (line.length == 3) {
                tourist_seats = line[2].split("x");
                if (tourist_seats.length != 2) {
                    System.err.println("Erro: tamanho dos lugares de executivo row'x'col");
                } else if (Integer.parseInt(tourist_seats[0]) <= 0 || Integer.parseInt(tourist_seats[1]) <= 0) {
                    System.err.println("Erro: lugares de executivo tem de ser positivo");
                }

                executive_seats = line[1].split("x");
                if (tourist_seats.length != 2) {
                    System.err.println("Erro: tamanho dos lugares de turista: row'x'col");
                } else if (Integer.parseInt(executive_seats[0]) <= 0 || Integer.parseInt(executive_seats[1]) <= 0) {
                    System.err.println("Erro: lugares de turista tem de ser positivo");
                }
                plane.addFlight(line[0], Integer.parseInt(tourist_seats[0]), Integer.parseInt(tourist_seats[1]),
                        Integer.parseInt(executive_seats[0]), Integer.parseInt(executive_seats[1]));
            } else if (line.length == 2) {
                tourist_seats = line[1].split("x");
                if (tourist_seats.length != 2) {
                    System.err.println("Erro: tamanho dos lugares de executivo row'x'col");
                } else if (Integer.parseInt(tourist_seats[0]) <= 0 || Integer.parseInt(tourist_seats[1]) <= 0) {
                    System.err.println("Erro: lugares de executivo tem de ser positivo");
                }
                plane.addFlight(line[0], Integer.parseInt(tourist_seats[0]), Integer.parseInt(tourist_seats[1]));
            } else {
                System.err.println("Uso: F <código voo> <nº lugares executivo> <nº lugares turista>");
            }
        } catch (Exception e) {
            System.err.println("Uso: F <código voo> <nº lugares executivo> <nº lugares turista>");
        }

    }

    private static void addReservation(String[] line, Plane plane) {

        try {
            if (line.length == 3) {
                if (line[1].equals("E")) {
                    if (!plane.addReservation(line[0], Category.EXECUTIVE, Integer.parseInt(line[2]))) {
                        System.err.println("Não foi possível obter lugares para a reserva: " + line[1] + " " + line[2]);
                    }
                } else if (line[1].equals("T")) {
                    if (!plane.addReservation(line[0], Category.TOURIST, Integer.parseInt(line[2]))) {
                        System.err.println("Não foi possível obter lugares para a reserva: " + line[1] + " " + line[2]);
                    }
                } else {
                    System.err.println("Uso: R <código voo> <classe> <nº lugares>");
                }
            } else {
                System.err.println("Uso: R <código voo> <classe> <nº lugares>");
            }
        } catch (Exception e) {
            System.err.println("Uso: R <código voo> <classe> <nº lugares>");
        }
    }

    private static void addReservation(String[] line, Plane plane, String flight_code) {

        try {
            if (line.length == 2) {
                if (line[0].equals("E")) {
                    if (!plane.addReservation(flight_code, Category.EXECUTIVE, Integer.parseInt(line[1]))) {
                        System.err.println("Não foi possível obter lugares para a reserva: " + line[0] + " " + line[1]);
                    }
                } else if (line[0].equals("T")) {
                    if (!plane.addReservation(flight_code, Category.TOURIST, Integer.parseInt(line[1]))) {
                        System.err.println("Não foi possível obter lugares para a reserva: " + line[0] + " " + line[1]);
                    }
                } else {
                    System.err.println("Uso: R <código voo> <classe> <nº lugares>");
                }
            } else {
                System.err.println("Uso: R <código voo> <classe> <nº lugares>");
            }
        } catch (Exception e) {
            System.err.println("Uso: R <código voo> <classe> <nº lugares>");
        }
    }

    private static void cancelReservation(String[] line, Plane plane) {
        try {
            if (line.length == 2) {
                plane.cancelReservation(line[0], Integer.parseInt(line[1]));
            } else {
                System.err.println("Uso: C <código voo> <nº reserva>");
            }
        } catch (Exception e) {
            System.err.println("Uso: C <código voo> <nº reserva>");
        }
    }
}
