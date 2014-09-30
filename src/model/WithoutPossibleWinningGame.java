package model;

import java.awt.Point;


public class WithoutPossibleWinningGame extends BoardState {

	@Override
	public boolean isEmpty() {
		return false;
	}

	public boolean isWithoutPosibleWinningGameState(){
		return true;
	}

	@Override
	public Point smartMoveForComputer(TicTacToe game, ComputerPlayer computer) {
		return new SearchAndMarkACellNextToAnotherWithTheSameMark().nextMoveFor(game,computer);
	}

}
