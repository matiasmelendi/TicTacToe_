package model;

import java.awt.Point;

public class SearchAndMarkACellNextToAnotherWithTheSameMark extends PossibleSmartMoveForComputer {

	public SearchAndMarkACellNextToAnotherWithTheSameMark() {
		
	}
	@Override
	public Point nextMoveFor(TicTacToe game,ComputerPlayer computer) {
		return game.smartMoveForComputer(computer);
	}

}
