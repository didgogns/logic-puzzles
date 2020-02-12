package checker;

import java.util.*;

public abstract class BaseChecker {
	public static final int HEIGHT = 7;
	public static final int WIDTH = 12;
	
	public int[][] board = new int[HEIGHT][WIDTH];
	
	static final int[] dH = {1, -1, 0, 0};
	static final int[] dW = {0, 0, 1, -1};
	static boolean rangeCheck(int h, int w) {
		return h >= 0 && h < HEIGHT && w >= 0 && w < WIDTH;
	}
	
	int BFS(int h, int w) {
		Queue<Integer> queue = new ArrayDeque<>();
		int cnt = 1;
		queue.add(h * WIDTH + w);
		board[h][w] = -1;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			int curH = current / WIDTH;
			int curW = current % WIDTH;
			
			for (int d = 0; d < 4; d++) {
				int nh = curH + dH[d];
				int nw = curW + dW[d];
				if (!rangeCheck(nh, nw)) continue;
				if (board[nh][nw] != 0) continue;
				board[nh][nw] = -1;
				queue.add(nh * WIDTH + nw);
				cnt++;
			}
		}
		
		return cnt;
	}
	
	List<Integer> findEmptyArea() {
		List<Integer> result = new ArrayList<>();
		for (int h = 0; h < HEIGHT; h++) {
			for (int w = 0; w < WIDTH; w++) {
				if (board[h][w] == 0) result.add(BFS(h, w));
			}
		}
		for (int h = 0; h < HEIGHT; h++) {
			for (int w = 0; w < WIDTH; w++) {
				if (board[h][w] == -1) board[h][w] = 0;
			}
		}
		return result;
	}
}
