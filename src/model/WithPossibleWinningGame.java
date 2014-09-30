package model;

import java.awt.Point;

public class WithPossibleWinningGame extends BoardState {

	@Override
	public Point possiblePlay(TicTacToe game,ComputerPlayer computer) {
		return new MarkThePossibleWinningCell().nextMoveFor(game,computer);
	}

	@Override
	public boolean isEmpty() {return false;}

	public boolean isWithPosibleWinningGameState() {return true;}

	@Override
	public Point smartMoveForComputer(TicTacToe game, ComputerPlayer computer) {
		return new MarkThePossibleWinningCell().nextMoveFor(game,computer);
	}

}
