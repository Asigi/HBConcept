package io.arsh.hbconcept;

import android.os.Bundle;
import android.app.Activity;

public class CookProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_profile);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
