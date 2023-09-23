public class Position {
    private int fila;
    private int column;

    public Position(int fila, int column) {
        this.fila = fila;
        this.column = column;
    }

    public int getRow() {
        return fila;
    }

    public void setRow(int fila) {
        this.fila = fila;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
