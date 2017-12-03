package lili.tesla.foxdivination.presentation.screen.africa.fa.result.presenter;

import lili.tesla.foxdivination.data.CoinAfrica;
import lili.tesla.foxdivination.data.CoinsAfrica;
import lili.tesla.foxdivination.presentation.screen.africa.fa.result.view.FaResultView;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

/**
 * Created by Лилия on 03.12.2017.
 */

public class FaResultPresenter extends BasePresenter<FaResultView> {

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResults() {
        CoinsAfrica coins = new CoinsAfrica();
        mView.showResults(coins);
    }

}
