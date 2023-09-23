package lab03.JogoDoGalo; // you may change this package

public interface JGaloInterface {
	public char getActualPlayer(); // 'O' or 'X'
	public boolean setJogada(int lin, int col); // se o indice não existir, retorna false
												// ou jogada repetida
	public boolean isFinished();   // someone wins, or no empty positions
	public char checkResult();	// who wins?
}