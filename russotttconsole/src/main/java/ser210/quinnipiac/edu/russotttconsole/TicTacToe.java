package ser210.quinnipiac.edu.russotttconsole;

/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 1/5/2017 Edited by Mark Russo SER210 1/30/17
 */
public class TicTacToe implements ITicTacToe {

    // The game board and the game status
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private static int[][] board = new int[ROWS][COLS]; // game board in 2D	array
    private int computer = 2;
    private int player = 1;
    private int currentState;
    public static TTTConsole console = new TTTConsole();

    /**
     * Construct
     */
    public TicTacToe(int player) {
        this.player = player;
    }

    /**
     * getters and setters for switiching between user and computer
     *
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    // Clears board to start new game
    @Override
    public void clearBoard() {
        board[0][0] = EMPTY;
        board[0][1] = EMPTY;
        board[0][2] = EMPTY;
        board[1][0] = EMPTY;
        board[1][1] = EMPTY;
        board[1][2] = EMPTY;
        board[2][0] = EMPTY;
        board[2][1] = EMPTY;
        board[2][2] = EMPTY;
        console.main(null);
    }

    // set players location, seperate from computer
    public void setMove(int player, int location) {
        if (player == 1) {
            if (location == 0) {
                if (board[0][0] == EMPTY) {
                    board[0][0] = CROSS;
                }
            }
            if (location == 1) {
                if (board[0][1] == EMPTY) {
                    board[0][1] = CROSS;
                }
            }
            if (location == 2) {
                if (board[0][2] == EMPTY) {
                    board[0][2] = CROSS;

                }
            }
            if (location == 3) {
                if (board[1][0] == EMPTY) {
                    board[1][0] = CROSS;

                }
            }
            if (location == 4) {
                if (board[1][1] == EMPTY) {
                    board[1][1] = CROSS;

                }
            }
            if (location == 5) {
                if (board[1][2] == EMPTY) {
                    board[1][2] = CROSS;

                }
            }
            if (location == 6) {
                if (board[2][0] == EMPTY) {
                    board[2][0] = CROSS;

                }
            }
            if (location == 7) {
                if (board[2][1] == EMPTY) {
                    board[2][1] = CROSS;
                    setPlayer(2);
                }
            }
            if (location == 8) {
                if (board[2][2] == EMPTY) {
                    board[2][2] = CROSS;
                }

            }
        } else if (player == 2) {
            getComputerMove();

        }
    }

    /**
     * This method generates a random spot on the board that is marked as empty,
     * the method is called in setMove
     */
    public int getComputerMove() {

        // generates random number for computer
        int computerMove = (int) (Math.random() * 9);
        /**
         * Formula uses the random number and forms two coordinates on the board
         * based on the number as many times as it needs until empty spot is
         * found
         */
        while (board[computerMove / 3][computerMove % 3] != EMPTY) {
            // Regenerates a new number if spot is occupied
            computerMove = (int) (Math.random() * 9);

            /**
             * if the computer finds a empty spot it will place a O in this
             * location using the random number generated in getComputerMove
             */

        }
        if (board[computerMove / 3][computerMove % 3] == EMPTY) {
            board[computerMove / 3][computerMove % 3] = NOUGHT;

        }
        return computerMove;
    }

    /**
     * checks the game for a winner in all directions 1 = tie, 2 = Cross won, 3
     * = Nought won specified in Interface
     */
    public int checkForWinner() {

        // Check Top Row
        if (board[0][0] == CROSS && board[0][1] == CROSS && board[0][2] == CROSS)
            return 2;
        else if (board[0][0] == NOUGHT && board[0][1] == NOUGHT && board[0][2] == NOUGHT)
            return 3;

        // Check Middle Row
        if (board[1][0] == CROSS && board[1][1] == CROSS && board[1][2] == CROSS)
            return 2;
        else if (board[1][0] == NOUGHT && board[1][1] == NOUGHT && board[1][2] == NOUGHT)
            return 3;

        // Check Bottom Row
        if (board[2][0] == CROSS && board[2][1] == CROSS && board[2][2] == CROSS)
            return 2;
        else if (board[2][0] == NOUGHT && board[2][1] == NOUGHT && board[2][2] == NOUGHT)
            return 3;

        // Check Left Column
        if (board[0][0] == CROSS && board[1][0] == CROSS && board[2][0] == CROSS)
            return 2;
        else if (board[0][0] == NOUGHT && board[1][0] == NOUGHT && board[2][0] == NOUGHT)
            return 3;

        // Check Middle Column
        if (board[0][1] == CROSS && board[1][1] == CROSS && board[2][1] == CROSS)
            return 2;
        else if (board[0][1] == NOUGHT && board[1][1] == NOUGHT && board[2][1] == NOUGHT)
            return 3;

        // Check Right Column
        if (board[0][2] == CROSS && board[1][2] == CROSS && board[2][2] == CROSS)
            return 2;
        else if (board[0][2] == NOUGHT && board[1][2] == NOUGHT && board[2][2] == NOUGHT)
            return 3;

        // Check diagonals
        // First diagonal
        if (board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == CROSS)
            return 2;
        else if (board[0][0] == NOUGHT && board[1][1] == NOUGHT && board[2][2] == NOUGHT)
            return 3;

        // Second diagonal
        if (board[0][2] == CROSS && board[1][1] == CROSS && board[2][0] == CROSS)
            return 2;
        else if (board[0][2] == NOUGHT && board[1][1] == NOUGHT && board[2][0] == NOUGHT)
            return 3;

        /**
         * Check board and return tie game
         * if no slots available
         */
        if (board[0][0] != EMPTY && board[0][1] != EMPTY && board[0][2] != EMPTY && board[1][0] != EMPTY
                && board[1][1] != EMPTY && board[1][2] != EMPTY && board[2][0] != EMPTY && board[2][1] != EMPTY
                && board[2][2] != EMPTY) {
            return 1;
        }
        //game is playing
        return 0;
    }

    /**
     * Print the game board
     */
    public static void printBoard() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                printCell(board[row][col]); // print each of the cells
                if (col != COLS - 1) {
                    System.out.print("|"); // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();
    }

    /**
     * Print a cell with the specified "content"
     *
     * @param content
     *            either CROSS, NOUGHT or EMPTY
     */
    public static void printCell(int content) {
        switch (content) {
            case EMPTY:
                System.out.print("   ");
                break;
            case NOUGHT:
                System.out.print(" O ");
                break;
            case CROSS:
                System.out.print(" X ");
                break;
        }
    }

}