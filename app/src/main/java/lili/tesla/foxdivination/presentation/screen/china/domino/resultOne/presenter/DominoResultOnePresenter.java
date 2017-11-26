package lili.tesla.foxdivination.presentation.screen.china.domino.resultOne.presenter;

import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Domino;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultOne.view.DominoResultOneView;
import lili.tesla.foxdivination.presentation.util.Utils;

/**
 * Created by Лилия on 26.11.2017.
 */

public class DominoResultOnePresenter extends BasePresenter<DominoResultOneView> {

    private int count = 1;

    public void showResults() {
        int[] nums = Utils.getRandomNums(28, count);

        Domino[] dominoes = new Domino[count];

        for (int i = 0; i < count; i ++) {
            dominoes[i] = new Domino(nums[i]);
        }

        mView.showResults(dominoes);
    }



}
