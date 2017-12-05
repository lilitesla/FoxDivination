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

import lili.tesla.foxdivination.data.Coffee;
import lili.tesla.foxdivination.data.Ekaterina;
import lili.tesla.foxdivination.data.Hokku;
import lili.tesla.foxdivination.data.Prediction;
import lili.tesla.foxdivination.data.Zodiac;
import lili.tesla.foxdivination.data.ZodiacCompatibility;

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

    //Coffee
    public Coffee getCoffee(int count) {
        open();

        String[] str = new String[1];
        str[0] = count + "";

        Cursor cursor = database.rawQuery("SELECT caption, description FROM coffee WHERE id = ?", str);
        cursor.moveToFirst();

        Coffee result = new Coffee(count, cursor.getString(0), cursor.getString(1));
        cursor.close();
        close();

        return result;
    }

    //Zodiac
    public Zodiac getMainZodiac(int gender, int zodiakId) {
        open();

        String[] str = new String[2];
        str[0] = gender + "";
        str[1] = zodiakId + "";

        Cursor cursor = database.rawQuery("SELECT zodiak, main FROM zodiak_main WHERE gender = ? and zodiakId = ?", str);
        cursor.moveToFirst();

        Zodiac result = new Zodiac(gender, zodiakId, cursor.getString(0), cursor.getString(1));
        cursor.close();
        close();

        return result;
    }

    public Zodiac getLoveZodiac(int gender, int zodiakId) {
        open();

        String[] str = new String[2];
        str[0] = gender + "";
        str[1] = zodiakId + "";

        Cursor cursor = database.rawQuery("SELECT zodiak, love FROM zodiak_main WHERE gender = ? and zodiakId = ?", str);
        cursor.moveToFirst();

        Zodiac result = new Zodiac(gender, zodiakId, cursor.getString(0), cursor.getString(1));
        cursor.close();
        close();

        return result;
    }

    public ZodiacCompatibility getZodiacCompatibility(int manZodiacId, int womanZodiacId) {
        open();

        String[] str = new String[1];
        str[0] = manZodiacId + " " + womanZodiacId;

        Cursor cursor = database.rawQuery("SELECT male, female, percent, marriage_caption, marriage, luck_caption, luck, sex_caption, sex," +
                "money_caption, money, childrens_caption, childrens FROM zodiak_compatibility WHERE zodiakId = ?", str);
        cursor.moveToFirst();

        ZodiacCompatibility result = new ZodiacCompatibility(manZodiacId, womanZodiacId, cursor.getString(0), cursor.getString(1),
                cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),
                cursor.getString(10), cursor.getString(11), cursor.getString(12));

        cursor.close();
        close();

        return result;
    }

    //Hokku
    public Hokku getHokku(int hokkuId) {
        open();

        String[] str = new String[1];
        str[0] = hokkuId + "";

        Cursor cursor = database.rawQuery("SELECT hokku, author, interpretation  FROM hokku WHERE id = ?", str);
        cursor.moveToFirst();

        Hokku result = new Hokku(cursor.getString(0), cursor.getString(1), cursor.getString(2));
        cursor.close();
        close();

        return result;
    }

    //Mokuso
    public String getMokuso(String indexId) {
        open();

        String[] str = new String[1];
        str[0] = indexId;

        Cursor cursor = database.rawQuery("SELECT description  FROM mokuso WHERE indexId = ?", str);
        cursor.moveToFirst();

        String result = cursor.getString(0);
        cursor.close();
        close();

        return result;

    }




}
