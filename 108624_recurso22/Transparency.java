public class Transparency extends PontoDecorator{
    private double percentage;
    public Transparency (TipoGeometria t, double percentage){
        super(t);
        this.percentage = percentage;
    }

    public void draw(){
        System.out.print("Transparency " + percentage + ": ");
        super.draw();

    }
}
