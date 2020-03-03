package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import puzzle.Board;
import puzzle.Info;

public class BoardFile {
	public static String toString(Board board) {
		StringBuilder sb = new StringBuilder(Info.HEIGHT * Info.WIDTH);
		for (int[] row : board.board) {
			for (int cell : row) sb.append(cell);
		}
		sb.append(board.count);
		return sb.toString();
	}
	
	public static void write(Board board) throws IOException {
		String str = toString(board);
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str + ".txt"));
		bufferedWriter.write(str);
		bufferedWriter.close();
	}
	
	public static Board read(String text) {
		Board board = new Board();
		board.count = Integer.valueOf(text.charAt(Info.HEIGHT * Info.WIDTH) - '0');
		boolean[] appeared = new boolean[board.count];
		for (int i = 0; i < Info.HEIGHT * Info.WIDTH; i++) {
			int cur = Integer.valueOf(text.charAt(i) - '0');
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
	
	public static void writeFile(Stack<Board> boardList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
		
		for (Board board : boardList) {
			bw.write(toString(board));
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
	
	public static Stack<Board> readFile() throws IOException {
		Stack<Board> result = new Stack<Board>();
		
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		String line = br.readLine();
		while (line != null) {
			result.add(read(line));
			line = br.readLine();
		}
		br.close();
		return result;
	}
}
