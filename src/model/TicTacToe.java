package model;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import exceptions.InvalidMovementException;

public class TicTacToe {
	
	private TicTacToeBoard board;

	public TicTacToe() {
		board= new TicTacToeBoard();
	}

	public boolean boardIsEmpty() {
		return board.isEmpty();
	}
	
	public BoardState boardState(){
		return board.state();
	}
	
	public void newMovement(Mark mark,Point position) throws InvalidMovementException{
		this.board.newMovement(mark, position);
	}

	public List<Cell> unmarkedCells(){
		return board.cells().stream().filter(cell -> cell.isEmpty()).collect(Collectors.toList());
	}
	
	public boolean theWinnerIs(Player player) {
		return anyRowCompleteWith(player.mark());
	}

	private boolean anyRowCompleteWith(Mark mark) {
		return possibleRows().stream().anyMatch(row -> completeWith(row,mark));
	}

	private boolean completeWith(List<Cell> row, Mark mark) {
		return row.stream().allMatch(cell -> cell.mark()==mark);
	}

	private List<List<Cell>> possibleRows() {
		return board.possibleRows();
	}

	public Point nextPositionForPlay() {
		return possibleWinningRowsForPlayAndNoLose().get(0)
				.stream().filter(cell-> cell.isEmpty()).findAny().get().position();
	}

	private List<List<Cell>> possibleWinningRowsForPlayAndNoLose(){
		return possibleRows().stream().filter(row -> isAWinningRowFor(row)).collect(Collectors.toList());
	}

	private boolean isAWinningRowFor(List<Cell> row) {
		Map<Mark, List<Cell>> marks=row.stream().collect(Collectors.groupingBy(cell->cell.mark()));
		marks.remove(new Unmarked());		
		return marks.values().stream().anyMatch(cells -> cells.size()== 2);
	}
	

}
