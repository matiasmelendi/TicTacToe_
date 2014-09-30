package model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.InvalidMovementException;

public class TicTacToeTest {

	Player player1;
	Player player2;
	ComputerPlayer computer;
	TicTacToe ticTacToe;
	Mark knot;
	Mark cross;
	
	@Before
	public void setUp() throws Exception {
		knot= new Knot();
		cross= new Cross();
		player1= new HumanPlayer(knot);
		player2= new HumanPlayer(cross);
		computer= new ComputerPlayer(cross);
		ticTacToe=new TicTacToe();
	}

	@Test
	public void testTicTacToeStartEmpty() {
		assertTrue(ticTacToe.boardIsEmpty());
	}
	
	@Test
	public void testAPlayerDoAMovementInTheBoardIsntEmpty() throws InvalidMovementException{
		Point position= new Point(1,2);
		player1.play(ticTacToe,position);
		assertFalse(ticTacToe.boardIsEmpty());
	}
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	//The movements should be between(0,0) and (2,2)
	@Test
	public void testAPlayerDoAnInvalidMovementInTheBoard() throws InvalidMovementException{
		Point invalidPosition= new Point(10,2);
		/*expect*/thrown.expect(InvalidMovementException.class);
		/*when*/ player1.play(ticTacToe, invalidPosition);
		assertTrue(ticTacToe.boardIsEmpty());
	}
	
	//The movements should be between(0,0) and (2,2)
	@Test
	public void testAPlayerDoAMarkInAMarkedCell() throws InvalidMovementException{
		Point position= new Point(0,0);
		player1.play(ticTacToe, position);
		
		/*expect*/thrown.expect(InvalidMovementException.class);		
		/*when*/ player2.play(ticTacToe, position);
	}
	
	@Test
	public void testAComputerDoAMarkInAnEmptyBoard() throws InvalidMovementException{
		computer.play(ticTacToe);
		assertFalse(ticTacToe.boardIsEmpty());
	}
	
	@Test
	public void testBoardStateWithPosibleWinningGame() throws InvalidMovementException{
		player1.play(ticTacToe, new Point(0,0));
		player1.play(ticTacToe, new Point(1,0));
		assertTrue(ticTacToe.boardState().isWithPosibleWinningGameState());
	}
	
	@Test
	public void testComputerVSHuman() throws InvalidMovementException{
		player1.play(ticTacToe, new Point(0,0));
		player1.play(ticTacToe, new Point(1,0));
		computer.play(ticTacToe);
		/*expect*/	thrown.expect(InvalidMovementException.class);
		/*when do*/	player1.play(ticTacToe, new Point(2,0));
		assertFalse(ticTacToe.theWinnerIs(player1));
	}
	
	@Test
	public void testComputerVSHumanAndComputerWins() throws InvalidMovementException{
		player1.play(ticTacToe, new Point(0,0));
		player1.play(ticTacToe, new Point(1,0));
		computer.play(ticTacToe);
		computer.play(ticTacToe);
		computer.play(ticTacToe);
		printBoard(ticTacToe.board());
		
		assertTrue(ticTacToe.theWinnerIs(computer));
	}
	
	protected void printBoard(TicTacToeBoard board){
	
		board.printString();
	}
	
	@Test
	public void testTwoHumansPlayingAndOneWin() throws InvalidMovementException{
		player1.play(ticTacToe, new Point(0,0));
		player1.play(ticTacToe, new Point(1,0));
		player1.play(ticTacToe, new Point(2,0));
		
		assertTrue(ticTacToe.theWinnerIs(player1));
	}
	
	@Test
	public void testTwoHumansPlayingAndOneLose() throws InvalidMovementException{
		player1.play(ticTacToe, new Point(0,0));
		player1.play(ticTacToe, new Point(1,0));
		player1.play(ticTacToe, new Point(2,0));
		
		assertFalse(ticTacToe.theWinnerIs(player2));
	}
	
	@Test
	public void testTwoHumansPlayingAndNobodyWin() throws InvalidMovementException{
		player1.play(ticTacToe, new Point(0,0));
		player1.play(ticTacToe, new Point(1,0));
		player1.play(ticTacToe, new Point(0,1));
		
		assertFalse(ticTacToe.theWinnerIs(player2));
		assertFalse(ticTacToe.theWinnerIs(player1));
	}

}
