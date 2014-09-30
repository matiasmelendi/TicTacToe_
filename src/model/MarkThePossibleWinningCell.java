package model;

import java.awt.Point;

public class MarkThePossibleWinningCell extends PossibleSmartMoveForComputer {

	@Override
	public Point nextMoveFor(TicTacToe game,ComputerPlayer computer) {
		return game.nextPositionForPlay();
	}

}
