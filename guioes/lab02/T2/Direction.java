package lab01;

public enum Direction {
    U("Up"),
    UR("UpRight"),
    R("Right"),
    DR("DownRight"),
    D("Down"),
    DL("DownLeft"),
    L("Left"),
    UL("UpLeft");

    public final String label;

    private Direction(String label) {
        this.label = label;
    }
}
