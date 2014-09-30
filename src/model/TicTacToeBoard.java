package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.InvalidMovementException;
import model.TicTacToeMovement;

public class TicTacToeBoard {

	private List<Cell> cells= new ArrayList<Cell>();
	private BoardState state;

	public TicTacToeBoard() {
		state= new EmptyBoard();
		generateCells();
	}

	public List<Cell> cells(){return cells;}
	
	public boolean isEmpty() {
		return state.isEmpty();
	}

	public void newMovement(Mark mark, Point position) throws InvalidMovementException {
		new TicTacToeMovement(cells,position,mark);
		BoardStateProvider.stateFor(this);
	}
	
	public List<List<Cell>> possibleRows(){
		List<List<Cell>> rows= new ArrayList<List<Cell>>();
		rows.addAll(this.columns());
		rows.addAll(this.rows());
		rows.add(this.diagonal());
		
		return rows;
	}
	
	public List<Cell> diagonal() {
		List<Cell> diagonalRow=new ArrayList<Cell>();
		for(int i=0;i<3;i++)
			diagonalRow.add(getCell(i,i));
		return diagonalRow;
	}

	public List<List<Cell>> rows() {
		List<List<Cell>> rows= new ArrayList<List<Cell>>();
		for(int x=0;x<3;x++)
			rows.add(horizontalRow(x));
		return rows;
	}
	
	public List<List<Cell>> columns(){
		List<List<Cell>> rows= new ArrayList<List<Cell>>();
		for(int y=0;y<3;y++)
			rows.add(verticalRow(y));
		return rows;
	}
	
	public Point smartMoveForComputer(ComputerPlayer computer){
		return possibleSmartMovesFor(computer).stream().findAny()
				.get().stream().filter(cell->cell.isEmpty()).findAny().get().position();
	}
	
	private List<List<Cell>> possibleSmartMovesFor(ComputerPlayer computer){
		return possibleRows().stream().filter(row -> isPossibleSmartMoveFor(row,computer)).
				collect(Collectors.toList());
	}
	
	private boolean isPossibleSmartMoveFor(List<Cell> row,ComputerPlayer computer) {
		return row.stream().anyMatch(cell-> cell.mark() == computer.mark()) && 
				row.stream().filter(cell-> cell.isEmpty()).count() >= 1;
	}

	private void generateCells(){
		for(int x=0;x < 3;x++)
			generateRow(x);
	}
	
	private void generateRow(int x){
		for(int y=0;y < 3;y++)
			cells.add(new Cell(x,y));
	}
	
	private Cell getCell(int x,int y){
		return cells.stream().filter(cell -> 
				cell.inTheSamePosition(new Point(x,y))).findAny().get();
	}
	
	private List<Cell> verticalRow(int y) {
		return cells.stream().filter(cell -> cell.y() == y).collect(Collectors.toList());
	}
	

	private List<Cell> horizontalRow(int x) {
		return cells.stream().filter(cell -> cell.x()==x).collect(Collectors.toList());
	}

	public BoardState state() {
		return state;
	}

	public void changeState(BoardState state){
		this.state=state;
	}
	
	public void printString(){
		rows().forEach(row -> printRow(row));
	}
	
	private void printRow(List<Cell> row){
		row.forEach(cell -> cell.printString());System.out.println("");
	}

	

}
