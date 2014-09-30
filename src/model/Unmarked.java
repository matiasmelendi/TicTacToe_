package model;

public class Unmarked extends Mark {

	public Unmarked() {
	}

	@Override
	public boolean isUnmarked() {
		return true;
	}
	
	@Override
	public void printString() {
		System.out.printf(".");
	}
}
