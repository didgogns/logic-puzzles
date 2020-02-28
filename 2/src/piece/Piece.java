package piece;

import java.util.Arrays;
import java.util.List;

public class Piece {
	static class Point {
		int h;
		int w;

		Point(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}

	public List<Point> points;
	public int kind;
	public int maxH;
	public int maxW;

	private Piece() {
	}

	private Piece(List<Point> points, int kind) {
		this.points = points;
		this.kind = kind;
		this.maxH = 0;
		this.maxW = 0;
		for (Point point : points) {
			maxH = Math.max(maxH, point.h);
			maxW = Math.max(maxW, point.w);
		}
	}

	static Point[][] pt = new Point[4][4];
	public static List<Piece> domino;
	public static List<Piece> vTrimino;
	public static List<Piece> iTrimino;
	public static List<Piece> lTetromino;
	public static List<Piece> nTetromino;
	public static List<Piece> tTetromino;
	public static List<Piece> iTetromino;
	public static List<Piece> oTetromino;
	
	public static List<List<Piece>> minos;
	static {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				pt[i][j] = new Point(i, j);
		}

		domino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1]), 1),
				new Piece(Arrays.asList(pt[0][0], pt[1][0]), 1));

		vTrimino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[1][0]), 2),
				new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[1][1]), 2),
				new Piece(Arrays.asList(pt[0][0], pt[1][0], pt[1][1]), 2),
				new Piece(Arrays.asList(pt[0][1], pt[1][0], pt[1][1]), 2));

		iTrimino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[0][2]), 3),
				new Piece(Arrays.asList(pt[0][0], pt[1][0], pt[2][0]), 3));

		lTetromino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[0][2], pt[1][0]), 4),
				new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[0][2], pt[1][2]), 4),
				new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[1][0], pt[2][0]), 4),
				new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[1][1], pt[2][1]), 4),
				new Piece(Arrays.asList(pt[0][0], pt[1][0], pt[1][1], pt[1][2]), 4),
				new Piece(Arrays.asList(pt[0][0], pt[1][0], pt[2][0], pt[2][1]), 4),
				new Piece(Arrays.asList(pt[0][1], pt[1][1], pt[2][0], pt[2][1]), 4),
				new Piece(Arrays.asList(pt[0][2], pt[1][0], pt[1][1], pt[1][2]), 4));

		nTetromino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[1][1], pt[1][2]), 5),
				new Piece(Arrays.asList(pt[0][0], pt[1][0], pt[1][1], pt[2][1]), 5),
				new Piece(Arrays.asList(pt[0][1], pt[0][2], pt[1][0], pt[1][1]), 5),
				new Piece(Arrays.asList(pt[0][1], pt[1][0], pt[1][1], pt[2][0]), 5));

		tTetromino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[0][2], pt[1][1]), 6),
				new Piece(Arrays.asList(pt[0][0], pt[1][0], pt[1][1], pt[2][0]), 6),
				new Piece(Arrays.asList(pt[0][1], pt[1][0], pt[1][1], pt[1][2]), 6),
				new Piece(Arrays.asList(pt[0][1], pt[1][0], pt[1][1], pt[2][1]), 6));

		iTetromino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[0][2], pt[0][3]), 7),
				new Piece(Arrays.asList(pt[0][0], pt[1][0], pt[2][0], pt[3][0]), 7));

		oTetromino = Arrays.asList(new Piece(Arrays.asList(pt[0][0], pt[0][1], pt[1][0], pt[1][1]), 8));
		
		minos = Arrays.asList(domino, vTrimino, iTrimino, lTetromino, nTetromino, tTetromino, iTetromino, oTetromino);
	}
}
