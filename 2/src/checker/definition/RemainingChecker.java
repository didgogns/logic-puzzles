package checker.definition;

import java.io.FileNotFoundException;

import file.BoardFile;
import puzzle.Board;
import puzzle.Info;
import util.CheckUtil;
import util.RemainingCheckUtil;

public class RemainingChecker implements BaseChecker {

	public boolean check(Board board) {
		return RemainingCheckUtil.remainingCheck(board) && CheckUtil.check(board);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String str = "0000000000000107000000000177000000050070000000056003020000056603220000056003000000007";
		Board board = BoardFile.read(str);
		System.out.println(RemainingCheckUtil.remainingCheck(board));
		System.out.println(CheckUtil.check(board));
	}
}
