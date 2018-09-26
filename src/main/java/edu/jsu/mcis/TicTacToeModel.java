package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
        grid = new Mark[width][width];
        
        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
        for (int i = 0; i < (width); i++){ //rows
            for ( int j = 0; j < (width); j++) { //colums
                grid[i][j] = Mark.EMPTY; 
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
           
        /* INSERT YOUR CODE HERE */
        
        boolean boolMark = false;
        
        if((isValidSquare(row, col) == true) && (isSquareMarked(row, col) == false) && (xTurn == true))
        {
            grid[row][col] = Mark.X; //check graid ofr Mark sub var x
            xTurn = false;
            boolMark = true;
        }
        else if((isValidSquare(row,col) == true) && (isSquareMarked(row, col) == false) && (xTurn == false))
        {
            grid[row][col] = Mark.O;
            xTurn = true;
            boolMark = true;
            
        }
        else
        {
            boolMark = false;
        }
        
        
        
        return boolMark; /* remove this line! */
        
    }
	
    public boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
        if((row < width & row >= 0) && (col < width & col >= 0))
        {
            return true;
        }
        else
        {
            
            return false; /* remove this line! */
        }
    }
	
    public boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
        if((isValidSquare(row,col) == true) && (grid[row][col] == Mark.EMPTY)) //check to see if square is within range a 3 and marked '-'
        {
            return false;// is marked
        }
        else
        {
            return true; // is not
        }

       // return false; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
        if(isValidSquare(row,col) == true)
        {
            return grid[row][col];
        }
        else
        {
            return null; /* remove this line! */
        }   
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
        if(isMarkWin(Mark.X) == true)
        {
            return Result.X;
        }
        else if(isMarkWin(Mark.O) == true)
        {
            return Result.O;
        }
        else if(isTie() == true)
        {
            return Result.TIE;
        }
        else
        {
        return Result.NONE;
        }

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
        int counter = 0;
        boolean winner = false;

        //Check Row for win//
            for (int i = 0; i < width; ++i)
            {
                for(int j = 0; j < width; ++j)
                {
                    if(grid[i][j] == mark){
                        counter++;
                    }
                    
                    if(counter == width)
                    {
                        winner = true;
                    }
                }
            }
        //Check collumn for win//
            counter = 0;
            for(int i = 0; i < width; ++i)
            {
                for(int j = 0; j < width && j < i; ++j)
                {
                    if(grid[j][i] == mark){
                       counter++;
                    }
                    if(counter == width)
                    {
                        winner = true;
                    }
                }
             }
        //Check diagonals for win//   
            counter = 0;
            for(int i = 0; i < width; ++i) //left diagonal
            {
                if(grid[i][width-i-1] == mark)
                {
                    counter++;
                }
               
                if(counter == width)
                {
                    winner = true;
                }
            }
            
            for(int j = 0; j < width; ++j)  // right diag
         {
              if(grid[j][width-j-1] == mark)
              {
                  counter++;
              }
              
         }

          if(counter == width)
              {
                  winner = true;
              }
          
      return winner;

    }

	
    private boolean isTie() {
        
        /* Check the 
        squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        boolean tie = false;
        int counter = 0;
        
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < width ; j++)
            {
                if(grid[i][j] != Mark.EMPTY)
                {
                    counter++;
                }
            }
        }
        if (counter == (width * width))
        {
            tie = true;
        }
        return tie;
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}