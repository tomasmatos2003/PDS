package lab03.Voos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        String input;
        String[] tokensInput;
        Scanner sc;
        Map<String, VooInterface> voos = new HashMap<>();

        if (args.length == 1) {
            try {
                sc = new Scanner(new File("lab03/Voos/" + args[0]));
            } catch (FileNotFoundException e) {
                System.err.println("Ficheiro de comandos não encontrado!");
                return;
            } catch (Exception e) {
                System.err.println("Erro a abrir o ficheiro!");
                return;
            }
        } else {
            sc = new Scanner(System.in);
            System.out.println("Escolha uma opção: (H para ajuda): ");
        }

        input = sc.nextLine();

        while (input.equals("Q") == false) {

            if (args.length == 1) {
                System.out.println(input);
            }
            tokensInput = input.split(" ");

            switch (tokensInput[0]) {

                case "H":
                    System.out.println("H - Ajuda");
                    System.out.println("I <nome do ficheiro> - Lê um ficheiro de texto contento informação sobre um voo");
                    System.out.println("M <codigo de voo> - exibe o mapa das reservas de um voo");
                    System.out.println(
                            "F <codigo de voo> <num_lugares_executiva>(opcional) <num_lugares_turista> - acrescenta um novo voo, com código, lugares em executiva e turista ou apenas lugares em turista");
                    System.out.println(
                            "R <codigo de voo> <classe> <num_lugares> - acrescenta uma nova reserva a um voo, com indicação do código do voo, da classe (T / E), e do número de lugares");
                    System.out.println("C <codigo de reserva> - formato codigoVoo:numReserva - cancela uma reserva");
                    System.out.println("Q - termina o programa");
                    break;
                case "I":
                    lerFicheiroDeVoo(Arrays.copyOfRange(tokensInput, 1,tokensInput.length), voos);
                    break;
                case "M":
                    imprimirMapa(Arrays.copyOfRange(tokensInput, 1,tokensInput.length), voos);
                    break;
                case "F":
                    adicionarVoo(Arrays.copyOfRange(tokensInput, 1,tokensInput.length), voos);
                    break;
                case "R":
                    reservarLugares(Arrays.copyOfRange(tokensInput, 1,tokensInput.length), voos);
                    break;
                case "C":
                    cancelarReserva(Arrays.copyOfRange(tokensInput, 1,tokensInput.length), voos);
                    break;
                default:
                    System.out.println("----- Opção inválida -----");
                    break;
            }

            System.out.println();

            if (args.length != 1) {
                System.out.println("Escolha uma opção: (H para ajuda): ");
            }

            input = sc.nextLine();
        }

        System.out.println("----- Acabou -----");
        sc.close();
    }

    private static void imprimirMapa(String[] tokensInput, Map<String, VooInterface> voos) {
        if (tokensInput.length != 1) {
            System.err.println("Uso inválido -> M <codigo de voo>");
            return;
        }
        String codigoVoo = tokensInput[0];
        if (!Voo.codigoValido(codigoVoo))
            return;
        else if (!voos.containsKey(codigoVoo))
            System.err.println("Código de voo inexistente!");
        else
            voos.get(codigoVoo).mapaDeReservas();
    }

    private static void cancelarReserva(String[] tokensInput, Map<String, VooInterface> voos) {
        String[] reserva;
        if (tokensInput.length != 1 || (reserva = tokensInput[0].split(":")).length != 2) {
            System.err.println("Uso inválido -> C <codigo de reserva> (Formato -> codigo_voo:num_reserva)");
            return;
        }
        int numeroReserva = 0;
        String codigoVoo = reserva[0];
        if (!Voo.codigoValido(codigoVoo))
            return;
        try {
            numeroReserva = Integer.parseInt(reserva[1]);
            if (numeroReserva <= 0)
                throw new IllegalArgumentException();
        } catch (Exception e) {
            System.err.println("Número de reserva inválido!");
            return;
        }
        if (!voos.containsKey(codigoVoo))
            System.err.println("Código de voo inexistente!");
        else {
            if (voos.get(codigoVoo).cancelarReserva(numeroReserva))
                System.out.printf("Reserva %s cancelada.\n", tokensInput[0]);
            else
                System.err.println("Reserva não encontrada!");
        }
        
    }

    private static void reservarLugares(String[] tokensInput, Map<String, VooInterface> voos) {
        if (tokensInput.length != 3) {
            System.err.println("Uso inválido -> R <codigo de voo> <classe> <num_lugares>");
            return;
        }
        String codigoVoo = tokensInput[0];
        if (!Voo.codigoValido(codigoVoo))
            return;
        if (!voos.containsKey(codigoVoo)){
            System.err.println("Código de voo inexistente!");
            return;
        }
        if (!tokensInput[1].matches("[ET]")) {
            System.err.println("Classe inválida! Tem de ser E ou T");
            return;
        }
        char classe = tokensInput[1].charAt(0);
        int lugares;
        try {
            lugares = Integer.parseInt(tokensInput[2]);
            if (lugares <= 0)
                throw new IllegalArgumentException();
        } catch (Exception e) {
            System.err.println("Numero de lugares inválido! Tem de ser um inteiro positivo");
            return;
        }
        voos.get(codigoVoo).reservaDeLugares(classe, lugares);
        String output = String.format("%s:%d = ", codigoVoo, voos.get(codigoVoo).numeroDeReserva());
        for (String lugar : voos.get(codigoVoo).listaLugaresReserva()) {
            output += String.format("%s | ", lugar);
        }
        System.out.println(output.substring(0, output.length() - 3));
    }

    private static void adicionarVoo(String[] tokensInput, Map<String, VooInterface> voos) {
        if (tokensInput.length != 2 && tokensInput.length != 3) {
            System.err.println("Uso inválido -> F <codigo de voo> <num_lugares_executiva>(opcional) <num_lugares_turista>");
            return;
        }
        String codigoVoo = tokensInput[0];
        if (!Voo.codigoValido(codigoVoo))
            return;
        Voo novoVoo;
        if (tokensInput.length == 2) {
            String lugaresTuristica = tokensInput[1];
            try {
                novoVoo = new Voo(codigoVoo, lugaresTuristica);
            } catch (IllegalArgumentException e) {
                System.err.println("Erro no formato filas x Lugares -> NxM");
                return;
            }
        } else {
            String lugaresExecutiva = tokensInput[1];
            String lugaresTuristica = tokensInput[2];
            try {
                novoVoo = new Voo(codigoVoo, lugaresExecutiva, lugaresTuristica);
            } catch (IllegalArgumentException e) {
                System.err.println("Erro no formato filas x Lugares -> NxM");
                return;
            }
        }
        novoVoo.detalhesDoVoo();
        voos.put(codigoVoo, novoVoo);
    }

    private static void lerFicheiroDeVoo(String[] tokensInput, Map<String, VooInterface> voos) {
        if (tokensInput.length != 1) {
            System.err.println("Uso inválido -> I <nome de ficheiro>");
            return;
        }
        String filename = tokensInput[0];
        VooInterface voo = null;
        String codigo, lugaresTuristica, lugaresExecutiva, linha;
        String[] tokensLinha;
        try {
            File ficheiroVoo = new File("lab03/Voos/" + filename);
            Scanner scannerFicheiro = new Scanner(ficheiroVoo);
            String erro = "Uso inválido -> ><CodigoVoo> <NxM classe executiva> <IxJ classe Turistica>";
            erro += "ou ><CodigoVoo> <IxJ classe Turistica>";
            if (scannerFicheiro.hasNextLine()) {
                linha = scannerFicheiro.nextLine();
                if (linha.startsWith(">")) {
                    tokensLinha = linha.split(" ");
                    codigo = tokensLinha[0].substring(1);
                    if (!Voo.codigoValido(codigo)) {
                        erro = "Código de voo inválido! Tem de ser alfabético!";
                        imprimirErroFecharScanner(scannerFicheiro, erro);
                        return;
                    }
                    if (tokensLinha.length == 2) {
                        lugaresTuristica = tokensLinha[1];
                        try {
                            voo = new Voo(codigo, lugaresTuristica);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Erro no formato filas x Lugares -> NxM");
                            scannerFicheiro.close();
                            return;
                        }
                    } else if (tokensLinha.length == 3) {
                        lugaresExecutiva = tokensLinha[1];
                        lugaresTuristica = tokensLinha[2];
                        try {
                            voo = new Voo(codigo, lugaresExecutiva, lugaresTuristica);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Erro no formato filas x Lugares -> NxM");
                            scannerFicheiro.close();
                            return;
                        }
                    } else {
                        imprimirErroFecharScanner(scannerFicheiro, erro);
                        return;
                    }
                    voo.detalhesDoVoo();
                    voos.put(voo.codigo(), voo);
                } else {
                    imprimirErroFecharScanner(scannerFicheiro, erro);
                    return;
                }
            }
            erro = "Uso inválido -> <classe (E ou T)> <numero_lugares>";
            while (scannerFicheiro.hasNextLine()) {
                linha = scannerFicheiro.nextLine();
                tokensLinha = linha.split(" ");
                if (tokensLinha.length != 2 || !tokensLinha[0].matches("[ET]")) {
                    System.err.println(erro + " : " + linha);
                    continue;
                }
                try {
                    voo.reservaDeLugares(tokensLinha[0].charAt(0),
                        Integer.parseInt(tokensLinha[1]));
                } catch (Exception e) {
                    System.err.println(erro + " : " + linha);
                }
            }
            scannerFicheiro.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERRO! Ficheiro não encontrado!");
        }
    }

    private static void imprimirErroFecharScanner(Scanner scannerFicheiro, String erro) {
        System.err.println(erro);
        scannerFicheiro.close();
    }

}
