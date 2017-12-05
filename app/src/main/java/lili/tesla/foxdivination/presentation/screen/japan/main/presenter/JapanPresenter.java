package lili.tesla.foxdivination.presentation.screen.japan.main.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.japan.main.view.JapanView;

/**
 * Created by Лилия on 05.12.2017.
 */

public class JapanPresenter extends BasePresenter<JapanView> {

    public void showMokusoScreen() {
        mView.showMokusoScreen();
    }

    public void showHokkuScreen() {
        mView.showHokkuScreen();
    }


}
