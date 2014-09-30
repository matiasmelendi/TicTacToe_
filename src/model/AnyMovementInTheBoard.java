package model;

import java.awt.Point;

public class AnyMovementInTheBoard extends PossibleMove {

	public AnyMovementInTheBoard() {
		
	}

	@Override
	public Point play(TicTacToe game) {
		return game.unmarkedCells().stream().findAny().get().position();
	}

}
