package io.arsh.hbconcept;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by arshdeep on 11/16/15.
 */
public class DataHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "hbconcept.db";
    public static final int DB_VERSION = 1;



    public static final String USERS_TABLE = "USERS";
    public static final String COLUMN_USER_NAME = "Username";
    public static final String COLUMN_USER_FIRST = "FirstName";
    public static final String COLUMN_USER_LAST = "LastName";
    public static final String COLUMN_STREET_ADDRESS = "StreetAddress";
    public static final String COLUMN_CITY = "City";
    public static final String COLUMN_STATE = "State";
    public static final String COLUMN_ZIP_CODE = "ZipCode";
    public static final String COLUMN_IS_COOK = "IsCook";



    //make table for cooks
    //Cook(cookNumber, Cuisine, FirstZipServed, SecondZipServed)
            //cookNumber is auto-incremented
    public static final String COOKS_TABLE = "COOKS";
    public static final String COLUMN_COOK_NUMBER = "CookNumber";
    //cook number can be
    public static final String COLUMN_CUISINE = "Cuisine";
    public static final String COLUMN_FIRST_ZIP = "FirstZipServed";
    public static final String COLUMN_SECOND_ZIP = "SecondZipServed";




    //make table info for cuisine
    //Dish(idNum, Cuisine, Main Dish, Side Dish)
            //idNum is auto-incremented
    public static final String DISHES_TABLE = "DISHES";
    //Cusinine string is already created above, under cooks.
    //public static final String COLUMN_DISH_NUMBER = "DishNumber";
    public static final String COLUMN_MAIN_DISH = "MainDish";
    public static final String COLUMN_SIDE_DISH = "SideDish";

    //make table info for other stuff





    private static final String CREATE_USER_TABLE = "CREATE TABLE " + USERS_TABLE + " (" +
            COLUMN_USER_NAME + " TEXT, " + /* Note that TEXT is same as VARCHAR*/
            COLUMN_USER_FIRST + " TEXT, " +
            COLUMN_USER_LAST + " TEXT, " +
            COLUMN_IS_COOK + " INTEGER, " +
            COLUMN_STREET_ADDRESS + " TEXT, " +
            COLUMN_CITY + " TEXT, " +
            COLUMN_STATE + " TEXT, " +
            COLUMN_ZIP_CODE + " INTEGER)"; //Is_Cook will be 0 if not a cook, 1 if is a cook.


    private static final String CREATE_COOKS_TABLE = "CREATE TABLE " + COOKS_TABLE + " (" +
            BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_USER_NAME + " TEXT, " +
            COLUMN_CUISINE + " TEXT, " +
            COLUMN_FIRST_ZIP + " INTEGER, " +
            COLUMN_SECOND_ZIP + " INTEGER)";


    private static final String CREATE_DISHES_TABLE = "CREATE TABLE " + DISHES_TABLE + " (" +
            BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CUISINE + " TEXT, " +
            COLUMN_MAIN_DISH + " TEXT, " +
            COLUMN_SIDE_DISH + " TEXT)";




    private static final String EXIST_CHECKER = "SELECT count(*) FROM " +
            "sqlite_master WHERE type='table' AND name='" + COOKS_TABLE + "'";







    public DataHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_COOKS_TABLE);
        db.execSQL(CREATE_DISHES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
