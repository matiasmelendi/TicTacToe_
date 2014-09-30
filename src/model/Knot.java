package model;

public class Knot extends Mark {

	public Knot() {
	}

	@Override
	public boolean isUnmarked() {
		return false;
	}

	@Override
	public void printString() {
		System.out.printf("O");
	}

}
