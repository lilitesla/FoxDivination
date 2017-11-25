package lili.tesla.foxdivination.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Region;

import lili.tesla.foxdivination.data.Ekaterina;
import lili.tesla.foxdivination.data.Prediction;

/**
 * Created by Лилия on 24.11.2017.
 */

public class DataBaseAccess {

    private static DataBaseAccess instance;

    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    public DataBaseAccess(Context context) {
        this.openHelper = new DataBaseOpenHelper(context);
    }

    private void open() {
        this.database = openHelper.getWritableDatabase();
    }

    private void close() {
        if (database != null) {
            this.database.close();
        }
    }

    // China_FateBook

    public int getFateBookId (String predIndexId) {
        open();
        String[] str = new String[1];
        str[0] = predIndexId;

        Cursor cursor = database.rawQuery("SELECT id FROM china_fatebook WHERE index_id = ?", str);

        cursor.moveToFirst();
        int result = cursor.getInt(0);

        cursor.close();
        close();
        return result;
    }

    public Prediction getFateBookPrediction (int predId) {
        open();
        String[] str = new String[1];
        str[0] = predId + "";

        Cursor cursor = database.rawQuery("SELECT * FROM china_fatebook WHERE id = ?", str);
        cursor.moveToFirst();
        Prediction result = new Prediction(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3));
        cursor.close();
        close();
        return result;
    }

    // Ekaterina

    public Ekaterina getEkaterinaPrediction (int[] nums) {
        open();

        String[] str = new String[1];

        String[] captions = new String[3];
        String[] descriptions = new String[3];

        for (int i = 0; i < 3; i++) {
            str[0] = nums[i] + "";

            Cursor cursor = database.rawQuery("SELECT caption, description FROM ekaterina WHERE id = ?", str);
            cursor.moveToFirst();

            captions[i] = cursor.getString(0);
            descriptions[i] = cursor.getString(1);

            cursor.close();
        }

        Ekaterina result = new Ekaterina(captions[0], descriptions[0], captions[1], descriptions[1], captions[2], descriptions[2]);
        close();
        return result;
    }



}
