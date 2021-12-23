package fr.aragot.sudoku.test;

import fr.aragot.sudoku.BacktrackingAlgorithm;
import fr.aragot.sudoku.Sudoku;

public class TestSudoku {
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku(9,12);
		sudoku.fillValues();
		sudoku.printSudoku();
		
		System.out.println("_________");
		
		BacktrackingAlgorithm solver = new BacktrackingAlgorithm(sudoku);
        solver.solve();
        solver.printBoard();

	}
}
