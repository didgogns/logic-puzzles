package checker.definition;

import Util.RemainingCheckUtil;
import puzzle.Board;
import puzzle.Info;

public abstract class RemainingNumberChecker implements BaseChecker, NumberChecker {
	
	public boolean numberCheck(Board board) {
		for (int[] arrow : Info.ARROWS) {
			int less = arrow[0];
			int more = arrow[1];
			int lessVal = board.board[less / Info.WIDTH][less % Info.WIDTH];
			int moreVal = board.board[more / Info.WIDTH][more % Info.WIDTH];
			if (lessVal == 0) lessVal = getMinForZero();
			if (moreVal == 0) moreVal = getMinForZero();
			if (lessVal >= moreVal) return false;
		}
		return true;
	}
	
	@Override
	public boolean check(Board board) {
		return numberCheck(board) && RemainingCheckUtil.remainingCheck(board);
	}
}
