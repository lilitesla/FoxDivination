package lili.tesla.foxdivination.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Region;
import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public Prediction getFateBookPrediction (String predIndex) {
        open();
        String[] str = new String[1];
        str[0] = predIndex;

        Cursor cursor = database.rawQuery("SELECT * FROM china_fatebook WHERE index_id = ?", str);
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

        Ekaterina result = new Ekaterina(nums, captions, descriptions);
        close();
        return result;
    }

    // Domino
    public String getDominoDescription (int num) {
        open();

        String[] str = new String[1];
        str[0] = num + "";

        Cursor cursor = database.rawQuery("SELECT description FROM domino WHERE id = ?", str);
        cursor.moveToFirst();

        String caption = cursor.getString(0);
        cursor.close();

        close();
        return caption;
    }

    //Kabbala
    public int getKabbalaAlphabetNum (String s) {
        open();

        String[] str = new String[1];
        str[0] = s;

        Cursor cursor = database.rawQuery("SELECT value FROM kabbala_alphabet WHERE word = ?", str);
        cursor.moveToFirst();

        int result = cursor.getInt(0);

        cursor.close();
        close();

        return result;
    }

    public List<Integer> getKabbalaValueList() {
        open();

        String[] str = new String[0];
        List<Integer> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT index_id FROM kabbala_answers ORDER BY index_id DESC", str);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            list.add(cursor.getInt(0));
            while (cursor.moveToNext()) {
                list.add(cursor.getInt(0));
            }
        }

        cursor.close();
        close();

        return list;
    }

    public String getKabbalaDescription(int num) {
        open();

        String[] str = new String[1];
        str[0] = num + "";

        Cursor cursor = database.rawQuery("SELECT description FROM kabbala_answers WHERE index_id = ?", str);
        cursor.moveToFirst();

        String result = cursor.getString(0);
        cursor.close();
        close();

        return result;
    }



}
