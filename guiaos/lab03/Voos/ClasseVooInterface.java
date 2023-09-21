package lab03.Voos;

import java.util.List;

public interface ClasseVooInterface {

    boolean reserva(int numeroDeReserva, int numeroDeLugares);

    boolean cancelarReserva(int numeroDeReserva);

    List<String> listaLugaresReserva(int numeroDeReserva);

    int consultarReserva(int lugar, int fila);

    char classe();

    int lugaresPorFila();

    int numeroDeFilas();

    int lugaresDisponiveis();

    int totalDeLugares();

}