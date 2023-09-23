package lab05.PagaLeva;

public class TermicBottle extends Container {
    Portion portion;
    public TermicBottle(Portion portion) {
        this.portion = portion;
    }
    
    public String toString()
    {
        return "TermicBottle with portion = " + portion.toString();
    }
}
