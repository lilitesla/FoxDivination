package lili.tesla.foxdivination.presentation.screen.main.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainView;

/**
 * Created by Лилия on 24.11.2017.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public void showChinaScreen() {
        mView.showChinaScreen();
    }

    public void showEkaterinaScreen() { mView.showEkaterinaScreen(); }

    public void showJewishScreen() { mView.showJewishScreen(); }

    public void showAfricaScreen() { mView.showAfricaScreen(); }

    public void showZodiakScreen() { mView.showZodiakScreen(); }

    public void showJapanScreen() {
        mView.showJapanScreen();
    }

    public void showTibetScreen() { mView.showTibetScreen(); }
}
