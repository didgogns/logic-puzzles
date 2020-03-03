package checker.implementation;

import java.util.List;

import checker.definition.BFSChecker;
import checker.definition.BaseChecker;
import puzzle.Board;
import util.BFSUtil;
import util.CheckUtil;

public class Checker2 implements BFSChecker, BaseChecker {

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

	@Override
	public boolean check(Board board) {
		return CheckUtil.check(board) && bfsCheck(board);
	}
}
