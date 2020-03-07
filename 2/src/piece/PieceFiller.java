package piece;

import java.util.ArrayList;
import java.util.List;

import puzzle.Board;
import puzzle.Info;

public class PieceFiller {
	public static Board fillPiece(Board oldBoard, Piece piece, int height, int width) {
		Board board = new Board();
		for (int h = 0; h < Info.HEIGHT; h++) {
			for (int w = 0; w < Info.WIDTH; w++) {
				board.board[h][w] = oldBoard.board[h][w];
			}
		}
		board.count = oldBoard.count + 1;
		board.skipped = oldBoard.skipped;
		if (piece == null) {
			if (oldBoard.skipped) {
				return null;
			}
			board.skipped = true;
			return board;
		}
		for (Piece.Point point : piece.points) {
			if (board.board[height + point.h][width + point.w] != 0) {
				return null;
			}
			board.board[height + point.h][width + point.w] = piece.kind;
		}
		return board;
	}
	
	public static List<Board> fillPiece(Board oldBoard, Piece piece) {
		List<Board> boardList = new ArrayList<Board>();
		for (int h = 0; h < Info.HEIGHT - piece.maxH; h++) {
			for (int w = 0; w < Info.WIDTH - piece.maxW; w++) {
				Board board = fillPiece(oldBoard, piece, h, w);
				if (board != null) boardList.add(board);
			}
		}
		return boardList;
	}
}
