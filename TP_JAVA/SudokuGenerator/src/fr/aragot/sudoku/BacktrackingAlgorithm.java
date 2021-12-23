package fr.aragot.sudoku;

import java.util.stream.IntStream;

public class BacktrackingAlgorithm {


    private int BOARD_START_INDEX = 0;
    private int NO_VALUE = 0;
    private int MIN_VALUE = 1;
    private int MAX_VALUE = 9;
    
    private int boardSize = 9;
    private int subsectionSize = 3;

    private int[][] board;
    
    private static int[][] DEFAULT_BOARD = {
    {8, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 3, 6, 0, 0, 0, 0, 0},
    {0, 7, 0, 0, 9, 0, 2, 0, 0},
    {0, 5, 0, 0, 0, 7, 0, 0, 0},
    {0, 0, 0, 0, 4, 5, 7, 0, 0},
    {0, 0, 0, 1, 0, 0, 0, 3, 0},
    {0, 0, 1, 0, 0, 0, 0, 6, 8},
    {0, 0, 8, 5, 0, 0, 0, 1, 0},
    {0, 9, 0, 0, 0, 0, 4, 0, 0}
  };

    public BacktrackingAlgorithm() {
    	this(DEFAULT_BOARD);
    }
    public BacktrackingAlgorithm(int[][] board) {
    	this.board = board;
    }
    public BacktrackingAlgorithm(Sudoku sudoku) {
    	this.board = sudoku.getBoard();
    }
    public static void main(String[] args) {
    	
        BacktrackingAlgorithm solver = new BacktrackingAlgorithm();
        solver.solve();
        solver.printBoard();
        
    }
    public void printBoard() {
        for (int row = BOARD_START_INDEX; row < boardSize; row++) {
            for (int column = BOARD_START_INDEX; column < boardSize; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }
    public boolean solve() {
        for (int row = BOARD_START_INDEX; row < boardSize; row++) {
            for (int column = BOARD_START_INDEX; column < boardSize; column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solve()) {
                            return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int column) {
        return rowConstraint(board, row) &&
          columnConstraint(board, column) &&
          subsectionConstraint(board, row, column);
    }

    private boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[boardSize];
        int subsectionRowStart = (row / subsectionSize) * subsectionSize;
        int subsectionRowEnd = subsectionRowStart + subsectionSize;

        int subsectionColumnStart = (column / subsectionSize) * subsectionSize;
        int subsectionColumnEnd = subsectionColumnStart + subsectionSize;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[boardSize];
        return IntStream.range(BOARD_START_INDEX, boardSize)
          .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    private boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[boardSize];
        return IntStream.range(BOARD_START_INDEX, boardSize).allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column] != NO_VALUE) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}