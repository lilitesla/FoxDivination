package lili.tesla.foxdivination.presentation.screen.china.mainChina.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.view.ChinaView;

/**
 * Created by Лилия on 24.11.2017.
 */

public class ChinaPresenter extends BasePresenter<ChinaView> {

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showFateBookScreen() {
        mView.showFateBookScreen();
    }

}
