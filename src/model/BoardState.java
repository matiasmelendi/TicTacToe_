package model;

import java.awt.Point;

public abstract class BoardState {

	public BoardState() {
	}

	public abstract boolean isEmpty() ;
	
	public Point possiblePlay(TicTacToe game) {
		return new AnyMovementInTheBoard().play(game);
	}

	public boolean isWithPosibleWinningGameState() {
		return false;
	}
	
	public boolean isWithoutPosibleWinningGameState(){
		return false;
	}
}
