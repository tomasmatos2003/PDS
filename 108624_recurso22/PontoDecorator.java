public abstract class PontoDecorator implements TipoGeometria{
    protected TipoGeometria ponto;

    public PontoDecorator (TipoGeometria deco) {
        this.ponto = deco;
    }

    public void draw() {
        ponto.draw();
    }
    
    public boolean isValid(){
        return ponto.isValid();
    }
}   
