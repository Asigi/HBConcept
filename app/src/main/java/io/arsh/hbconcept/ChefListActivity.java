package io.arsh.hbconcept;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class ChefListActivity extends Activity {


    DataHelper myDataHelper;

    private List<Cook> myCookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_list);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().hide();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(TheColorUtil.getStatusBarColor());

        myDataHelper = new DataHelper(this);

        getTheCooks();
    }


    private void getTheCooks() {

        String[] columns = {
                DataHelper.COLUMN_USER_FIRST, DataHelper.COLUMN_USER_LAST
        };

        SQLiteDatabase database = myDataHelper.getWritableDatabase();
        database.beginTransaction();

        /*

          =  select  * from cooks

          =  INNER JOIN users on cooks.id_users = users.id_users

          =  INNER JOIN cook_to_dishes ON cooks.id_cook = cook_to_dishes.cooks_id_cook

          =  INNER JOIN dishes ON cook_to_dishes.dishes_id_dishes = dishes.id_dishes

          =  INNER JOIN cuisine ON dishes.cuisine_id_cuisine = cuisine.id_cuisine

            where (cooks.first_zip = 98121 OR cooks.second_zip = 98121) AND cuisine.cuisine_name = "Punjabi"

            order by cooks.id_cook;

        */

        String query = "select * from " +  DataHelper.COOKS_TABLE +

                " INNER JOIN " + DataHelper.USERS_TABLE +
                " on " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_USER_ID +
                " " + DataHelper.USERS_TABLE + "." + DataHelper.COLUMN_USER_ID +

                " INNER JOIN " + DataHelper.C_TO_D_TABLE +
                " on " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID +
                " " + DataHelper.C_TO_D_TABLE + "." + DataHelper.COLUMN_COOK_ID +

                " INNER JOIN " + DataHelper.DISHES_TABLE +
                " on " + DataHelper.C_TO_D_TABLE + "." + DataHelper.COLUMN_DISH_ID +
                " " + DataHelper.DISHES_TABLE + "." + DataHelper.COLUMN_DISH_ID +

                " INNER JOIN " + DataHelper.CUISINE_TABLE +
                " on " + DataHelper.DISHES_TABLE + "." + DataHelper.COLUMN_CUISINE_ID +
                " " + DataHelper.CUISINE_TABLE + "." + DataHelper.COLUMN_CUISINE_ID +

                " where (" + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_FIRST_ZIP +
                " = " + TheFoodUtil.getTheZip() +
                " OR " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_SECOND_ZIP +
                " = " + TheFoodUtil.getTheZip() + ")" +

                " AND " + DataHelper.CUISINE_TABLE + "." + DataHelper.COLUMN_CUISINE +
                " = " + TheFoodUtil.getTheCuisine() +

                " ORDER BY " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID;





        Cursor c = database.rawQuery(query, null);

        while (c.moveToNext()) {







        }




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







    private class Cook {

        public int myFZip;
        public int mySZip;
        public int myID;

        public Cook(int f, int s, int i) {
            myFZip = f;
            mySZip = s;
            myID = i;
        }
    }












}
