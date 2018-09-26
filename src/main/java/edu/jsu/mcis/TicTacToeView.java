package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
        int width = model.getWidth();
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
        StringBuilder board = new StringBuilder();
        
        int width = model.getWidth();
        
        board.append("\n\n  ");
        
        for (int row = 0; row < width; row++)
        {
            board.append(row);
        }
        
        board.append("\n\n");
        
        for ( int row = 0; row < width; row++)
        {
            board.append(row).append(" ");
            
            for(int col = 0;col < width; col++)
            {
                board.append(model.getMark(row,col));
            }
            board.append("\n");
        }
        System.out.println(board.toString());
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
        
        /* INSERT YOUR CODE HERE */
        if(model.isXTurn() == true)
        {
            System.out.println();
            System.out.println();
            System.out.println("Player 1 (X) Move: ");
            System.out.println("Enter the row and column numbers, separated by a space: ");
        }
        else
        {
            System.out.println();
            System.out.println();
            System.out.println("Player 2 (O) Move:");
            System.out.println("Enter the row a column numbers, separaterd by a space: ");
        }
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */
        
        /* INSERT YOUR CODE HERE */
       System.out.println("INVALID INPUT. Please try again. ");
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}