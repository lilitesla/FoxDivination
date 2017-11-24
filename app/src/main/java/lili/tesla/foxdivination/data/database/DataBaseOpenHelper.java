package lili.tesla.foxdivination.data.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Лилия on 24.11.2017.
 */

public class DataBaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "divinations.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}