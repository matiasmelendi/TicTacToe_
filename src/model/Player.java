package model;

import java.awt.Point;

import exceptions.InvalidMovementException;

public abstract class Player {

	private Mark assignedMark;
	
	public Player(Mark mark) {
		assignedMark=mark;
	}

	public Mark mark() {
		
		return assignedMark;
	}
	
	public void play(TicTacToe game,Point position) throws InvalidMovementException {
		game.newMovement(mark(),position);
	}

}
