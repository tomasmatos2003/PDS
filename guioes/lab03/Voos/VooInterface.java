package lab03.Voos;

import java.util.List;

public interface VooInterface {

    boolean reservaDeLugares(char classe, int numeroDeLugares);

    boolean cancelarReserva(int numeroDeReserva);

    void mapaDeReservas();

    void detalhesDoVoo();

    List<String> listaLugaresReserva();

    String codigo();

    int numeroDeReserva();
}