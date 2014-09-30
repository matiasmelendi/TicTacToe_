package model;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

final public class BoardStateProvider {

	public static void stateFor(TicTacToeBoard board){
		if(containsPossibleWinningGame(board))
			board.changeState(new WithPossibleWinningGame());
		else
			board.changeState(new WithoutPossibleWinningGame());
	}

	private static boolean containsPossibleWinningGame(TicTacToeBoard board) {
		return board.possibleRows().stream().anyMatch(row -> isPossibleWinningGame(row));
	}

	private static boolean isPossibleWinningGame(List<Cell> row){
		List<Cell> celdasNoVacias=row.stream().filter(cell -> !cell.isEmpty()).collect(Collectors.toList());
		Map<Mark, List<Cell>> marks=celdasNoVacias.stream().collect(Collectors.groupingBy(cell->cell.mark()));
		
		return celdasNoVacias.size() == 2 &&  marks.keySet().size() == 1;
	}

	public static Point nextPositionFor(TicTacToe game) {
		return game.boardState().possiblePlay(game);
	}
	
}
