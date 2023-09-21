package lab03.Voos;

import java.util.List;

public class Voo implements VooInterface {

    private String codigo;
    private Aviao aviao;
    private int numeroDeReserva = 0;

    public Voo(String codigo, String filasXlugaresExecutiva, String filasXlugaresTuristica)
            throws IllegalArgumentException {
        if (!Voo.codigoValido(codigo)) {
            throw new IllegalArgumentException("Código de voo inválido, tem de ser alfabético.");
        }
        if (!filasXlugaresExecutiva.matches("[1-9][0-9]*x[1-9][0-9]*") || !filasXlugaresTuristica.matches("[1-9][0-9]*x[1-9][0-9]*")) {
            throw new IllegalArgumentException("Erro no formato filas x Lugares (NxM)");
        }
        String[] parametrosExecutiva = filasXlugaresExecutiva.split("x");
        String[] parametrosTuristica = filasXlugaresTuristica.split("x");
        this.codigo = codigo;
        this.aviao = new Aviao(Integer.parseInt(parametrosExecutiva[0]), Integer.parseInt(parametrosExecutiva[1]),
                Integer.parseInt(parametrosTuristica[0]), Integer.parseInt(parametrosTuristica[1]));
    }

    public Voo(String codigo, String filasXlugaresTuristica) throws IllegalArgumentException {
        if (!Voo.codigoValido(codigo)) {
            throw new IllegalArgumentException("Código de voo inválido, tem de ser alfabético.");
        }
        if (!filasXlugaresTuristica.matches("[1-9][0-9]*x[1-9][0-9]*")) {
            throw new IllegalArgumentException("Erro no formato filas x Lugares (NxM)");
        }
        String[] parametrosTuristica = filasXlugaresTuristica.split("x");
        this.codigo = codigo;
        this.aviao = new Aviao(Integer.parseInt(parametrosTuristica[0]), Integer.parseInt(parametrosTuristica[1]));
    }

    @Override
    public boolean reservaDeLugares(char classe, int numeroDeLugares) {
        boolean lugaresReservados = false;
        if (classe == 'T') {
            lugaresReservados = this.aviao.classeTuristica().reserva(++numeroDeReserva, numeroDeLugares);
        } else if (classe == 'E') {
            lugaresReservados = this.aviao.classeExecutiva().reserva(++numeroDeReserva, numeroDeLugares);
        }
        if (lugaresReservados == false) {
            numeroDeReserva--;
            System.out.printf("Não foi possível obter resultados para a reserva: %c %d\n",
                    classe, numeroDeLugares);
        }
        return lugaresReservados;
    }

    @Override
    public boolean cancelarReserva(int numeroDeReserva) {
        boolean reservaCancelada = false;
        reservaCancelada = this.aviao.classeExecutiva().cancelarReserva(numeroDeReserva);
        if (reservaCancelada == false)
            this.aviao.classeTuristica().cancelarReserva(numeroDeReserva);
        return reservaCancelada;
    }

    @Override
    public void mapaDeReservas() {
        int totalDeFilas = this.aviao.classeExecutiva().numeroDeFilas() + this.aviao.classeTuristica().numeroDeFilas();

        System.out.printf("  ");
        for (int i = 1; i <= totalDeFilas; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        int maximoLugaresPorFila = this.aviao.classeTuristica().lugaresPorFila();
        if (maximoLugaresPorFila < this.aviao.classeExecutiva().lugaresPorFila()) {
            maximoLugaresPorFila = this.aviao.classeExecutiva().lugaresPorFila();
        }
        int filasExecutiva = this.aviao.classeExecutiva().numeroDeFilas();
        for (int i = 0; i < maximoLugaresPorFila; i++) {
            System.out.printf("%c ", 'A' + i);
            for (int k = 0; k < totalDeFilas; k++) {
                if (k < filasExecutiva)
                    try {
                        System.out.printf("%2d ", this.aviao.classeExecutiva().consultarReserva(i, k));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.printf("   ");
                    }
                else {
                    try {
                        System.out.printf("%2d ", this.aviao.classeTuristica().consultarReserva(i, k - filasExecutiva));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.printf("   ");
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public void detalhesDoVoo() {
        StringBuilder detalhes = new StringBuilder(String.format("Código de voo %s. Lugares disponíveis: ", this.codigo));
        if (this.aviao.classeExecutiva().lugaresDisponiveis() > 0) {
            detalhes.append(String.format("%d lugares em classe Executiva; ", this.aviao.classeExecutiva().totalDeLugares())); 
            detalhes.append(String.format("%d lugares em classe Turística.", this.aviao.classeTuristica().totalDeLugares()));
        } else {
            detalhes.append(String.format("%d lugares em classe Turistica.\n", this.aviao.classeTuristica().totalDeLugares()));
            detalhes.append("Classe executiva não disponível neste voo.");
        }
        System.out.println(detalhes.toString());
    }

    @Override
    public List<String> listaLugaresReserva() {
        List<String> lugaresReserva = this.aviao.classeExecutiva().listaLugaresReserva(numeroDeReserva);
        lugaresReserva.addAll(this.aviao.classeTuristica().listaLugaresReserva(numeroDeReserva));
        return lugaresReserva;
    }

    @Override
    public String codigo() {
        return codigo;
    }

    @Override
    public int numeroDeReserva() {
        return numeroDeReserva;
    }

    public static boolean codigoValido(String codigoVoo) {
        if (!codigoVoo.matches("[a-zA-Z0-9]+")) {
            System.err.println("Código de voo tem de ser alfabético.");
            return false;
        }
        return true;
    }
}
