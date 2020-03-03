package util;

import puzzle.Board;
import puzzle.Info;

public class CheckUtil {
	public static boolean check(Board board) {
		for (int[] arrow : Info.ARROWS) {
			if (board.board[arrow[0] / Info.WIDTH][arrow[0] % Info.WIDTH] == 0) continue;
			if (board.board[arrow[1] / Info.WIDTH][arrow[1] % Info.WIDTH] == 0) continue;
			int less = IndexConvertUtil.convert(board.board[arrow[0] / Info.WIDTH][arrow[0] % Info.WIDTH]);
			int more = IndexConvertUtil.convert(board.board[arrow[1] / Info.WIDTH][arrow[1] % Info.WIDTH]);
			if (less >= more) return false;
		}
		return true;
	}
}
