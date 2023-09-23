public class WordInfo {
    private int length;
    private Position start;
    private Position end;
    private String direction;

    public WordInfo(int length, Position start, Position end, String direction) {
        this.length = length;
        this.start = start;
        this.end = end;
        this.direction = direction;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public Position getEnd() {
        return end;
    }

    public void setEnd(Position end) {
        this.end = end;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
