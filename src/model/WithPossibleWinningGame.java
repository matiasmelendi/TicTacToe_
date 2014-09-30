package model;

import java.awt.Point;

public class WithPossibleWinningGame extends BoardState {

	@Override
	public Point possiblePlay(TicTacToe game) {
		return new MarkThePossibleWinningCell().play(game);
	}

	@Override
	public boolean isEmpty() {return false;}

	public boolean isWithPosibleWinningGameState() {return true;}

}
