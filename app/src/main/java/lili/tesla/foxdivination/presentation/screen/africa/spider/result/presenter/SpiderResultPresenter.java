package lili.tesla.foxdivination.presentation.screen.africa.spider.result.presenter;

import java.util.Random;

import lili.tesla.foxdivination.presentation.screen.africa.spider.result.view.SpiderResultView;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;

/**
 * Created by Лилия on 03.12.2017.
 */

public class SpiderResultPresenter extends BasePresenter<SpiderResultView> {

    private static final Random random = new Random();

    public void showResult() {

        int[] wishes = new int[5];

        for (int i = 0; i < 5; i ++) {
            wishes[i] = random.nextInt(3);
        }

        mView.showResult(wishes);
    }

    public void showMainScreen() {
        mView.showMainScreen();
    }

}
