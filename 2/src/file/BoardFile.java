package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import puzzle.Board;
import puzzle.Info;

public class BoardFile {
	public static void write(Board board) throws IOException {
		StringBuilder sb = new StringBuilder(Info.HEIGHT * Info.WIDTH);
		for (int[] row : board.board) {
			for (int cell : row) sb.append(cell);
		}
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(board.count + "/" + sb));
		bufferedWriter.write(sb.toString());
		bufferedWriter.close();
	}
	
	public static Board read(File file, int count) throws FileNotFoundException {
		Board board = new Board();
		board.count = count;
		Scanner scanner = new Scanner(file);
		String text = scanner.next();
		scanner.close();
		boolean[] appeared = new boolean[count];
		for (int i = 0; i < Info.HEIGHT * Info.WIDTH; i++) {
			int cur = Integer.valueOf(text.charAt(i));
			board.board[i / Info.WIDTH][i % Info.WIDTH] = cur;
			if (cur != 0) appeared[cur - 1] = true;
		}
		board.skipped = false;
		for (boolean b : appeared) {
			if (!b) {
				board.skipped = true;
			}
		}
		return board;
	}
}
