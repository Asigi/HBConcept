package io.arsh.hbconcept;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FavListActivity extends Activity {


    private static final String TAG = FavListActivity.class.getSimpleName();

    DataHelper myDataHelper;

    private List<Cook> myCookList;

    @Bind(R.id.favList)
    RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_list);
        getActionBar().setDisplayHomeAsUpEnabled(true);
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

        ChefAdapter adapter = new ChefAdapter(FavListActivity.this, myCookList);
        myRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FavListActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setHasFixedSize(true);
    }


    private void getTheCooks() {


        SQLiteDatabase database = myDataHelper.getWritableDatabase();
        database.beginTransaction();

        String query = "select * from " + DataHelper.FAV_TABLE +

                " INNER JOIN " + DataHelper.COOKS_TABLE +
                " on " + DataHelper.FAV_TABLE + "." + DataHelper.COLUMN_COOK_ID +
                " = " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID +

                " INNER JOIN " + DataHelper.USERS_TABLE +
                " on " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_USER_ID +
                " = " + DataHelper.USERS_TABLE + "." + DataHelper.COLUMN_USER_ID +

                " ORDER BY " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID;

        Cursor c = database.rawQuery(query, null);

        Log.e("FavListActivity class", "cursor size is " + c.getCount());


        int prev = -1; //used to prevent duplicate cook entries.
        while (c.moveToNext()) {
            int cid = c.getInt(2);
            Log.e(TAG, "id is " + cid);
            int f = c.getInt(3);
            Log.e(TAG, "first zip is " + f);
            int s = c.getInt(4);
            Log.e(TAG, "second zip is " + s);

            String un = c.getString(7);
            Log.e(TAG, "username is " + un);
            String fn = c.getString(8);
            Log.e(TAG, "first name is " + fn);
            String ln = c.getString(9);
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

    }

}