package lab05.PagaLeva;

public class PlasticBottle extends Container {
    Portion portion;
    public PlasticBottle(Portion portion) {
        this.portion = portion;
    }
    
    public String toString()
    {
        return "PlasticBottle with portion = " + portion.toString();
    }
}
