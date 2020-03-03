package checker.implementation;

import java.io.FileNotFoundException;
import java.util.List;

import checker.definition.BFSRemainingNumberChecker;
import file.BoardFile;
import puzzle.Board;
import util.BFSUtil;

public class CheckerFinal extends BFSRemainingNumberChecker {

	@Override
	public int getMinForZero() {
		return 5;
	}

	@Override
	public boolean checkArea(int a) {
		System.out.println(a);
		return (a % 5 == 0);
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
