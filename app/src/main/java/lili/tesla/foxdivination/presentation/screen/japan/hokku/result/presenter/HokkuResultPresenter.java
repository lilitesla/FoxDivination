package lili.tesla.foxdivination.presentation.screen.japan.hokku.result.presenter;

import java.util.Random;

import lili.tesla.foxdivination.data.Hokku;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.japan.hokku.result.view.HokkuResultView;

/**
 * Created by Лилия on 05.12.2017.
 */

public class HokkuResultPresenter extends BasePresenter<HokkuResultView> {

    private static final Random random = new Random();

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResult() {
        int randomNum = random.nextInt(30) + 1;
        Hokku hokku = App.dataBaseAccess.getHokku(randomNum);
        mView.showResult(hokku);
    }

}
