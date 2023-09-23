package lab03.Voos;

import java.util.ArrayList;
import java.util.List;

public class ClasseVoo implements ClasseVooInterface {

    private char classe;
    private int lugaresPorFila;
    private int numeroDeFilas;
    private int lugaresDisponiveis;
    private int totalDeLugares;
    private int[][] reservasBancos;

    public ClasseVoo(char classe, int numeroDeFilas, int lugaresPorFila) {
        this.classe = classe;
        this.numeroDeFilas = numeroDeFilas;
        this.lugaresPorFila = lugaresPorFila;
        this.totalDeLugares = numeroDeFilas * lugaresPorFila;
        this.lugaresDisponiveis = this.totalDeLugares;
        this.reservasBancos = new int[lugaresPorFila][numeroDeFilas];
    }

    @Override
    public boolean reserva(int numeroDeReserva, int numeroDeLugares) {
        int i, j, k, lugaresReservados = 0;
        if (numeroDeLugares < 0)
            return false;
        if (this.lugaresDisponiveis >= numeroDeLugares) {
            for (i = 0; i < this.numeroDeFilas; i++) {
                for (j = 0; j < this.lugaresPorFila; j++) {
                    if (this.reservasBancos[j][i] != 0)
                        break;
                }
                if (j == this.lugaresPorFila) {
                    for (j = 0; j < numeroDeLugares && j < this.lugaresPorFila; j++) {
                        this.reservasBancos[j][i] = numeroDeReserva;
                        lugaresReservados++;
                    }
                    if (lugaresReservados == numeroDeLugares) {
                        this.lugaresDisponiveis -= numeroDeLugares;
                        return true;
                    } else {
                        for (k = i + 1; k < this.numeroDeFilas; k++) {
                            for (j = 0; j < this.lugaresPorFila; j++) {
                                if (this.reservasBancos[j][k] == 0) {
                                    this.reservasBancos[j][k] = numeroDeReserva;
                                    lugaresReservados++;
                                }
                                if (lugaresReservados == numeroDeLugares) {
                                    this.lugaresDisponiveis -= numeroDeLugares;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            for (i = 0; i < this.numeroDeFilas; i++) {
                for (j = 0; j < this.lugaresPorFila; j++) {
                    if (this.reservasBancos[j][i] == 0) {
                        this.reservasBancos[j][i] = numeroDeReserva;
                        lugaresReservados++;
                    }
                    if (lugaresReservados == numeroDeLugares) {
                        this.lugaresDisponiveis -= numeroDeLugares;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean cancelarReserva(int numeroDeReserva) {
        boolean reservaEncontrada = false;
        int i, j;
        for (i = 0; i < this.reservasBancos.length; i++) {
            for (j = 0; j < this.reservasBancos[0].length; j++) {
                if (this.reservasBancos[i][j] == numeroDeReserva) {
                    reservaEncontrada = true;
                    this.reservasBancos[i][j] = 0;
                    this.lugaresDisponiveis++;
                }
            }
        }
        return reservaEncontrada;
    }

    @Override
    public List<String> listaLugaresReserva(int numeroDeReserva) {
        List<String> lugaresReserva = new ArrayList<>();
        int i, j;
        for (i = 0; i < this.reservasBancos.length; i++) {
            for (j = 0; j < this.reservasBancos[0].length; j++) {
                if (this.reservasBancos[i][j] == numeroDeReserva) {
                    lugaresReserva.add(String.format("%d%c", j + 1, 'A' + i));
                }
            }
        }
        return lugaresReserva;
    }

    @Override
    public int consultarReserva(int lugar, int fila) {
        return this.reservasBancos[lugar][fila];
    }

    @Override
    public char classe() {
        return classe;
    }

    @Override
    public int lugaresPorFila() {
        return lugaresPorFila;
    }

    @Override
    public int numeroDeFilas() {
        return numeroDeFilas;
    }

    @Override
    public int lugaresDisponiveis() {
        return lugaresDisponiveis;
    }

    @Override
    public int totalDeLugares() {
        return totalDeLugares;
    }
}
