package ser210.quinnipiac.edu.russotictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MultiplayerActivity extends Activity {
    private int[][] board;
    private boolean playerMove;
    int x = 0;
    int y = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
        board = new int[3][3];
        playerMove = true;
        TextView result = (TextView) findViewById(R.id.User);
        result.setText("Multiplayer");
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
            alert.create().show();
            return;

        }

        //if space is available place x
        Button btn = (Button) findViewById(id);
        TextView move = (TextView) findViewById(R.id.UserTurn);
        if (playerMove == true) {
            //btn.setText("x");
            btn.setBackgroundResource(R.drawable.ex);
            board[x][y] = 1;
            move.setText("O Turn!");
            playerMove = false;

            //player two moves
        } else if (playerMove == false) {
            move.setText("X Turn!");
            int xCoord = (int) (Math.random() * 9) / 3;
            int yCoord = (int) (Math.random() * 9) % 3;
            //b[xCoord][yCoord].setText("0");
            //btn.setText("O");
            btn.setBackgroundResource(R.drawable.lettero);
            board[x][y] = 2;
            playerMove = true;


        }
        checkForWinner();
    }


    //check for winner of the game and also check for a tie
    public void checkForWinner() {
        //create a new alert that can be used of someone has won
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        boolean empty = false;

        //check board for an empty position
        for (int i = 0; i != 3; i++) {
            for (int j = 0; j != 3; j++) {
                if (board[i][j] == 0) {
                    empty = true;
                    break;
                }
            }
        }
        //if no empty spots the game has tied
        if (!empty) {
            alert.setMessage("It is a tie!!");
            alert.setTitle("Game Over");
            alert.setCancelable(true);
            alert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    clearBoard();

                }
            });
            alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });
            alert.create().show();

        }

        // check all possible spots for a winner
        for (int i = 0; i != 3; i++) {

            //check rows
            if (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1) {
                alert.setMessage("Player X  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }

            if (board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2) {
                alert.setMessage("Player O  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }

            //check columns
            if (board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) {
                alert.setMessage("Player X  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }
            if (board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2) {
                alert.setMessage("Player O  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }
            //check verticles
            if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
                alert.setMessage("Player X  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }
            if (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
                alert.setMessage("Player O  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }
            //check other verticles
            if (board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
                alert.setMessage("Player X  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }
            if (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
                alert.setMessage("Player O  wins!");
                alert.setTitle("Game Over");
                alert.setCancelable(true);
                alert.setPositiveButton("Reset",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                clearBoard();
                            }
                        });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.create().show();

            }
        }
    }


    public void onClickClear(View view){
            clearBoard();

        }

    public void onClickMenu(View view){
        finish();
    }

    //Clears board and resets the game
    public void clearBoard(){
        onCreate(null);
    }
}