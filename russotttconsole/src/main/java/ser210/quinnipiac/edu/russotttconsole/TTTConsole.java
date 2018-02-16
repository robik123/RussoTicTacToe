package ser210.quinnipiac.edu.russotttconsole;

import java.io.Console;
import java.util.Scanner;

/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 *
 * @author relkharboutly
 * @date 1/5/2017 Edited by Mark Russo SER210 1/30/17
 */
public class TTTConsole {
    private static int userLoc;
    private static int player;
    public static Scanner in = new Scanner(System.in); // the input Scanner
    public static TicTacToe TTTboard = new TicTacToe(player);
    private static int tie = 0;

    /** The entry main method (the program starts here) */
    public static void main(String[] args) {
        System.out.println("Welcome To TicTacToe!!" + '\n');
        System.out.println("Lets Begin!!");
        tie = 0;
        int currentState = TicTacToe.PLAYING;
        String userLocation;
        String playAgain;

        // game loop
        do {
            TTTboard.printBoard();
            /**
             * get player input here and call setMove(). user should input a
             * number between 0-8
             */
            System.out.println("Please enter a space to place your move use 0-8");
            userLocation = in.next();
            tie = tie + 1;
            userLoc = Integer.parseInt(userLocation);

            /**
             * Takes user input from 0 - 8 and begins the game, game will prompt
             * you to enter a new location if outside range
             */
            if (userLoc >= 0 && userLoc < 9) {
                TTTboard.setPlayer(1);
                TTTboard.setMove(TTTboard.getPlayer(), userLoc);
                currentState = TTTboard.checkForWinner();

                /**
                 * Test tie game
                 */
                if (tie == 5) {
                    currentState = TTTboard.checkForWinner();
                    currentState = ITicTacToe.TIE;
                } else {

                    /**
                     * Computers turn
                     */
                    TTTboard.printBoard();
                    System.out.println("The computer is making its move....");
                    TTTboard.setMove(2, TTTboard.getPlayer());
                    currentState = TTTboard.checkForWinner();
                }

            } else {
                System.out.println("Sorry Invalid Spot Please Try Again!!" + '\n');
                TTTboard.setPlayer(1);
                tie = 0;
            }

            /**
             * prompts the game with a winner and will clear the board for a new
             * game if the user decides to play again
             */
            if (currentState == ITicTacToe.CROSS_WON) {
                System.out.println("'X' won! Bye!" + '\n');
                System.out.println("Lets Play again!! Press 'q' to Restart");
                playAgain = in.next();
                if (playAgain.equals("q")) {
                    TTTboard.clearBoard();
                }
            } else if (currentState == ITicTacToe.NOUGHT_WON) {
                TTTboard.printBoard();
                System.out.println("'O' won! Bye!" + '\n');
                System.out.println("Lets Play again!! Press 'q' to Restart");
                playAgain = in.next();
                if (playAgain.equals("q")) {
                    TTTboard.clearBoard();
                }
            } else if (currentState == ITicTacToe.TIE) {
                TTTboard.printBoard();
                System.out.println("It's a TIE! Bye!" + '\n');
                System.out.println("Lets Play again!! Press 'q' to Restart");
                playAgain = in.next();
                if (playAgain.equals("q")) {
                    TTTboard.clearBoard();
                }
            }

        } while ((currentState == ITicTacToe.PLAYING) && (!userLocation.equals("q"))); // repeat
        // if
        // not
        // game-over
    }

}