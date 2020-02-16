package checker.implementation;

import java.util.List;

import Util.BFSUtil;
import checker.definition.BFSChecker;
import puzzle.Board;

public class Checker2 implements BFSChecker {

	@Override
	public boolean checkArea(int a) {
		if (a < 3 || a == 6) return false;
		return true;
	}

	@Override
	public boolean bfsCheck(Board board) {
		List<Integer> areas = BFSUtil.findEmptyArea(board);
		for (int area : areas) {
			if (!checkArea(area)) return false;
		}
		return true;
	}
}
