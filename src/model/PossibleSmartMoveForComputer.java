package model;

import java.awt.Point;

public abstract class PossibleSmartMoveForComputer {

	public PossibleSmartMoveForComputer() {
		
	}

	abstract public Point nextMoveFor(TicTacToe game,ComputerPlayer computer);
	
}
