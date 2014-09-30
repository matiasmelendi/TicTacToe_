package model;

import java.awt.Point;
import java.util.List;

import exceptions.InvalidMovementException;

public class TicTacToeMovement {

	public TicTacToeMovement(List<Cell> cells,Point position,Mark mark) throws InvalidMovementException {
		if(isAValidMovement(position,cells))
			cells.stream().filter(cell -> cell.inTheSamePosition(position)).findAny().get().mark(mark);
		else
			throw new InvalidMovementException();
	}

	private boolean isMarkedCellIn(Point position,List<Cell> cells){
		return cells.stream().anyMatch(cell -> (cell.inTheSamePosition(position) && !cell.isEmpty()));
	}
	
	private boolean isAValidMovement(Point position,List<Cell> cells) {
		return (position.x < 3) && (position.y < 3) && !isMarkedCellIn(position,cells);
	}

}
