package lab03.Jogo_Galo;

public class Square {
    private char value;
    private int row;
    private int col;
    private boolean isSelected;

    public Square(int row, int col){
        this.row = row;
        this.col = col;
        this.value = ' ';
        this.isSelected = false;
    }

    public boolean isSelected(){
        return this.isSelected;
    }

    public void select(char value){
        this.value = value;
        this.isSelected = true;
    }

    public char getValue(){
        return this.value;
    }
}
