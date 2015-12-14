package io.arsh.hbconcept;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by arshdeep on 11/16/15.
 */
public class DataHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "hbconcept.db";
    public static final int DB_VERSION = 1;


    public static final String STATE_TABLE = "STATE";
    public static final String CITY_TABLE = "CITY";
    public static final String ADDRESSES_TABLE = "ADDRESSES";
    public static final String USERS_TABLE = "USERS";
    public static final String COOKS_TABLE = "COOKS";
    public static final String CUISINE_TABLE = "CUISINE";
    public static final String DISHES_TABLE = "DISHES";
    public static final String C_TO_D_TABLE = "COOKtoDISHES";
    public static final String FAV_TABLE = "FavoriteCooks";



    public static final String COLUMN_STATE_ID = "StateID";
    public static final String COLUMN_STATE = "State";
    public static final String COLUMN_CITY_ID = "CityID";
    public static final String COLUMN_CITY = "City";
    public static final String COLUMN_ADDRESS_ID = "AddressID";
    public static final String COLUMN_STREET_ADDRESS = "StreetAddress";
    public static final String COLUMN_ZIP_CODE = "ZipCode";
    public static final String COLUMN_USER_ID = "UserId";
    public static final String COLUMN_USER_NAME = "Username";
    public static final String COLUMN_USER_FIRST = "FirstName";
    public static final String COLUMN_USER_LAST = "LastName";
    public static final String COLUMN_IS_COOK = "IsCook";
    public static final String COLUMN_COOK_ID = "CookID";
    public static final String COLUMN_FIRST_ZIP = "FirstZipServed";
    public static final String COLUMN_SECOND_ZIP = "SecondZipServed";
    public static final String COLUMN_CUISINE_ID = "CuisineID";
    public static final String COLUMN_CUISINE = "Cuisine";
    public static final String COLUMN_MAIN_DISH = "MainDish";
    public static final String COLUMN_SIDE_DISH = "SideDish";
    public static final String COLUMN_DISH_ID = "DishID";




    private static final String START_FOREIGN = "PRAGMA foreign_keys = ON";



    private static final String CREATE_STATE_TABLE = "CREATE TABLE " + STATE_TABLE + " (" +
            COLUMN_STATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_STATE + " TEXT)";


    private static final String CREATE_CITY_TABLE = "CREATE TABLE " + CITY_TABLE + " (" +
            COLUMN_CITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_CITY + " TEXT, " +
            COLUMN_STATE_ID + " INTEGER REFERENCES " + STATE_TABLE + "(" + COLUMN_STATE_ID + "))";


    private static final String CREATE_ADDRESS_TABLE = "CREATE TABLE " + ADDRESSES_TABLE + " (" +
            COLUMN_ADDRESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_STREET_ADDRESS + " TEXT, " +
            COLUMN_ZIP_CODE + " INTEGER, " +
            COLUMN_CITY_ID + " INTEGER REFERENCES " + CITY_TABLE + "(" + COLUMN_CITY_ID + "))";


    private static final String CREATE_USER_TABLE = "CREATE TABLE " + USERS_TABLE + " (" +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_USER_NAME + " TEXT, " +
            COLUMN_USER_FIRST + " TEXT, " +
            COLUMN_USER_LAST + " TEXT, " +
            COLUMN_IS_COOK + " INTEGER, " +
            COLUMN_ADDRESS_ID + " INTEGER REFERENCES " + ADDRESSES_TABLE + "(" + COLUMN_ADDRESS_ID + "))";


    private static final String CREATE_COOKS_TABLE = "CREATE TABLE " + COOKS_TABLE + " (" +
            COLUMN_COOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_FIRST_ZIP + " INTEGER, " +
            COLUMN_SECOND_ZIP + " INTEGER, " +
            COLUMN_USER_ID + " INTEGER REFERENCES " + USERS_TABLE + "(" + COLUMN_USER_ID + "))";


    private static final String CREATE_CUISINE_TABLE = "CREATE TABLE " + CUISINE_TABLE + " (" +
            COLUMN_CUISINE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_CUISINE + " TEXT)";


    private static final String CREATE_DISHES_TABLE = "CREATE TABLE " + DISHES_TABLE + " (" +
            COLUMN_DISH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_MAIN_DISH + " TEXT, " +
            COLUMN_SIDE_DISH + " TEXT, " +
            COLUMN_CUISINE_ID + " INTEGER REFERENCES " + CUISINE_TABLE + "(" + COLUMN_DISH_ID + "))";


    private static final String CREATE_C_TO_D_TABLE = "CREATE TABLE " + C_TO_D_TABLE + " (" +
            COLUMN_COOK_ID + " INTEGER REFERENCES " + COOKS_TABLE + "(" + COLUMN_COOK_ID + "), " +
            COLUMN_DISH_ID + " INTEGER REFERENCES " + DISHES_TABLE + "(" + DISHES_TABLE + "))";




    private static final String CREATE_FAV_TABLE = "CREATE TABLE " + FAV_TABLE + " (" +
            COLUMN_USER_ID + " INTEGER REFERENCES " + USERS_TABLE + "(" + COLUMN_USER_ID + "), " +
            COLUMN_COOK_ID + " INTEGER REFERENCES " + COOKS_TABLE + "(" + COLUMN_COOK_ID + "))";





    public DataHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(START_FOREIGN);
        try {
            db.execSQL(CREATE_STATE_TABLE);
            db.execSQL(CREATE_CITY_TABLE);
            db.execSQL(CREATE_ADDRESS_TABLE);
            db.execSQL(CREATE_USER_TABLE);
            db.execSQL(CREATE_COOKS_TABLE);
            db.execSQL(CREATE_CUISINE_TABLE);
            db.execSQL(CREATE_DISHES_TABLE);
            db.execSQL(CREATE_C_TO_D_TABLE);

        } catch (Exception e) {
            Log.e("DataHelper class", "exception: " + e.getMessage());
        }


        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }


    public static void accountCreated(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_FAV_TABLE);
        } catch (Exception e) {
            Log.e("DataHelper class", "exception " + e.getMessage());
        }
        Log.e("DataHelper class", "made new fav table");

        db.close();
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //NOT NECESSARY TO IMPLEMENT
    }


}