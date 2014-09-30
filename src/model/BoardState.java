package model;

import java.awt.Point;

public abstract class BoardState {

	public BoardState() {
	}

	public abstract boolean isEmpty() ;
	
	abstract public Point smartMoveForComputer(TicTacToe game,ComputerPlayer computer);
	
	public Point possiblePlay(TicTacToe game,ComputerPlayer computer) {
		return new AnyMovementInTheBoard().nextMoveFor(game,computer);
	}

	public boolean isWithPosibleWinningGameState() {
		return false;
	}
	
	public boolean isWithoutPosibleWinningGameState(){
		return false;
	}
}
