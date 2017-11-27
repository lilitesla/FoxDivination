package lili.tesla.foxdivination.presentation.screen.china.domino.resultThree.presenter;

import lili.tesla.foxdivination.data.Domino;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultThree.view.DominoResultThreeView;
import lili.tesla.foxdivination.presentation.util.Utils;

/**
 * Created by Лилия on 26.11.2017.
 */

public class DominoResultThreePresenter extends BasePresenter<DominoResultThreeView> {

    private int count = 3;

    public void showResults() {
        int[] nums = Utils.getRandomNums(28, count);

        Domino[] dominoes = new Domino[count];

        for (int i = 0; i < count; i ++) {
            dominoes[i] = new Domino(nums[i]);
        }

        mView.showResults(dominoes);
    }

    public void showMainScreen() {
        mView.showMainScreen();
    }

}
