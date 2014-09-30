package model;

import java.awt.Point;

public abstract class PossibleMove {

	public PossibleMove() {
		
	}

	abstract public Point play(TicTacToe game);
	
}
