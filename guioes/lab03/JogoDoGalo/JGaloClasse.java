package lab03.JogoDoGalo;

public class JGaloClasse implements JGaloInterface {

    private char actualPlayer = 'X';
    private char[][] grelha = new char[3][3];

    private void switchPlayer() {
        if (this.actualPlayer == 'X')
            this.actualPlayer = 'O';
        else if (this.actualPlayer == 'O')
            this.actualPlayer = 'X';
    }

    public char getActualPlayer() {
        return actualPlayer;
    }

    public boolean setJogada(int lin, int col) {
        if (lin < 1 || lin > 3 || col < 1 || col > 3)
            return false;
        if (grelha[lin-1][col-1] != '\0')
            return false;
        grelha[lin-1][col-1] = this.getActualPlayer();
        // System.out.printf("%d %d\n",lin,col);
        switchPlayer();
        return true;
    }

    public boolean isFinished() {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grelha[i][j] == 'X' || grelha[i][j] == 'O'){
                   
                    if (j == 0 && grelha[i][j] == grelha[i][j+1] && grelha[i][j] == grelha[i][j+2] ){
                        return true;
                    }
                    
                    if (i == 0 && grelha[i][j] == grelha[i+1][j] && grelha[i][j] == grelha[i+2][j]){
                        return true;
                    }
                        
                    if (i == 0 && j == 0 && grelha[i][j] == grelha[i+1][j+1] && grelha[i][j] == grelha[i+2][j+2] ){
                        return true;
                    }

                    if (i == 0 && j == 2 && grelha[i][j] == grelha[i+1][j-1] && grelha[i][j] == grelha[i+2][j-2]){
                        return true;
                    }
                }
            }  
        }

        boolean isFull = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grelha[i][j] == '\0'){
                    isFull = true;
                }
            }
        }
        
        if (isFull == false) {
            return true;
        } else {
            return false;
        }
        
    }

    public char checkResult() {
        char middleSquare = grelha[1][1];
        if (middleSquare != '\0') {
            if ((middleSquare == grelha[0][0] && middleSquare == grelha[2][2]) ||
                    middleSquare == grelha[0][2] && middleSquare == grelha[2][0])
                return middleSquare;
        }
        for (int i = 0; i < 3; i++) {
            if (grelha[i][0] == grelha[i][1] && grelha[i][0] == grelha[i][2]) {
                return grelha[i][0];
            }
            if (grelha[0][i] == grelha[1][i] && grelha[0][i] == grelha[2][i]) {
                return grelha[0][i];
            }
        }
        return ' ';
    }
    
}