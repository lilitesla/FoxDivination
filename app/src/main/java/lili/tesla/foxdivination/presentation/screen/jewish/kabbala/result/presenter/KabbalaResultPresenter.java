package lili.tesla.foxdivination.presentation.screen.jewish.kabbala.result.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.result.view.KabbalaResultView;

/**
 * Created by Лилия on 27.11.2017.
 */

public class KabbalaResultPresenter extends BasePresenter<KabbalaResultView> {

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResults (String sResult, String sFio ) {
        mView.showResult(sResult, sFio);
    }

}
