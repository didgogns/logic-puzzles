package checker.implementation;

import checker.definition.BFSNumChecker;

public class Checker3 extends BFSNumChecker {

	@Override
	public boolean checkArea(int a) {
		if (a < 4 || (a > 5 && a < 8) || a == 11) return false;
		return true;
	}

	@Override
	public int getMinForZero() {
		return 4;
	}

}
