package lili.tesla.foxdivination.presentation.screen.china.domino.resultSeven.presenter;

import lili.tesla.foxdivination.data.Domino;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultSeven.view.DominoResultSevenView;
import lili.tesla.foxdivination.presentation.util.Utils;

/**
 * Created by Лилия on 26.11.2017.
 */

public class DominoResultSevenPresenter extends BasePresenter<DominoResultSevenView> {

    private int count = 7;

    public void showResults() {
        int[] nums = Utils.getRandomNums(28, count);

        Domino[] dominoes = new Domino[count];

        for (int i = 0; i < count; i ++) {
            dominoes[i] = new Domino(nums[i]);
        }

        mView.showResults(dominoes);
    }

}
