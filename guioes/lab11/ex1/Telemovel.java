package lab11.ex1;

public class Telemovel {
    private String processador;
    private int preco;
    private int memoria;
    private int camera_px;

    public Telemovel (String processador, int preco, int memoria, int camera_px){
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camera_px = camera_px;

    }

    public int getCamera() {
        return camera_px;
    }
    public int getMemoria() {
        return memoria;
    }
    public int getPreco() {
        return preco;
    }
    public String getProcessador() {
        return processador;
    }

    public Object get(String attr) {
        if (attr.equals("processador")){
            return this.getProcessador();
        } else if (attr.equals("preco")){
            return this.getPreco();
        } else if (attr.equals("memoria")){
            return this.getMemoria();
        } else if (attr.equals("camera")){
            return this.getCamera();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Telemovel [camera_px=" + camera_px + ", memoria=" + memoria + ", preco=" + preco + ", processador="
                + processador + "]";
    }
}
