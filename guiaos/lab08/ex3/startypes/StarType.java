package lab08.ex3.startypes;
import java.awt.*;

public abstract class StarType {

    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;

    public StarType(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int getSize() {
        return this.size;
    }
    
}