package ser210.quinnipiac.edu.russotictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickPlay(View view){
        Intent intent = new Intent (this, TTTActivity.class);
        startActivity(intent);

    }

    public void onClickMulitplayer(View view) {

        Intent myIntent = new Intent(MainActivity.this, MultiplayerActivity.class);
        startActivity(myIntent);


    }

    public void onClickHowToPlay(View view) {

        Intent myIntent = new Intent(MainActivity.this, HowToPlayActivity.class);
        startActivity(myIntent);


    }


    public void exit_click(View view) {
    System.exit(1);

    }

}
