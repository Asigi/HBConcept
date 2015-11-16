package io.arsh.hbconcept;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public static final String STREET_ADDRESS = "StreetAddress";
    public static final String STATE = "State";
    public static final String ZIP_CODE = "ZipCode";
    //give a cook number, -1 if not a cook

    //make table info for cuisine

    //make table info for other stuff



    public DataHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
