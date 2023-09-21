package lab05.PagaLeva;

public class Tupperware extends Container {
    Portion portion;
    public Tupperware(Portion portion) {
        this.portion = portion;
    }
    
    public String toString()
    {
        return "Tupperware with portion = " + portion.toString();
    }
}
