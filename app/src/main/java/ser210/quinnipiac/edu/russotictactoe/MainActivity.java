package ser210.quinnipiac.edu.russotictactoe;

/**
 * Created by Mark Russo on 2/12/18.
 * Class Runs the main Activity
 * SER210
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //on clickPlay button called from main menu
    public void onClickPlay(View view){
        Intent intent = new Intent (this, TTTActivity.class);
        startActivity(intent);

    }


    //on clickMultiplayer button called from main menu
    public void onClickMulitplayer(View view) {

        Intent myIntent = new Intent(MainActivity.this, MultiplayerActivity.class);
        startActivity(myIntent);


    }

    //on click how to play button called from main menu
    public void onClickHowToPlay(View view) {

        Intent myIntent = new Intent(MainActivity.this, HowToPlayActivity.class);
        startActivity(myIntent);


    }

    //on theme click button called from main menu. Extra feature not yet completed
    public void Theme_click(View view) {
        Intent myIntent = new Intent(MainActivity.this, ChangeThemeActivity.class);
        startActivity(myIntent);


    }


    //on click exit button called from main menu, exits the application
    public void exit_click(View view) {
    System.exit(1);

    }

}
