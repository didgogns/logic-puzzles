package runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import checker.definition.BaseChecker;
import checker.implementation.Checker1;
import checker.implementation.Checker2;
import checker.implementation.Checker3;
import checker.implementation.Checker45678;
import checker.implementation.CheckerFinal;
import file.BoardFile;
import piece.Piece;
import piece.PieceFiller;
import puzzle.Board;

public class Runner {
	public static List<BaseChecker> checkers = Arrays.asList(new Checker1(), new Checker2(), new Checker3(), new Checker45678(), new Checker45678(), new Checker45678(), new Checker45678(), new CheckerFinal());
	
	public void runDFS() {
		try {
			Stack<Board> stk = BoardFile.readFile();
			
			long saveTime = System.currentTimeMillis();
			while (!stk.empty()) {
				Board oldBoard = stk.pop();
				int cnt = 0;
				int k = oldBoard.count;
				if (k == 8) {
					BoardFile.write(oldBoard);
					continue;
				}
				BaseChecker checker = checkers.get(k);
				if (k < 4) System.out.println("Board k: " + k);
				if (!oldBoard.skipped) {
					Board board = PieceFiller.fillPiece(oldBoard, null, 0, 0);
					if (checker.check(board)) {
						stk.add(board);
						cnt++;
					}
				}
				for (Piece piece : Piece.minos.get(k)) {
					List<Board> nextBoards = PieceFiller.fillPiece(oldBoard, piece);
					for (Board board : nextBoards) {
						if (!checker.check(board)) continue;
						stk.add(board);
						cnt++;
					}
					if (k < 4) System.out.println("wrote " + cnt + " files so far");
				}
				if (System.currentTimeMillis() > saveTime + 1000 * 600) {
					BoardFile.writeFile(stk);
					saveTime = System.currentTimeMillis();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
