package darman.part11.exo10;

public class Exo11_10 {

	public static void main(String[] args) {
		int[][] sudoku = new int[9][9];
		while(!rowsOK(sudoku) || !colsOK(sudoku) || !squaresOK(sudoku))
			fillGridRandomly(sudoku);
		
		printGrid(sudoku);
	}

	private static boolean tousDifferents(int[] ar) {

		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
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
		for(int basei = 0;basei<6;basei+=3) {
			for(int basej = 0;basej<6;basej+=3) {
				for(int shifti=0;shifti<2;shifti++) {
					for(int shiftj=0;shiftj<2;shiftj++) {
						square[shifti*3+shiftj] = ar[basei+shifti][basej+shiftj];
					}
				}
				if(!tousDifferents(square)) {
					return false;
				}
			}
		}
		return true;
	}

	private static void fillGridRandomly(int[][] ar) {

		for (int i = 0; i < ar.length; i++) {
			int[] row = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			for (int j = 0; j < ar[i].length; j++) {
				boolean finished = false;
				while (!finished) {
					int k = (int) (Math.random() * 9);
					if (row[k] == 0)
						continue;
					ar[i][j] = row[k];
					row[k] = 0;
					finished = true;
				}
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
