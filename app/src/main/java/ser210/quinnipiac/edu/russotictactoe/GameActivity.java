package ser210.quinnipiac.edu.russotictactoe;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

import javax.xml.transform.Result;

public class GameActivity extends Activity {
    private int[][] board;
    private boolean playerMove;
    public String userName;
    public TextView result;
    public Button btn10;
    int x = 0;
    int y = 0;
    int count = 0;
    boolean winner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        board = new int[3][3];
        playerMove = true;
        if(savedInstanceState != null) {
            userName = savedInstanceState.getString("name");
        }

        // Get up the User name input and store as User
        AlertDialog.Builder name = new AlertDialog.Builder(this);
        result = (TextView) findViewById(R.id.User);
        name.setTitle("Please Enter Your Name!");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        name.setView(input);
        name.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userName = input.getText().toString();
                result.setText(input.getText());
            }
        });
        name.show();

    }

    // Set up the game board and make moves
    public void setMove(View view) {
        int id = view.getId();
        switch (id) {
            //store buttons as spaces with x and y
            case R.id.one:
                x = 0;
                y = 0;
                break;
            case R.id.two:
                x = 0;
                y = 1;
                break;
            case R.id.three:
                x = 0;
                y = 2;
                break;
            case R.id.four:
                x = 1;
                y = 0;
                break;
            case R.id.five:
                x = 1;
                y = 1;
                break;
            case R.id.six:
                x = 1;
                y = 2;
                break;
            case R.id.seven:
                x = 2;
                y = 0;
                break;
            case R.id.eight:
                x = 2;
                y = 1;
                break;
            case R.id.nine:
                x = 2;
                y = 2;
                break;
        }


        //check if space is occupied and display error message
        if (board[x][y] != 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Sorry this Space is Occupied!");
            alert.setTitle("Error");
            alert.setCancelable(true);
            alert.show();
            return;
        }

        Button btn = (Button) findViewById(id);
        TextView move = (TextView) findViewById(R.id.UserTurn);

        //Generates a player move based on the button that is pressed
        if (playerMove == true) {
            count ++;
            btn.setBackgroundResource(R.drawable.ex);
            btn.setTag("x");
            board[x][y] = 1;
            checkForWinner();


            //if there is still a space available generate a computer move
            if(count < 5 && winner == false) {
                getComputerMove();
                checkForWinner();

            }

        } else if (playerMove == false) {
            move.setText("X Turn!");
            playerMove = true;
        }

    }

    //generates a random position on the board for the computer
    public int getComputerMove(){
        //generates an x and y position for the computer move
        int computerMove = (int) (Math.random() * 9);
        int computerMove2 = (int) (Math.random() * 9);

        /**
         * Formula uses the random number and forms two coordinates on the board
         * based on the number as many times as it needs until empty spot is
         * found
         */
        while (board[computerMove / 3][computerMove2 % 3] != 0) {
            // Regenerates a new number if spot is occupied
            computerMove = (int) (Math.random() * 9);
            computerMove2 = (int) (Math.random() * 9);


            /**
             * if the computer finds a empty spot it will place a O in this
             * location using the random number generated in getComputerMove
             */
        }
        if (board[computerMove / 3][computerMove2 % 3] == 0) {
            board[computerMove / 3][computerMove2 % 3] = 2;

            //checks which space on the grid is marked and changes the image to an O
            if (computerMove / 3 == 0 && computerMove2 % 3 == 0 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.one).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 0 && computerMove2 % 3 == 1 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.two).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 0 && computerMove2 % 3 == 2 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.three).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 1 && computerMove2 % 3 == 0 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.four).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 1 && computerMove2 % 3 == 1 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.five).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 1 && computerMove2 % 3 == 2 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.six).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 2 && computerMove2 % 3 == 0 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.seven).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 2 && computerMove2 % 3 == 1 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.eight).setBackgroundResource(R.drawable.lettero);

            } else if (computerMove / 3 == 2 && computerMove2 % 3 == 2 && board[computerMove / 3][computerMove2 % 3] != 1) {
                findViewById(R.id.nine).setBackgroundResource(R.drawable.lettero);

            }
        } else if (board[x][y] != 0 ) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Sorry this Space is Occupied!");
            alert.setTitle("Error");
            alert.setCancelable(true);
            alert.show();
        }
        return computerMove;
    }


    //check for winner of the game and also check for a tie
    public int checkForWinner() {
        TextView move = (TextView) findViewById(R.id.UserTurn);
        //create a new alert that can be used of someone has won
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        boolean empty = false;

        //checks board for an empty space
        for (int i = 0; i != 3; i++) {
            for (int j = 0; j != 3; j++) {
                if (board[i][j] == 0) {
                    empty = true;
                    break;
                }
            }
        }
        //if no empty spots the game has tied

        // check all possible spots for a winner
        for (int i = 0; i != 3; i++) {

            //check rows for X winner
            if (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1) {
                winner = true;
                move.setText("Player X Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();

            }
            //check rows for O winner
            if (board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2){
                winner = true;
                move.setText("Computer Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                    //board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2) {
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();

            }
            //check columns
            if (board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) {
                winner = true;
                move.setText("Player X Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();

            }
            if (board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2) {
                winner = true;
                move.setText("Computer Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();

            }
            //check verticles
            if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
                winner = true;
                move.setText("Player X Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();
            }
            if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
                winner = true;
                move.setText("Computer Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();

            }
            //check other verticles
            if (board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
                winner = true;
                move.setText("Player X Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();

            }
            if (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
                winner = true;
                move.setText("Computer Wins!");
                findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                alert.setMessage("Checkout who won and press Reset to play again!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();

                //game has eneded in a tie and there is no winner
            }else {
                if (!empty && winner == false) {
                    move.setText("Its a Tie!");
                    winner = true;
                    findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);
                    alert.setMessage("Checkout who won and press Reset to play again!");
                    alert.setTitle("Game Over");
                    alert.setCancelable(true);
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    });
                    alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    });
                    alert.show();


                }
            }
        }
        return 0;
    }


    public void onClickClear(View view){
        if (winner == true) {
            clearBoard();
        }
    }

    //clears the board and sets the board positions back to the start
    public void clearBoard(){
        findViewById(R.id.one).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.two).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.three).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.four).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.five).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.six).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.seven).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.eight).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.nine).setBackgroundResource(android.R.drawable.btn_default);
        int x = 0;
        int y = 0;
        board[0][0] = 0;
        board[0][1] = 0;
        board[0][2] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 0;
        board[2][0] = 0;
        board[2][1] = 0;
        board[2][2] = 0;
        setContentView(R.layout.activity_game);
        board = new int[3][3];
        count = 0;
        winner = false;
        //keeps the user name back at the top
        result = (TextView) findViewById(R.id.User);
        result.setText(userName);


        }

}


