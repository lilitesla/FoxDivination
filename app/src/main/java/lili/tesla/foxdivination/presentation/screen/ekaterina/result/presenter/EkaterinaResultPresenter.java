package lili.tesla.foxdivination.presentation.screen.ekaterina.result.presenter;

import java.util.Random;

import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Ekaterina;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.ekaterina.result.view.EkaterinaResultView;

/**
 * Created by Лилия on 25.11.2017.
 */

public class EkaterinaResultPresenter extends BasePresenter<EkaterinaResultView> {

    private final Random random = new Random();

    public void showResults() {

        int[] nums = getRandomNums();

        Ekaterina ekaterina = App.dataBaseAccess.getEkaterinaPrediction(nums);

        ekaterina.setImageId1(getImageId(nums[0]));
        ekaterina.setImageId2(getImageId(nums[1]));
        ekaterina.setImageId3(getImageId(nums[2]));

        mView.showResults(ekaterina);
    }

    private int[] getRandomNums() {

        int[] nums = new int[3];

        nums[0] = random.nextInt(40) + 1;
        nums[1] = nums[0];

        while (nums[1] == nums[0]) {
            nums[1] = random.nextInt(40) + 1;
        }

        nums[2] = nums[1];

        while ((nums[2] == nums[1])||(nums[2] == nums[0])) {
            nums[2] = random.nextInt(40) + 1;
        }

        return nums;
    }

    private int getImageId(int imageNum) {

        int result = 0;

        switch (imageNum) {
            case 1: result = R.drawable.ekaterina_drum; break;
            case 2: result = R.drawable.ekaterina_bow; break;
            case 3: result = R.drawable.ekaterina_weigher; break;
            case 4: result = R.drawable.ekaterina_hair; break;
            case 5: result = R.drawable.ekaterina_woman; break;
            case 6: result = R.drawable.ekaterina_coins; break;
            case 7: result = R.drawable.ekaterina_tree; break;
            case 8: result = R.drawable.ekaterina_lock; break;
            case 9: result = R.drawable.ekaterina_coach; break;
            case 10: result = R.drawable.ekaterina_dagger; break;
            case 11: result = R.drawable.ekaterina_keys; break;
            case 12: result = R.drawable.ekaterina_book; break;
            case 13: result = R.drawable.ekaterina_bell; break;
            case 14: result = R.drawable.ekaterina_quiver_arrows; break;
            case 15: result = R.drawable.ekaterina_rings; break;
            case 16: result = R.drawable.ekaterina_cover; break;
            case 17: result = R.drawable.ekaterina_crown; break;
            case 18: result = R.drawable.ekaterina_ship; break;
            case 19: result = R.drawable.ekaterina_bonfire; break;
            case 20: result = R.drawable.ekaterina_cross; break;
            case 21: result = R.drawable.ekaterina_swan; break;
            case 22: result = R.drawable.ekaterina_moon_stars; break;
            case 23: result = R.drawable.ekaterina_man; break;
            case 24: result = R.drawable.ekaterina_horseshoe; break;
            case 25: result = R.drawable.ekaterina_rainbow; break;
            case 26: result = R.drawable.ekaterina_glass; break;
            case 27: result = R.drawable.ekaterina_candles; break;
            case 28: result = R.drawable.ekaterina_heart; break;
            case 29: result = R.drawable.ekaterina_sun; break;
            case 30: result = R.drawable.ekaterina_arrow; break;
            case 31: result = R.drawable.ekaterina_sultan; break;
            case 32: result = R.drawable.ekaterina_snail; break;
            case 33: result = R.drawable.ekaterina_veil; break;
            case 34: result = R.drawable.ekaterina_flower; break;
            case 35: result = R.drawable.ekaterina_chains; break;
            case 36: result = R.drawable.ekaterina_church; break;
            case 37: result = R.drawable.ekaterina_clock; break;
            case 38: result = R.drawable.ekaterina_heck; break;
            case 39: result = R.drawable.ekaterina_skull; break;
            case 40: result = R.drawable.ekaterina_anchor; break;
        }

        return result;

    }

}
