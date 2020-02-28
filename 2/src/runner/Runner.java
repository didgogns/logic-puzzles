package runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
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
	
	public void run(int k) {
		System.out.println("run: " + k);
		BaseChecker checker = checkers.get(k);
		try {
			Stream<Path> filePathStream = Files.walk(Paths.get("data/" + k));
			//System.out.println("# files: " + filePathStream.count());
			filePathStream.forEach(filePath -> {
				try {
					if (Files.isRegularFile(filePath)) {
						System.out.println("file start");
						String text = Files.readAllLines(filePath).get(0);
						Board oldBoard = BoardFile.read(text, k);
						int cnt = 0;
						for (Piece piece : Piece.minos.get(k)) {
							List<Board> nextBoards = PieceFiller.fillPiece(oldBoard, piece);
							for (Board board : nextBoards) {
								if (!checker.check(board)) continue;
								BoardFile.write(board);
								cnt++;
							}
						}
						System.out.println("file end, write " + cnt + " files");
						Files.delete(filePath);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			filePathStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
