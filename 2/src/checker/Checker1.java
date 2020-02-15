package checker;

public class Checker1 extends BFSNumChecker {

	@Override
	public int getMinForZero() {
		return 3;
	}

	@Override
	public boolean checkArea(int a) {
		if (a < 3) return false;
		return true;
	}
	
}
