package lili.tesla.foxdivination.presentation.screen.jewish.mainJewish.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.jewish.mainJewish.view.JewishView;

/**
 * Created by Лилия on 27.11.2017.
 */

public class JewishPresenter extends BasePresenter<JewishView> {

    public void showJewishQuestionScreen() {
        mView.showJewishQuestionScreen();
    }

    public void showKabbalaScreen() {
        mView.showKabbalaScreen();
    }

}
