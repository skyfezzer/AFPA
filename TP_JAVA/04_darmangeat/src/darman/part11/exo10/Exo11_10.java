package darman.part11.exo10;

import java.text.NumberFormat;
import java.util.Locale;

public class Exo11_10 {
	private static final int EMPTY_SLOT_VALUE = 0;
	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
		int[][] sudoku = new int[9][9];
		// testSudoku();

		fillGridRandomly(sudoku);

		printGrid(sudoku);

	}

	private static void testSudoku() {
		int[][] testSudoku = { 
				{ 1, 4, 8, 2, 7, 5, 6, 9, 3 }, { 3, 9, 6, 4, 1, 8, 7, 5, 2 }, { 5, 7, 2, 3, 9, 6, 1, 4, 8 }, 
				{ 8, 5, 7, 6, 2, 4, 3, 1, 9 }, { 6, 1, 9, 8, 3, 7, 5, 2, 4 }, { 2, 3, 4, 9, 5, 1, 8, 7, 6 }, 
				{ 4, 6, 1, 5, 8, 2, 9, 3, 7 }, { 9, 2, 5, 7, 6, 3, 4, 8, 1 }, { 7, 8, 3, 1, 4, 9, 2, 6, 5 } };
		System.out.printf("rowsOK(testSudoku)=%s,colsOK(testSudoku)=%s,squaresOK(testSudoku)=%s\n", rowsOK(testSudoku),
				colsOK(testSudoku), squaresOK(testSudoku));

	}

	private static boolean tousDifferents(int[] ar) {

		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[j] == 0)
					continue;
				if (ar[j] == ar[i]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean rowsOK(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			if (!tousDifferents(ar[i])) {
				return false;
			}
		}

		return true;
	}

	private static boolean colsOK(int[][] ar) {
		int[] col = new int[9];
		for (int i = 0; i < ar.length; i++) {

			for (int j = 0; j < ar[i].length; j++) {
				col[j] = ar[j][i];
			}

			if (!tousDifferents(col)) {
				return false;
			}
		}

		return true;
	}

	private static boolean squaresOK(int[][] ar) {
		int[] square = new int[9];
		for (int basei = 0; basei <= 6; basei += 3) {
			for (int basej = 0; basej <= 6; basej += 3) {
				for (int shifti = 0; shifti <= 2; shifti++) {
					for (int shiftj = 0; shiftj <= 2; shiftj++) {
						square[shifti * 3 + shiftj] = ar[basei + shifti][basej + shiftj];
					}
				}
				if (!tousDifferents(square)) {
					return false;
				}
			}
		}
		return true;
	}

	private static void fillGridRandomly(int[][] ar) {

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				ar[i][j] = (int) (Math.random() * 9) + 1;
				if(!tousDifferents(getRow(i,ar))) {
					setRow(i, ar, 0);
				}
				if(!tousDifferents(getCol(j,ar))) {
					setCol(j, ar, 0);
				}
				if(!tousDifferents(getSquare(i,j,ar))) {
					setSquare(i, j, ar, 0);
				}
				
				/*do {
					ar[i][j] = (int) (Math.random() * 9) + 1;
				} while (!(tousDifferents(getRow(i, ar)) 
						&& tousDifferents(getCol(j, ar))
						&& tousDifferents(getSquare(i, j, ar))));*/
			}
		}
	}

	private static int[] getRow(int index, int[][] ar) {
		int[] result = new int[9];
		for (int i = 0; i < ar.length; i++) {
			result[i] = ar[index][i];
		}
		return result;
	}

	private static void setRow(int index, int[][] ar, int value) {
		for (int i = 0; i < ar.length; i++) {
			ar[index][i] = value;
		}
	}

	private static int[] getCol(int index, int[][] ar) {
		int[] result = new int[9];
		for (int i = 0; i < ar.length; i++) {
			result[i] = ar[i][index];
		}
		return result;
	}

	private static void setCol(int index, int[][] ar, int value) {
		for (int i = 0; i < ar.length; i++) {
			ar[i][index] = value;
		}
	}

	private static int[] getSquare(int x, int y, int[][] ar) {
		int[] result = new int[9];

		int xCase = Math.floorDiv(x, 3) * 3;
		int yCase = Math.floorDiv(y, 3) * 3;
		for (int i = xCase, cpt = 0; i < xCase + 3; i++) {
			for (int j = yCase; j < yCase + 3; j++) {
				result[cpt++] = ar[i][j];
			}
		}
		return result;
	}

	private static void setSquare(int x, int y, int[][] ar, int value) {
		int xCase = Math.floorDiv(x, 3) * 3;
		int yCase = Math.floorDiv(y, 3) * 3;
		for (int i = xCase; i < xCase + 3; i++) {
			for (int j = yCase; j < yCase + 3; j++) {
				ar[i][j] = value;
			}
		}
	}

	private static void printGrid(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print(ar[i][j] + " | ");
			}
			System.out.println("\n-----------------------------------");
		}
	}

}
