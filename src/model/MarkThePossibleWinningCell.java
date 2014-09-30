package model;

import java.awt.Point;

public class MarkThePossibleWinningCell extends PossibleMove {

	@Override
	public Point play(TicTacToe game) {
		return game.nextPositionForPlay();
	}

}
