package io.arsh.hbconcept;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @Bind(R.id.MainProfileButton)
    ImageView myProfileButton;

    @Bind(R.id.MainButton)
    Button myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().hide();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(TheColorUtil.getStatusBarColor());

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //check SQLite for whether or not there is pre-loaded data. 
        //if not, then call loadPreData(); 




    }

    //private void loadPreData() {
    //  put a ton of stuff into SQLite




    @OnClick(R.id.MainButton)
    public void clickedCont() {
        Intent intent = new Intent(this, SearchActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //this prevents you from getting back to the previous page.
        startActivity(intent);
    }



    @OnClick(R.id.MainProfileButton)
    public void clickedProf(View theView) {
        //show a popup for user to log in, log out, look at other stuff
    }
}
