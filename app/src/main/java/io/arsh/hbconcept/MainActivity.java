package io.arsh.hbconcept;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @Bind(R.id.MainProfileButton)
    ImageView myProfileButton;

    @Bind(R.id.MainButton)
    Button myButton;


    private DataHelper myDataHelper;



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
        SQLiteDatabase database = myDataHelper.getWritableDatabase();

        String countQuery = "SELECT * FROM " + DataHelper.USERS_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        Cursor cursor = database.rawQuery(countQuery, null);

        if (cursor.getCount() < 1) { //if there is no preloaded data, then add the data.
            loadPreData(database);
        }




        /* THE COMMENTED OUT CODE BELOW WAS USED TO PROVE THAT DATA HAD BEEN ENTERED INTO THE DATABASE.

        Toast.makeText(MainActivity.this, "count of users table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        countQuery = "SELECT * FROM " + DataHelper.COOKS_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        cursor = database.rawQuery(countQuery, null);

        Toast.makeText(MainActivity.this, "count of cooks table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        countQuery = "SELECT * FROM " + DataHelper.C_TO_D_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        cursor = database.rawQuery(countQuery, null);

        Toast.makeText(MainActivity.this, "count of c to d table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        countQuery = "SELECT * FROM " + DataHelper.ADDRESSES_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        cursor = database.rawQuery(countQuery, null);

        Toast.makeText(MainActivity.this, "count of address table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        countQuery = "SELECT * FROM " + DataHelper.CITY_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        cursor = database.rawQuery(countQuery, null);

        Toast.makeText(MainActivity.this, "count of city table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        countQuery = "SELECT * FROM " + DataHelper.CUISINE_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        cursor = database.rawQuery(countQuery, null);

        Toast.makeText(MainActivity.this, "count of cuisine table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        countQuery = "SELECT * FROM " + DataHelper.STATE_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        cursor = database.rawQuery(countQuery, null);

        Toast.makeText(MainActivity.this, "count of state table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        countQuery = "SELECT * FROM " + DataHelper.DISHES_TABLE; //check SQLite for whether or not there is pre-loaded data. 
        cursor = database.rawQuery(countQuery, null);

        Toast.makeText(MainActivity.this, "count of dishes table is " + cursor.getCount(), Toast.LENGTH_SHORT).show();

        */


    }



    @OnClick(R.id.MainButton)
    public void clickedCont() {
        Toast.makeText(this, "clicked continue", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SearchActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //this prevents you from getting back to the previous page.
        startActivity(intent);
    }



    @OnClick(R.id.MainProfileButton)
    public void clickedProf(View theView) {
        Toast.makeText(this, "clicked profile", Toast.LENGTH_SHORT).show();
        //show a popup for user to log in, log out, look at other stuff
    }




    //private void loadPreData() {
    //  put a ton of stuff into SQLite
    private void loadPreData(SQLiteDatabase database) {
        Toast.makeText(this, "in loadPreData", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "in loadPreData");

        database.beginTransaction();


        //LOCATIONS BELOW
        //state
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STATE, "Washington");
        database.insert(DataHelper.STATE_TABLE, null, contentValues);
        //city

        //state id
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CITY, "Seattle");
        contentValues.put(DataHelper.COLUMN_STATE_ID, 1);
        database.insert(DataHelper.CITY_TABLE, null, contentValues);


        //USERS AND COOKS BELOW
        //== 1
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "1411 7th St");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98164);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Ultradman");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Arsh");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Singh");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1);
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 1);
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        contentValues.put(DataHelper.COLUMN_USER_ID, 1);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //== 2
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "121 4th Ave");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98164);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "GmonS");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Gurdeep");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Singh");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1);
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 2);
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        contentValues.put(DataHelper.COLUMN_USER_ID, 2);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //==3
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "456 18th St");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98164);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Amagili");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Aman");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Gill");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1);
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 3);
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        contentValues.put(DataHelper.COLUMN_USER_ID, 3);
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //==4
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "222 8th Ave");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98164); //int
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Adada");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Adalberto");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Abate");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1); //int
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 4); //int
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        contentValues.put(DataHelper.COLUMN_USER_ID, 4); //int
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //== 5
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "9903 102nd St");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98164);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Donat");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Celso");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Donati");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1); //int
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 5); //int
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        contentValues.put(DataHelper.COLUMN_USER_ID, 5); //int
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //== 6
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "5403 64th Pl");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98164);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "CaCa");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Ale");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Caito");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1); //int
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 6); //int
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        contentValues.put(DataHelper.COLUMN_USER_ID, 6); //int
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //== 7
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "199 4th Pl");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98101);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Azabe55");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Anzu");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Abe");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1); //int
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 7); //int
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98101);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98174);
        contentValues.put(DataHelper.COLUMN_USER_ID, 7); //int
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //== 8
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "676 83rd Ave");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98164);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "Rockn");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Raku");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Nakagawa");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1); //int
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 8); //int
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98164);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98104);
        contentValues.put(DataHelper.COLUMN_USER_ID, 8); //int
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);

        //== 9
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "621 200th St");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98104);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "MooJun");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Chati");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Juntasa");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1); //int
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 9); //int
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98104);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98101);
        contentValues.put(DataHelper.COLUMN_USER_ID, 9); //int
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);


        //== 10
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_STREET_ADDRESS, "32 5th St");
        contentValues.put(DataHelper.COLUMN_ZIP_CODE, 98104);
        contentValues.put(DataHelper.COLUMN_CITY_ID, 1);
        database.insert(DataHelper.ADDRESSES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_USER_NAME, "NaiNaiCat");
        contentValues.put(DataHelper.COLUMN_USER_FIRST, "Naiyana");
        contentValues.put(DataHelper.COLUMN_USER_LAST, "Srisati");
        contentValues.put(DataHelper.COLUMN_IS_COOK, 1); //int
        contentValues.put(DataHelper.COLUMN_ADDRESS_ID, 10); //int
        database.insert(DataHelper.USERS_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_FIRST_ZIP, 98104);
        contentValues.put(DataHelper.COLUMN_SECOND_ZIP, 98101);
        contentValues.put(DataHelper.COLUMN_USER_ID, 10); //int
        database.insert(DataHelper.COOKS_TABLE, null, contentValues);



        //CUISINES BELOW
        //== 1
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Punjabi");
        database.insert(DataHelper.CUISINE_TABLE, null, contentValues);
        //== 2
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Italian");
        database.insert(DataHelper.CUISINE_TABLE, null, contentValues);
        //== 3
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Japanese");
        database.insert(DataHelper.CUISINE_TABLE, null, contentValues);
        //==4
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE, "Thai");
        database.insert(DataHelper.CUISINE_TABLE, null, contentValues);


        //DISHES BELOW
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 1);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Butter Naan");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Saag Paneer");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 1);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Bhature");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Chole");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 1);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Makki di Roti");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Sarson da Saag");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 1);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Butter Chicken");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Rice");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 1);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Paneer Tikka");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Rice");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 2);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Lasagna");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Risotto");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 2);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Ravioli");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Buridda");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 2);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Calzone");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Gnochi");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);
        //== 9
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 3);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Chazuke");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Tonkatsu");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);
        //== 10
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 3);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Omurice");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Anpan");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);
        //== 11
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 3);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Maki-zushi");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Curry Bread");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);
        //==12
        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 3);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Ramen");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Yakitori");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 4);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Khao Man Kai");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Phla Kung");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 4);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Khao Nuea Op");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Khua Ho");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_CUISINE_ID, 4);
        contentValues.put(DataHelper.COLUMN_MAIN_DISH, "Kaeng Khiao Wan");
        contentValues.put(DataHelper.COLUMN_SIDE_DISH, "Nang Kai Thot");
        database.insert(DataHelper.DISHES_TABLE, null, contentValues);



        //COOKS TO DISHES BELOW
        //cook id
        //dish id

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 1);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 1);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 1);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 2);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 1);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 3);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 1);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 4);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 1);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 5);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 2);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 2);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 3);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 3);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 3);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 5);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 4);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 6);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 4);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 7);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 4);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 8);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 5);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 6);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 5);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 7);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 5);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 8);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 6);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 7);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 7);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 9);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 7);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 10);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 7);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 11);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 8);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 12);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 9);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 13);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 9);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 14);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 9);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 15);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(DataHelper.COLUMN_COOK_ID, 10);
        contentValues.put(DataHelper.COLUMN_DISH_ID, 13);
        database.insert(DataHelper.C_TO_D_TABLE, null, contentValues);


        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();

    }




}
