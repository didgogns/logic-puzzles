package checker.definition;

import puzzle.Board;
import puzzle.Info;

public interface RemainingChecker {
	
	public static boolean remainingCheck(Board board) {
		int remainingPiece = (Info.FOUR_PIECE - board.count) * 4;
		for (int[] arrow : Info.ARROWS) {
			int curH = arrow[0] / Info.WIDTH;
			int curW = arrow[0] % Info.WIDTH;
			if (board.board[curH][curW] == 0) remainingPiece--;
		}
		if (remainingPiece < 0) return false;
		return true;
	}
}
