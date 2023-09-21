package lab11.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro("Java Anti-Stress",
                "1234567891234", "Omodionah", 2001));
        livros.add(new Livro("A Guerra dos Padrões",
                "2345678912341", "Jorge Omel", 2002));
        livros.add(new Livro("A Procura da Luz",
                "3456789123412", "Khumatkli", 2003));
        Scanner scanner = new Scanner(System.in);
        String[] inputParameters;
        boolean wasSuccessful;
        while (true) {
            wasSuccessful = false;
            System.out.println("*** Biblioteca ***");
            for (Livro livro : livros) {
                System.out.println((livros.indexOf(livro) + 1) + "\t" + livro.getTitulo() + "\t"
                        + livro.getPrimeiroAutor() + "\t[" + livro.getEstado() + "]");
            }
            System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
            while (!wasSuccessful) {
                System.out.print("\n>> ");
                String input = scanner.nextLine();
                if (input.equals("exit"))
                    break;
                inputParameters = input.split(",");
                if (inputParameters.length != 2 || Integer.parseInt(inputParameters[0]) > livros.size()) {
                    System.out.println("Input inválido");
                    continue;
                }
                switch (inputParameters[1]) {
                    case "1":
                        try {
                            livros.get(Integer.parseInt(inputParameters[0]) - 1).regista();
                            wasSuccessful = true;
                        } catch (UnsupportedOperationException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "2":
                        try {
                            livros.get(Integer.parseInt(inputParameters[0]) - 1).requisita();
                            wasSuccessful = true;
                        } catch (UnsupportedOperationException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "3":
                        try {
                            livros.get(Integer.parseInt(inputParameters[0]) - 1).devolve();
                            wasSuccessful = true;
                        } catch (UnsupportedOperationException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "4":
                        try {
                            livros.get(Integer.parseInt(inputParameters[0]) - 1).reserva();
                            wasSuccessful = true;
                        } catch (UnsupportedOperationException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "5":
                        try {
                            livros.get(Integer.parseInt(inputParameters[0]) - 1).cancelaReserva();
                            wasSuccessful = true;
                        } catch (UnsupportedOperationException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            }
            if (!wasSuccessful)
                break;
        }
        scanner.close();
    }
}
