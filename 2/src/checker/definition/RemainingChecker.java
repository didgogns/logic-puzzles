package checker.definition;

import Util.RemainingCheckUtil;
import puzzle.Board;

public class RemainingChecker implements BaseChecker {

	public boolean check(Board board) {
		return RemainingCheckUtil.remainingCheck(board);
	}
}
