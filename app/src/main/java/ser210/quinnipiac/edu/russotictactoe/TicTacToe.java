package ser210.quinnipiac.edu.russotictactoe;

/**
 * Created by Mark Russo on 2/12/18.
 * Class Implements ITicTacToe
 * Methods are called in TTTActivity
 * SER210
 */

public class TicTacToe implements ITicTacToe{
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private static int[][] board = new int[ROWS][COLS]; // gam

    public TicTacToe() {

    }


    // Set up the game board and make moves
    //called through TTTActivity
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
                }
            }
            if (location == 8) {
                if (board[2][2] == EMPTY) {
                    board[2][2] = CROSS;
                }

            }
        }
    }


    //generates a random position on the board for the computer
    public int getComputerMove(){
        //generates an x and y position for the computer move
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
            board[computerMove / 3][computerMove % 3] = 2;

            //return the position on the board. used for the buttons called in TTTActivity
            if (computerMove / 3 == 0 && computerMove % 3 == 0){
                computerMove = 0;
            }
             if (computerMove / 3 == 0 && computerMove % 3 == 1){
                computerMove = 1;
            }
            if (computerMove / 3 == 0 && computerMove % 3 == 2){
                computerMove = 2;
            }
            if (computerMove / 3 == 1 && computerMove % 3 == 0){
                computerMove = 3;
            }
             if (computerMove / 3 == 1 && computerMove % 3 == 1) {
                computerMove = 4;
            }
             if (computerMove / 3 == 1 && computerMove % 3 == 2){
                computerMove = 5;
            }
            if (computerMove / 3 == 2 && computerMove % 3 == 0){
                computerMove = 6;
            }
            if (computerMove / 3 == 2 && computerMove % 3 == 1){
                computerMove = 7;
            }
            if (computerMove / 3 == 2 && computerMove % 3 == 2){
                computerMove = 8;
            }
        }
        return computerMove;
    }


    //check for winner of the game and also check for a tie
    public int checkForWinner() {
        // Check Top Row
        if (board[0][0] == CROSS && board[0][1] == CROSS && board[0][2] == CROSS) {
            return 1;
        }else if (board[0][0] == NOUGHT && board[0][1] == NOUGHT && board[0][2] == NOUGHT) {
            return 2;
        }
        // Check Middle Row
        if (board[1][0] == CROSS && board[1][1] == CROSS && board[1][2] == CROSS) {
            return 1;
        }else if (board[1][0] == NOUGHT && board[1][1] == NOUGHT && board[1][2] == NOUGHT) {
            return 2;
        }
        // Check Bottom Row
        if (board[2][0] == CROSS && board[2][1] == CROSS && board[2][2] == CROSS) {
            return 1;

        }else if (board[2][0] == NOUGHT && board[2][1] == NOUGHT && board[2][2] == NOUGHT) {
            return 2;
        }

        // Check Left Column
        if (board[0][0] == CROSS && board[1][0] == CROSS && board[2][0] == CROSS) {
            return 1;
        }else if (board[0][0] == NOUGHT && board[1][0] == NOUGHT && board[2][0] == NOUGHT) {
            return 2;
        }

        // Check Middle Column
        if (board[0][1] == CROSS && board[1][1] == CROSS && board[2][1] == CROSS) {
            return 1;
        }else if (board[0][1] == NOUGHT && board[1][1] == NOUGHT && board[2][1] == NOUGHT) {
            return 2;
        }

        // Check Right Column
        if (board[0][2] == CROSS && board[1][2] == CROSS && board[2][2] == CROSS) {
            return 1;
        }

        else if (board[0][2] == NOUGHT && board[1][2] == NOUGHT && board[2][2] == NOUGHT) {
            return 2;
        }

        // Check diagonals
        // First diagonal
        if (board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == CROSS) {
            return 1;
        }else if (board[0][0] == NOUGHT && board[1][1] == NOUGHT && board[2][2] == NOUGHT) {
            return 2;
        }

        // Second diagonal
        if (board[0][2] == CROSS && board[1][1] == CROSS && board[2][0] == CROSS) {
            return 1;
        }
        else if (board[0][2] == NOUGHT && board[1][1] == NOUGHT && board[2][0] == NOUGHT) {
            return 2;
        }

        /**
         * Check board and return tie game
         * if no slots available
         */
        if (board[0][0] != EMPTY && board[0][1] != EMPTY && board[0][2] != EMPTY && board[1][0] != EMPTY
                && board[1][1] != EMPTY && board[1][2] != EMPTY && board[2][0] != EMPTY && board[2][1] != EMPTY
                && board[2][2] != EMPTY) {
            return 3;
        }

        //game is playing
        return 0;
    }

    //clears the board and sets the board positions back to the start
    public void clearBoard(){
        board[0][0] = EMPTY;
        board[0][1] = EMPTY;
        board[0][2] = EMPTY;
        board[1][0] = EMPTY;
        board[1][1] = EMPTY;
        board[1][2] = EMPTY;
        board[2][0] = EMPTY;
        board[2][1] = EMPTY;
        board[2][2] = EMPTY;

    }
}

