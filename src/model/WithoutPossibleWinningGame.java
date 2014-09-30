package model;


public class WithoutPossibleWinningGame extends BoardState {

	@Override
	public boolean isEmpty() {
		return false;
	}

	public boolean isWithoutPosibleWinningGameState(){
		return true;
	}

}
