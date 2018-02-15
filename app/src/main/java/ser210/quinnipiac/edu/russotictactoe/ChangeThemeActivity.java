package ser210.quinnipiac.edu.russotictactoe;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChangeThemeActivity extends AppCompatActivity {
    private changeTheme getTheme = new changeTheme();
    private MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);
    }

    public void changeThemeBright(){

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.WHITE);

    }
    public void changeThemeDark(){
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.BLACK);


    }
    public void changeThemeColorful(){
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        layout.setBackgroundColor(Color.RED);


    }


    public void onClickChangeTheme(View view){
        Spinner theme = (Spinner) findViewById(R.id.theme);
        String Theme = String.valueOf(theme.getSelectedItem());
        String mainTheme = String.valueOf(theme.getSelectedItem());
        List<String> brandsList = getTheme.getTheme(Theme);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandsList){
            brandsFormatted.append(brand).append('\n');
        }
        //themeheme.setText(brandsFormatted);
    }

    public class changeTheme {
        List<String> getTheme(String color) {
            List<String> theme = new ArrayList<>();
            if (color.equals("Bright")) {
                changeThemeBright();
            } else if (color.equals("Dark")) {
                changeThemeDark();
            } else if (color.equals("Colorful")) {
                changeThemeColorful();
            }
            return theme;
        }
    }



}
