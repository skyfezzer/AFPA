package fr.aragot.sudoku;

public class Sudoku
{
    int[] board[];
    int size;
    int racineN;
    int amountToRemove;
 
    // Constructor
    public Sudoku(int N, int K)
    {
        this.size = N;
        this.amountToRemove = K;
 
        // Compute square root of N
        Double SRNd = Math.sqrt(N);
        racineN = SRNd.intValue();
 
        board = new int[N][N];
    }
 
    // Sudoku Generator
    public void fillValues()
    {
        // Fill the diagonal of SRN x SRN matrices
        fillDiagonal();
 
        // Fill remaining blocks
        fillRemaining(0, racineN);
 
        // Remove Randomly K digits to make game
        removeKPairsOfDigits();
    }
 
    // Fill the diagonal SRN number of SRN x SRN matrices
    private void fillDiagonal()
    {
 
        for (int i = 0; i<size; i=i+racineN)
 
            // for diagonal box, start coordinates->i==j
            fillBox(i, i);
    }
 
    // Returns false if given 3 x 3 block contains num.
    private boolean unUsedInBox(int rowStart, int colStart, int num)
    {
        for (int i = 0; i<racineN; i++)
            for (int j = 0; j<racineN; j++)
                if (board[rowStart+i][colStart+j]==num)
                    return false;
 
        return true;
    }
 
    // Fill a 3 x 3 matrix.
    private void fillBox(int row,int col)
    {
        int num;
        for (int i=0; i<racineN; i++)
        {
            for (int j=0; j<racineN; j++)
            {
                do
                {
                    num = randomGenerator(size);
                }
                while (!unUsedInBox(row, col, num));
 
                board[row+i][col+j] = num;
            }
        }
    }
 
    // Random generator
    private int randomGenerator(int num)
    {
        return (int) Math.floor((Math.random()*num+1));
    }
 
    // Check if safe to put in cell
    private boolean CheckIfSafe(int i,int j,int num)
    {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBox(i-i%racineN, j-j%racineN, num));
    }
 
    // check in the row for existence
    private boolean unUsedInRow(int i,int num)
    {
        for (int j = 0; j<size; j++)
           if (board[i][j] == num)
                return false;
        return true;
    }
 
    // check in the row for existence
    private boolean unUsedInCol(int j,int num)
    {
        for (int i = 0; i<size; i++)
            if (board[i][j] == num)
                return false;
        return true;
    }
 
    // A recursive function to fill remaining
    // matrix
    private boolean fillRemaining(int i, int j)
    {
        //  System.out.println(i+" "+j);
        if (j>=size && i<size-1)
        {
            i = i + 1;
            j = 0;
        }
        if (i>=size && j>=size)
            return true;
 
        if (i < racineN)
        {
            if (j < racineN)
                j = racineN;
        }
        else if (i < size-racineN)
        {
            if (j==(int)(i/racineN)*racineN)
                j =  j + racineN;
        }
        else
        {
            if (j == size-racineN)
            {
                i = i + 1;
                j = 0;
                if (i>=size)
                    return true;
            }
        }
 
        for (int num = 1; num<=size; num++)
        {
            if (CheckIfSafe(i, j, num))
            {
                board[i][j] = num;
                if (fillRemaining(i, j+1))
                    return true;
 
                board[i][j] = 0;
            }
        }
        return false;
    }
 
    // Remove the K no. of pair of digits to
    // complete game
    private void removeKPairsOfDigits()
    {
        int count = amountToRemove;
        while (count != 0)
        {
            int cellId = randomGenerator(size*size)-1;
 
            // System.out.println(cellId);
            // extract coordinates i  and j
            int i = (cellId/size);
            int j = cellId%10;
            if (j != 0)
                j = j - 1;
 
            // System.out.println(i+" "+j);
            if (board[i][j] != 0 && board[size-1-i][size-1-j] != 0)
            {
                count--;
                board[i][j] = 0;
                board[size-1-i][size-1-j] = 0;
            }
        }
    }
 
    // Print sudoku
    public void printSudoku()
    {
        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
                //System.out.print((board[i][j]==0?" ":board[i][j]) + " ");
            	System.out.printf("%2d",board[i][j]);
            System.out.println();
        }
        System.out.println();
    }
 
    
    public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	// Driver code
    public static void main(String[] args)
    {
        int N = 9, K = 30;
        Sudoku sudoku = new Sudoku(N, K);
        sudoku.fillValues();
        sudoku.printSudoku();
    }
}