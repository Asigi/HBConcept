package io.arsh.hbconcept;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChefListActivity extends Activity {

    private static final String TAG = ChefListActivity.class.getSimpleName();

    DataHelper myDataHelper;

    private List<Cook> myCookList;

    @Bind(R.id.chefList) RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_list);
        ButterKnife.bind(this);


        getActionBar().hide();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(TheColorUtil.getStatusBarColor());

        myDataHelper = new DataHelper(this);

        myCookList = new ArrayList<Cook>();
        getTheCooks();
        displayTheCooks();
    }


    private void displayTheCooks() {

        ChefAdapter adapter = new ChefAdapter(ChefListActivity.this, myCookList);
        myRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ChefListActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setHasFixedSize(true);
    }


    private void getTheCooks() {


        SQLiteDatabase database = myDataHelper.getWritableDatabase();
        database.beginTransaction();

        /*
          select  * from cooks
          INNER JOIN users on cooks.id_users = users.id_users
          INNER JOIN cook_to_dishes ON cooks.id_cook = cook_to_dishes.cooks_id_cook
          INNER JOIN dishes ON cook_to_dishes.dishes_id_dishes = dishes.id_dishes
          INNER JOIN cuisine ON dishes.cuisine_id_cuisine = cuisine.id_cuisine
          where (cooks.first_zip = 98121 OR cooks.second_zip = 98121) AND cuisine.cuisine_name = "Punjabi"
          order by cooks.id_cook;
        */

        String query = "select * from " +  DataHelper.COOKS_TABLE +

                " INNER JOIN " + DataHelper.USERS_TABLE +
                " on " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_USER_ID +
                " = " + DataHelper.USERS_TABLE + "." + DataHelper.COLUMN_USER_ID +

                " INNER JOIN " + DataHelper.C_TO_D_TABLE +
                " on " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID +
                " = " + DataHelper.C_TO_D_TABLE + "." + DataHelper.COLUMN_COOK_ID +

                " INNER JOIN " + DataHelper.DISHES_TABLE +
                " on " + DataHelper.C_TO_D_TABLE + "." + DataHelper.COLUMN_DISH_ID +
                " = " + DataHelper.DISHES_TABLE + "." + DataHelper.COLUMN_DISH_ID +

                " INNER JOIN " + DataHelper.CUISINE_TABLE +
                " on " + DataHelper.DISHES_TABLE + "." + DataHelper.COLUMN_CUISINE_ID +
                " = " + DataHelper.CUISINE_TABLE + "." + DataHelper.COLUMN_CUISINE_ID +

                " where ((" + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_FIRST_ZIP +
                " = " + TheFoodUtil.getTheZip() +
                " OR " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_SECOND_ZIP +
                " = " + TheFoodUtil.getTheZip() + ")" +

                " AND " + DataHelper.CUISINE_TABLE + "." + DataHelper.COLUMN_CUISINE_ID +
                " = " + TheFoodUtil.getTheCuisineID() +

                ") ORDER BY " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID;





        Cursor c = database.rawQuery(query, null);

        Log.e(TAG, "cursor size is " + c.getCount());

        int prev = -1; //used to prevent duplicate cook entries.
        while (c.moveToNext()) {
            int cid = c.getInt(0);
            Log.e(TAG, "id is " + cid);
            int f = c.getInt(1);
            Log.e(TAG, "first zip is " + f);
            int s = c.getInt(2);
            Log.e(TAG, "second zip is " + s);

            String un = c.getString(5);
            Log.e(TAG, "username is " + un);
            String fn = c.getString(6);
            Log.e(TAG, "first name is " + fn);
            String ln = c.getString(7);
            Log.e(TAG, "last name is " + ln);

            Cook cook = new Cook(fn, ln, un, f, s, cid);
            if (cid == prev) {
                //do nothing
            } else {
                myCookList.add(cook);
                prev = cid;
            }
        }

        Log.e(TAG, "list size with duplicates removed is " + myCookList.size());


        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();


        /*
        String whereClause =
                DataHelper.COLUMN_FIRST_ZIP + " = " + TheFoodUtil.getTheZip() +
                " OR " +
                DataHelper.COLUMN_SECOND_ZIP + " = " + TheFoodUtil.getTheZip();



        Cursor c = database.query(
                DataHelper.COOKS_TABLE,
                null //tableColumns ,
                whereClause,
                null,
                null,
                null,
                null // order by
        );


        c.moveToFirst();

        myCookList = new ArrayList<Cook>();

        for (int i = 0; i < c.getCount(); i++) {
            int f = c.getInt(0);
            int s = c.getInt(1);
            int d = c.getInt(2);

            Cook object = new Cook(f, s, d);

            myCookList.add(object);

            c.moveToFirst();
        }


    */

    }

    @Override
    public void onBackPressed() {

        myDataHelper.close();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //this prevents you from getting back to the previous page.
        startActivity(intent);
    }



}
