package checker;

import puzzle.Board;
import puzzle.Info;

public interface NumberChecker {

	public int getMinForZero();

	public boolean numberCheck(Board board);

}
