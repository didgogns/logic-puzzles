package checker;

import puzzle.Board;

public class Checker1 extends NumberChecker {

	@Override
	public int getMinForZero() {
		return 3;
	}

	@Override
	boolean checkArea(int a) {
		if (a < 3) return false;
		return true;
	}

	@Override
	boolean check(Board board) {
		if (!super.bfsCheck(board)) return false;
		if (!super.numberCheck(board)) return false;
		return true;
	}
	
}
