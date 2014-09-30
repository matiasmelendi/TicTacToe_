package model;

import java.awt.Point;

public class AnyMovementInTheBoard extends PossibleSmartMoveForComputer {

	public AnyMovementInTheBoard() {
		
	}

	@Override
	public Point nextMoveFor(TicTacToe game,ComputerPlayer computer) {
		return game.unmarkedCells().stream().findAny().get().position();
	}

}
