package lab03.Jogo_Galo;

public class JGaloBackend implements JGaloInterface {
    private Square[][] board;
    private char currentPlayer;
    private char winner;

    public JGaloBackend(char player){
        this.board = new Square[3][3];
        this.currentPlayer = player;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.board[i][j] = new Square(i, j);
            }
        }
    }

    public char getActualPlayer(){
        return this.currentPlayer;
    }

    public boolean setJogada(int row, int col){
        //to adjust with "arrays start with 0"
        row--;
        col--;
        System.out.println("row: " + row + " col: " + col);
        if(this.board[row][col].isSelected()){
            return false;
        }
        this.board[row][col].select(this.currentPlayer);
        if(this.currentPlayer == 'X'){
            this.currentPlayer = 'O';
        } else {
            this.currentPlayer = 'X';
        }
        return true;
    }

    public boolean isFinished(){
        //check if all are occupied
        boolean isFinished = true;
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                if(!this.board[row][col].isSelected()){
                    isFinished = false;
                }
            }
        }

        if(isFinished){
            winner=' ';
            return true;
        }
        //horizontal check
        for(int row=0; row<3; row++){
            if(board[row][0].getValue()==board[row][1].getValue() && board[row][0].getValue()==board[row][2].getValue() && board[row][0].getValue()!=' '){
                winner=board[row][0].getValue();
                return true;
            }
        }
        //vertical check
        for(int col=0; col<3; col++){
            if(board[0][col].getValue()==board[1][col].getValue() && board[0][col].getValue()==board[2][col].getValue() && board[0][col].getValue()!=' '){
                winner=board[0][col].getValue();
                return true;
            }
        }

        //diagonal checks
        if(board[0][0].getValue()==board[1][1].getValue() && board[0][0].getValue()==board[2][2].getValue() && board[0][0].getValue()!=' '){
            winner=board[0][0].getValue();
            return true;
        }

        if(board[0][2].getValue()==board[1][1].getValue() && board[0][2].getValue()==board[2][0].getValue() && board[0][2].getValue()!=' '){
            winner=board[0][2].getValue();
            return true;
        }
        return false;
    }

    public char checkResult(){
        return winner;
    }
}
