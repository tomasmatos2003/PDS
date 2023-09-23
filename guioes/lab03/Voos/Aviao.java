package lab03.Voos;

public class Aviao {

    private ClasseVooInterface classeExecutiva;
    private ClasseVooInterface classeTuristica;

    public Aviao(int filasExecutiva, int lugaresPorFilaExecutiva, int filasTuristica, int lugaresPorFilaTuristica) {
        this.classeExecutiva = new ClasseVoo('E', filasExecutiva, lugaresPorFilaExecutiva);
        this.classeTuristica = new ClasseVoo('T', filasTuristica, lugaresPorFilaTuristica);
    }

    public Aviao(int filasTuristica, int lugaresPorFilaTuristica) {
        this.classeTuristica = new ClasseVoo('T', filasTuristica, lugaresPorFilaTuristica);
        this.classeExecutiva = new ClasseVoo('E', 0, 0);
    }

    public ClasseVooInterface classeExecutiva() {
        return this.classeExecutiva;
    }

    public ClasseVooInterface classeTuristica() {
        return this.classeTuristica;
    }
}
