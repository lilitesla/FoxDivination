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


}
