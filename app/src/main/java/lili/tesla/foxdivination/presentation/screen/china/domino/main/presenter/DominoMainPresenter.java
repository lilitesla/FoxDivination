package lili.tesla.foxdivination.presentation.screen.china.domino.main.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.domino.main.view.DominoMainView;

/**
 * Created by Лилия on 26.11.2017.
 */

public class DominoMainPresenter extends BasePresenter<DominoMainView> {

    public void showDominoResultOneScreen() {
        mView.showDominoResultOneScreen();
    }

    public void showDominoResultThreeScreen() {
        mView.showDominoResultThreeScreen();
    }

    public void showDominoResultSevenScreen() {
        mView.showDominoResultSevenScreen();
    }

}
