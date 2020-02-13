package checker;

import java.util.*;

import puzzle.Board;
import puzzle.Info;

public abstract class BaseChecker {
	static final int[] dH = { 1, -1, 0, 0 };
	static final int[] dW = { 0, 0, 1, -1 };

	static boolean rangeCheck(int h, int w) {
		return h >= 0 && h < Info.HEIGHT && w >= 0 && w < Info.WIDTH;
	}

	int BFS(int h, int w, Board board) {
		Queue<Integer> queue = new ArrayDeque<>();
		int cnt = 1;
		queue.add(h * Info.WIDTH + w);
		board.board[h][w] = -1;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			int curH = current / Info.WIDTH;
			int curW = current % Info.WIDTH;

			for (int d = 0; d < 4; d++) {
				int nh = curH + dH[d];
				int nw = curW + dW[d];
				if (!rangeCheck(nh, nw)) continue;
				if (board.board[nh][nw] != 0) continue;
				board.board[nh][nw] = -1;
				queue.add(nh * Info.WIDTH + nw);
				cnt++;
			}
		}

		return cnt;
	}

	List<Integer> findEmptyArea(Board board) {
		List<Integer> result = new ArrayList<>();
		for (int h = 0; h < Info.HEIGHT; h++) {
			for (int w = 0; w < Info.WIDTH; w++) {
				if (board.board[h][w] == 0) result.add(BFS(h, w, board));
			}
		}
		for (int h = 0; h < Info.HEIGHT; h++) {
			for (int w = 0; w < Info.WIDTH; w++) {
				if (board.board[h][w] == -1) board.board[h][w] = 0;
			}
		}
		return result;
	}

	abstract boolean checkArea(int a);

	public boolean bfsCheck(Board board) {
		List<Integer> areaSizes = findEmptyArea(board);
		for (int size : areaSizes) {
			if (!checkArea(size)) return false;
		}
		return true;
	}

	abstract boolean check();

}
