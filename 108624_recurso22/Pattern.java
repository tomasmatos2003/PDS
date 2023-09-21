public class Pattern extends PontoDecorator{
    private String color;
    public Pattern (TipoGeometria t, String color){
        super(t);
        this.color = color;
    }

    public void draw(){
        System.out.print("Pattern " + color + ": ");
        super.draw();

    }
}
