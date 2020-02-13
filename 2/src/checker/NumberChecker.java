package checker;

import puzzle.Board;
import puzzle.Info;

public abstract class NumberChecker extends BaseChecker {

	public abstract int getMinForZero();

	public boolean numberCheck(Board board) {
		for (int[] arrow : Info.ARROWS) {
			int less = arrow[0];
			int more = arrow[1];
			int lessVal = board.board[less / Info.WIDTH][less % Info.WIDTH];
			int moreVal = board.board[more / Info.WIDTH][more % Info.WIDTH];
			if (lessVal == 0 && moreVal == 0) continue;
			if (lessVal == 0) lessVal = getMinForZero();
			if (moreVal == 0) moreVal = getMinForZero();
			if (lessVal >= moreVal) return false;
		}
		return true;
	}

}
