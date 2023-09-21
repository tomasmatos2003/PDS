package lab05.PagaLeva;

public class PlasticBag extends Container{
    Portion portion;
    public PlasticBag(Portion portion) {
        this.portion = portion;
    }
    
    public String toString()
    {
        return "Tupperware with portion = " + portion.toString();
    }
}
