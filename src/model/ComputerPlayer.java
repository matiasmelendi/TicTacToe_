package model;

import java.awt.Point;

import exceptions.InvalidMovementException;

public class ComputerPlayer extends Player {
	
	public ComputerPlayer(Mark mark) {
		super(mark);
	}

	public void play(TicTacToe game) throws InvalidMovementException {
		game.newMovement(mark(),nextPosition(game));
	}
	
	public Point nextPosition(TicTacToe game){
		return BoardStateProvider.nextSmartPositionForComputer(game,this);
	}
	
}
