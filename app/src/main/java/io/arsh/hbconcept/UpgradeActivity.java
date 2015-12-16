package io.arsh.hbconcept;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UpgradeActivity extends Activity {


    @Bind(R.id.upgradeFirstZip)
    Spinner myFirstSpinner;

    @Bind(R.id.upgradeSecondZip)
    Spinner mySecondSpinner;

    @Bind(R.id.upgradeCuisine)
    Spinner myCuisineSpinner;

    @Bind(R.id.upgradeDish)
    Spinner myDishSpinner;

    @Bind(R.id.upgradeButton)
    Button myButton;



    int first;
    int second;
    String cuisine;
    String dish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().hide();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(TheColorUtil.getStatusBarColor());

        setContentView(R.layout.activity_upgrade);

        ButterKnife.bind(this);




        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.zip_codes, android.R.layout.simple_spinner_item); // Create an ArrayAdapter using the string array and a default spinner layout
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // Specify the layout to use when the list of choices appears


        myFirstSpinner.setAdapter(adapter2);
        myFirstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                first = (Integer.parseInt(parent.getItemAtPosition(position).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing
            }
        });


        mySecondSpinner.setAdapter(adapter2);
        mySecondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                second = (Integer.parseInt(parent.getItemAtPosition(position).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing
            }
        });




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cuisine_types, android.R.layout.simple_spinner_item); // Create an ArrayAdapter using the string array and a default spinner layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // Specify the layout to use when the list of choices appears
        myCuisineSpinner.setAdapter(adapter);
        myCuisineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cuisine = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing
            }
        });




    }
}
