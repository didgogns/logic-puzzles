package checker.definition;

import puzzle.Board;
import util.CheckUtil;
import util.RemainingCheckUtil;

public class RemainingChecker implements BaseChecker {

	public boolean check(Board board) {
		return RemainingCheckUtil.remainingCheck(board) && CheckUtil.check(board);
	}
}
