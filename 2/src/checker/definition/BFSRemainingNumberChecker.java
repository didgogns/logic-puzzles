package checker.definition;

import file.BoardFile;
import puzzle.Board;
import puzzle.Info;
import util.IndexConvertUtil;
import util.RemainingCheckUtil;

public abstract class BFSRemainingNumberChecker implements BaseChecker, NumberChecker, BFSChecker {
	
	public boolean numberCheck(Board board) {
		for (int[] arrow : Info.ARROWS) {
			int less = arrow[0];
			int more = arrow[1];
			int lessVal = IndexConvertUtil.convert(board.board[less / Info.WIDTH][less % Info.WIDTH]);
			int moreVal = IndexConvertUtil.convert(board.board[more / Info.WIDTH][more % Info.WIDTH]);
			if (lessVal == 0) lessVal = getMinForZero();
			if (moreVal == 0) moreVal = getMinForZero();
			if (lessVal >= moreVal) return false;
		}
		return true;
	}
	
	@Override
	public boolean check(Board board) {
		if (numberCheck(board) && RemainingCheckUtil.remainingCheck(board)) {
			for (int h = 0; h < Info.HEIGHT; h++) {
				for (int w = 0; w < Info.WIDTH; w++) {
					System.out.print(board.board[h][w]);
				}
				System.out.println();
			}
			System.out.println();
		}
		return numberCheck(board) && RemainingCheckUtil.remainingCheck(board) && bfsCheck(board);
	}
	
}
