package model;

import java.awt.Point;

public class EmptyBoard extends BoardState {

	@Override
	public boolean isEmpty() {
		return true;
	}
	
	@Override
	public Point smartMoveForComputer(TicTacToe game,ComputerPlayer computer){
		return possiblePlay(game,computer);
	}
}
