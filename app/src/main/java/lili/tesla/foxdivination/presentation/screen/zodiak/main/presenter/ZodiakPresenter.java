package lili.tesla.foxdivination.presentation.screen.zodiak.main.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.main.view.ZodiakView;

/**
 * Created by Лилия on 02.12.2017.
 */

public class ZodiakPresenter extends BasePresenter<ZodiakView> {

    public void showMainZodiakScreen() {
        mView.showMainZodiakScreen();
    }

    public void showLoveZodiakScreen() {
        mView.showLoveZodiakScreen();
    }

    public void showCompatibilityZodiakScreen() {
        mView.showCompatibilityZodiakScreen();
    }

}
