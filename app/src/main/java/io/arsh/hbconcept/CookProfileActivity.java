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
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CookProfileActivity extends Activity {

    private static final String TAG = CookProfileActivity.class.getSimpleName();

    DataHelper myDataHelper;

    private List<Dish> myDishList;

    @Bind(R.id.cookDishList) RecyclerView myRecyclerView;

    @Bind(R.id.cookProfileName) TextView myName;

    @Bind(R.id.cookProfileFav) ImageView myFavButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_profile);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(TheColorUtil.getStatusBarColor());


        myDataHelper = new DataHelper(this);

        myDishList = new ArrayList<>();
        getTheDishes();
        displayTheDishes();

        myName.setText(TheCookUtil.getTheCook().myFN + " " + TheCookUtil.getTheCook().myLN);
    }

    private void displayTheDishes() {

        DishAdapter adapter = new DishAdapter(CookProfileActivity.this, myDishList);
        myRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CookProfileActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setHasFixedSize(true);
    }




    private void getTheDishes() {
        SQLiteDatabase database = myDataHelper.getWritableDatabase();
        database.beginTransaction();

        String query = "select * from " +  DataHelper.COOKS_TABLE +
                " INNER JOIN " + DataHelper.C_TO_D_TABLE +
                " on " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID +
                " = " + DataHelper.C_TO_D_TABLE + "." + DataHelper.COLUMN_COOK_ID +
                " INNER JOIN " + DataHelper.DISHES_TABLE +
                " on " + DataHelper.C_TO_D_TABLE + "." + DataHelper.COLUMN_DISH_ID +
                " = " + DataHelper.DISHES_TABLE + "." + DataHelper.COLUMN_DISH_ID +
                " where " + DataHelper.COOKS_TABLE + "." + DataHelper.COLUMN_COOK_ID +
                " = " + TheCookUtil.getTheCook().myID;


        Cursor c = database.rawQuery(query, null);

        Log.e(TAG, "cursor size is " + c.getCount());

        while (c.moveToNext()) {
            int cid = c.getInt(0);
            Log.e(TAG, "id is " + cid);


            int did = c.getInt(6);
            Log.e(TAG, "dish id is " + did);
            String md = c.getString(7);
            Log.e(TAG, "main dish is " + md);
            String sd = c.getString(8);
            Log.e(TAG, "side dish is " + sd);


            Dish dish = new Dish(md, sd, did);

            myDishList.add(dish);
        }

        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();


    }



    @OnClick (R.id.cookProfileFav)
    public void Faved() {

        TheCookUtil.favCookList.add(TheCookUtil.getTheCook());

    }











}
