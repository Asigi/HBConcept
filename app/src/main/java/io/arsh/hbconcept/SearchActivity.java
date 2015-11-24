package io.arsh.hbconcept;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends Activity {


    @Bind(R.id.SearchButton)
    Button myButton;

    @Bind(R.id.SearchSpinnerC)
    Spinner mySpinnerC;

    @Bind(R.id.SearchSpinnerZ)
    Spinner mySpinnerZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().hide();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(TheColorUtil.getStatusBarColor());

        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cuisine_types, android.R.layout.simple_spinner_item); // Create an ArrayAdapter using the string array and a default spinner layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // Specify the layout to use when the list of choices appears
        mySpinnerC.setAdapter(adapter);
        mySpinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TheFoodUtil.setTheCuisine(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                TheFoodUtil.setTheCuisine(TheFoodUtil.ANY_CUISINE);
            }
        });


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.zip_codes, android.R.layout.simple_spinner_item); // Create an ArrayAdapter using the string array and a default spinner layout
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // Specify the layout to use when the list of choices appears
        mySpinnerZ.setAdapter(adapter2);
        mySpinnerZ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TheFoodUtil.setTheZip((Integer.parseInt(parent.getItemAtPosition(position).toString())));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                TheFoodUtil.setTheZip(TheFoodUtil.ANY_ZIP);
            }
        });






        //TODO when the continue button is clicked, open up a list activity which loads the data.
        //The data that is loaded depends on what the two spinner items were selected as.
        //Look at SavedBlogsActivity from Una App.


    }


    @OnClick(R.id.SearchButton)
    public void findCooks() {
        Toast.makeText(this, "Your Cuisine is " + TheFoodUtil.getTheCuisine()
                + ", and your zip is " + TheFoodUtil.getTheZip(), Toast.LENGTH_SHORT).show();
    }



}
