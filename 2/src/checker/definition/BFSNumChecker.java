package checker.definition;

import java.util.List;

import Util.BFSUtil;
import puzzle.Board;
import puzzle.Info;

public abstract class BFSNumChecker implements BFSChecker, NumberChecker, BaseChecker {

	public boolean bfsCheck(Board board) {
		List<Integer> areas = BFSUtil.findEmptyArea(board);
		for (int area : areas) {
			if (!checkArea(area)) return false;
		}
		return true;
	}
	
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
	
	public boolean check(Board board) {
		return numberCheck(board) && bfsCheck(board);
	}
}
