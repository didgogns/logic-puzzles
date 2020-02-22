package piece;

public class Piece {
	static class Point {
		int h;
		int w;

		Point(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}

	public Point[] points;
	public int kind;

	private Piece() {
	}

	private Piece(Point[] points, int kind) {
		this.points = points;
		this.kind = kind;
	}

	static Point[][] pt = new Point[4][4];
	public static Piece[] domino;
	public static Piece[] vTrimino;
	public static Piece[] iTrimino;
	public static Piece[] lTetromino;
	public static Piece[] nTetromino;
	public static Piece[] tTetromino;
	public static Piece[] iTetromino;
	public static Piece[] oTetromino;
	static {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				pt[i][j] = new Point(i, j);
		}

		domino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1] }, 1),
				new Piece(new Point[] { pt[0][0], pt[1][0] }, 1) };

		vTrimino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1], pt[1][0] }, 2),
				new Piece(new Point[] { pt[0][0], pt[0][1], pt[1][1] }, 2),
				new Piece(new Point[] { pt[0][0], pt[1][0], pt[1][1] }, 2),
				new Piece(new Point[] { pt[0][1], pt[1][0], pt[1][1] }, 2) };

		iTrimino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1], pt[0][2] }, 3),
				new Piece(new Point[] { pt[0][0], pt[1][0], pt[2][0] }, 3) };

		lTetromino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1], pt[0][2], pt[1][0] }, 4),
				new Piece(new Point[] { pt[0][0], pt[0][1], pt[0][2], pt[1][2] }, 4),
				new Piece(new Point[] { pt[0][0], pt[0][1], pt[1][0], pt[2][0] }, 4),
				new Piece(new Point[] { pt[0][0], pt[0][1], pt[1][1], pt[2][1] }, 4),
				new Piece(new Point[] { pt[0][0], pt[1][0], pt[1][1], pt[1][2] }, 4),
				new Piece(new Point[] { pt[0][0], pt[1][0], pt[2][0], pt[2][1] }, 4),
				new Piece(new Point[] { pt[0][1], pt[1][1], pt[2][0], pt[2][1] }, 4),
				new Piece(new Point[] { pt[0][2], pt[1][0], pt[1][1], pt[1][2] }, 4) };

		nTetromino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1], pt[1][1], pt[1][2] }, 5),
				new Piece(new Point[] { pt[0][0], pt[1][0], pt[1][1], pt[2][1] }, 5),
				new Piece(new Point[] { pt[0][1], pt[0][2], pt[1][0], pt[1][1] }, 5),
				new Piece(new Point[] { pt[0][1], pt[1][0], pt[1][1], pt[2][0] }, 5) };

		tTetromino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1], pt[0][2], pt[1][1] }, 6),
				new Piece(new Point[] { pt[0][0], pt[1][0], pt[1][1], pt[2][0] }, 6),
				new Piece(new Point[] { pt[0][1], pt[1][0], pt[1][1], pt[1][2] }, 6),
				new Piece(new Point[] { pt[0][1], pt[1][0], pt[1][1], pt[2][1] }, 6) };

		iTetromino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1], pt[0][2], pt[0][3] }, 7),
				new Piece(new Point[] { pt[0][0], pt[1][0], pt[2][0], pt[3][0] }, 7) };

		oTetromino = new Piece[] { new Piece(new Point[] { pt[0][0], pt[0][1], pt[1][0], pt[1][1] }, 7) };
	}
}
