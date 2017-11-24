package lili.tesla.foxdivination.presentation.screen.china.fateBook.main.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.main.view.FateBookMainView;

/**
 * Created by Лилия on 24.11.2017.
 */

public class FateBookMainPresenter extends BasePresenter<FateBookMainView> {

    private boolean descriptionIsAbout = false;

    public void showChinaScreen() {
        mView.showChinaScreen();
    }

    public void changeDescriptionText() {
        if (descriptionIsAbout) {
            mView.showAbout();
        } else {
            mView.showDescription();
        }
    }

    public void changeStateDescription() {
        descriptionIsAbout = !descriptionIsAbout;
    }

    public void showFateBookDivination() {
        mView.showFateBookDivination();
    }
}
