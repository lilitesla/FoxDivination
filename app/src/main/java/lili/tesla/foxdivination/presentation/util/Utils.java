package lili.tesla.foxdivination.presentation.util;

import android.graphics.Typeface;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.application.App;

/**
 * Created by Лилия on 26.11.2017.
 */

public class Utils {

    private static final Random random = new Random();

    public static int[] getRandomNums(int max, int count) {

        int[] nums = new int[count];
        int randomNum = 0;

        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < max; i ++) {
            numsList.add(i + 1);
        }

        for (int i = 0; i < count; i ++) {
            randomNum = random.nextInt(numsList.size());

            nums[i] = numsList.get(randomNum);
            numsList.remove(numsList.get(randomNum));
        }

        return nums;
    }

    public static void setTypefaceLite(TextView tv) {
        tv.setTypeface(Typeface.createFromAsset(
                App.getContext().getAssets(),"fonts/segoeuil.ttf"));
    }

    public static void setTypefaceBold(TextView tv) {
        tv.setTypeface(Typeface.createFromAsset(
                App.getContext().getAssets(),"fonts/seguisb.ttf"));
    }

}
