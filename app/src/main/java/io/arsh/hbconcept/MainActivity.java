package io.arsh.hbconcept;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
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


    private DataHelper myDataHelper;


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

        myDataHelper = new DataHelper(this);
        //check SQLite for whether or not there is pre-loaded data. 
        //if not, then call loadPreData(); 
        //loadPreData();



    }




    //private void loadPreData() {
    //  put a ton of stuff into SQLite
    private void loadPreData() {
        SQLiteDatabase database = myDataHelper.getWritableDatabase();
        database.beginTransaction();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Ultradman");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Arsh");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Singh");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "14411 7th St");
        contentValues.put(DataHelper.COLUMN_CITY, "Seattle");
        contentValues.put(DataHelper.COLUMN_STATE, "Washington");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "98000");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "Yes");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Ultradman");
        contentValues.put(DataHelper.COLUMN_CUISINE, "Punjabi");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "");
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "");
        contentValues.put(DataHelper.COLUMN_CITY, "");
        contentValues.put(DataHelper.COLUMN_STATE, "");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, "");
        contentValues.put(DataHelper.COLUMN_IS_COOK, "");
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "");
        contentValues.put(DataHelper.COLUMN_CUISINE, "");
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);






        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Punjabi");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Butter Naan");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Saag Paneer");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Punjabi");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Punjabi");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Punjabi");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Punjabi");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Italian");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Italian");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Italian");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Japanese");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Japanese");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Japanese");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Thai");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Thai");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Thai");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Thai");
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);


    }




}
