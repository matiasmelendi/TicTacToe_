package model;

import java.awt.Point;

public class Cell {

	private Point position;
	private Mark mark;
	
	public Cell(int x, int y) {
		position= new Point(x,y);
		mark= new Unmarked();
	}

	public boolean isEmpty() {return mark.isUnmarked();}

	public Point position() {return position;}

	public int x(){return position().x; }
	
	public int y(){return position().y; }

	public void mark(Mark mark) {this.mark=mark;}
	
	public Mark mark(){ return mark;}
	
	public boolean inTheSamePosition(Point position2) {
		return position().equals(position2);
	}
	
	public void printString(){
		System.out.printf("|");mark.printString();System.out.printf("|");
		
	}

}
