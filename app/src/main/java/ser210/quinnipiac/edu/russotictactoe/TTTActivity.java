package ser210.quinnipiac.edu.russotictactoe;

/**
 * Created by Mark Russo on 2/12/18.
 * Class Runs the main game Activity
 * Methods are called from TicTacToe.java
 * SER210
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TTTActivity extends Activity {
    public String userName;
    public TextView result;
    boolean winner = false;
    private TicTacToe game = new TicTacToe();
    int count = 0;
    int currentState = ITicTacToe.PLAYING;
    int loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (savedInstanceState != null) {
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

    //starts the game called by the buttons in activity_game
        public void gameStart(View view) {
        //sets buttons as variables to access
            Button btn1 = (Button) findViewById(R.id.one);
            Button btn2 = (Button) findViewById(R.id.two);
            Button btn3 = (Button) findViewById(R.id.three);
            Button btn4 = (Button) findViewById(R.id.four);
            Button btn5 = (Button) findViewById(R.id.five);
            Button btn6 = (Button) findViewById(R.id.six);
            Button btn7 = (Button) findViewById(R.id.seven);
            Button btn8 = (Button) findViewById(R.id.eight);
            Button btn9 = (Button) findViewById(R.id.nine);
            TextView move = (TextView) findViewById(R.id.UserTurn);
            int id = view.getId();
            Button btn = (Button) findViewById(id);

            //game is playing
            if (currentState == ITicTacToe.PLAYING && winner == false) {

                //checks if a spot is already occupied and will display an error message
                if (btn.getTag() == "X" || btn.getTag() == "O") {
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setMessage("Sorry this Space is Occupied!");
                    alert.setTitle("Error");
                    alert.setCancelable(true);
                    alert.show();
                    return;
                }
                // btn.setBackgroundResource(R.drawable.ex);
                // loc = id;
                move.setText("Players Turn");
                if (view.getId() == btn1.getId()) {
                    game.setMove(1, 0);
                    findViewById(R.id.one).setBackgroundResource(R.drawable.ex);
                    btn1.setTag("X");
                }
                if (view.getId() == btn2.getId()) {
                    game.setMove(1, 1);
                    findViewById(R.id.two).setBackgroundResource(R.drawable.ex);
                    btn2.setTag("X");

                }
                if (view.getId() == btn3.getId()) {
                    game.setMove(1, 2);
                    findViewById(R.id.three).setBackgroundResource(R.drawable.ex);
                    btn3.setTag("X");

                }
                if (view.getId() == btn4.getId()) {
                    findViewById(R.id.four).setBackgroundResource(R.drawable.ex);
                    game.setMove(1, 3);
                    btn4.setTag("X");

                }
                if (view.getId() == btn5.getId()) {
                    findViewById(R.id.five).setBackgroundResource(R.drawable.ex);
                    game.setMove(1, 4);
                    btn5.setTag("X");

                }
                if (view.getId() == btn6.getId()) {
                    findViewById(R.id.six).setBackgroundResource(R.drawable.ex);
                    game.setMove(1, 5);
                    btn6.setTag("X");

                }
                if (view.getId() == btn7.getId()) {
                    findViewById(R.id.seven).setBackgroundResource(R.drawable.ex);
                    game.setMove(1, 6);
                    btn7.setTag("X");

                }
                if (view.getId() == btn8.getId()) {
                    findViewById(R.id.eight).setBackgroundResource(R.drawable.ex);
                    game.setMove(1, 7);
                    btn8.setTag("X");

                }
                if (view.getId() == btn9.getId()) {
                    findViewById(R.id.nine).setBackgroundResource(R.drawable.ex);
                    loc = 0;
                    game.setMove(1, 8);
                    btn9.setTag("X");

                }
                checkForWinner();

                //if there is still a spot available the computer will make its move
                count++;
                if (count < 5 && winner == false) {
                    computerMove();
                }

            }
        }

        //generates a computer image move based on TicTacToe java computerMove
            public void computerMove() {
                TextView move = (TextView) findViewById(R.id.UserTurn);

                //delayes the method 3 miliseconds to give the effect of computer generating a move
                 final Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                 int aiMove = game.getComputerMove();

                //checks move that computer has generated and sets the image
               if (aiMove == 0) {
                    findViewById(R.id.one).setBackgroundResource(R.drawable.lettero);
                    findViewById(R.id.one).setTag("O");

                } else if (aiMove == 1) {
                   findViewById(R.id.two).setBackgroundResource(R.drawable.lettero);
                   findViewById(R.id.two).setTag("O");

                } else if (aiMove == 2) {
                    findViewById(R.id.three).setBackgroundResource(R.drawable.lettero);
                   findViewById(R.id.three).setTag("O");

                } else if (aiMove == 3) {
                    findViewById(R.id.four).setBackgroundResource(R.drawable.lettero);
                   findViewById(R.id.four).setTag("O");

                } else if (aiMove == 4) {
                    findViewById(R.id.five).setBackgroundResource(R.drawable.lettero);
                   findViewById(R.id.five).setTag("O");

                } else if (aiMove == 5) {
                    findViewById(R.id.six).setBackgroundResource(R.drawable.lettero);
                   findViewById(R.id.six).setTag("O");

                } else if (aiMove == 6) {
                    findViewById(R.id.seven).setBackgroundResource(R.drawable.lettero);
                   findViewById(R.id.seven).setTag("O");

                } else if (aiMove == 7) {
                    findViewById(R.id.eight).setBackgroundResource(R.drawable.lettero);
                   findViewById(R.id.eight).setTag("O");

                } else if (aiMove == 8) {
                    findViewById(R.id.nine).setBackgroundResource(R.drawable.lettero);
                    findViewById(R.id.nine).setTag("O");
                }
                checkForWinner();

            }
        }, 300);
    }



    //checks winner of the game based off CheckForWInner in TicTacToe.java
    public void checkForWinner(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        TextView move = (TextView) findViewById(R.id.UserTurn);
        int gameWinner = game.checkForWinner();
        if (gameWinner == 1) {
            winner = true;

            //displays allert message to inform the game is over and sets the text to winner
            move.setText("You Won!!");
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

        } else if (gameWinner == 2) {
              winner = true;
            //  TextView move = (TextView) findViewById(R.id.UserTurn);
            move.setText("The Computer Won!!");
            findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);

            //displays allert message to inform the game is over and sets the text to winner
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

        } else if (gameWinner == 3) {
             winner = true;
            //  TextView move = (TextView) findViewById(R.id.UserTurn);
            move.setText("It's a Tie!!!");
            findViewById(R.id.Reset).setBackgroundColor(Color.WHITE);

            //displays allert message to inform the game is over and sets the text to winner
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
    }

    //games reset button, only available if game is over
    public void onClickClear(View view){
        if (winner == true) {
            game.clearBoard();
            clearBoard();

        }
    }

    //Menu button from game screen that will return the user to the home screen (Main Activity)
    public void onClickMenu(View view){
        finish();
    }

    //Resets the button images and restore the game to be replayed
    public void clearBoard() {
        TextView move = (TextView) findViewById(R.id.UserTurn);
        findViewById(R.id.one).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.two).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.three).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.four).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.five).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.six).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.seven).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.eight).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.nine).setBackgroundResource(android.R.drawable.btn_default);
        findViewById(R.id.one).setTag(" ");
        findViewById(R.id.two).setTag(" ");
        findViewById(R.id.three).setTag(" ");
        findViewById(R.id.four).setTag(" ");
        findViewById(R.id.five).setTag(" ");
        findViewById(R.id.six).setTag(" ");
        findViewById(R.id.seven).setTag(" ");
        findViewById(R.id.eight).setTag(" ");
        findViewById(R.id.nine).setTag(" ");
        findViewById(R.id.Reset).setBackgroundColor(Color.DKGRAY);
        count = 0;
        winner = false;
        //keeps the user name back at the top
        result = (TextView) findViewById(R.id.User);
        result.setText(userName);

        move.setText("Make A Move!");

    }
}


