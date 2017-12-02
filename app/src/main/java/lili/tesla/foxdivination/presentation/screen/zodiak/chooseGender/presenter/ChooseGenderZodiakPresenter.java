package lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.view.ChooseGenderZodiakView;

/**
 * Created by Лилия on 02.12.2017.
 */

public class ChooseGenderZodiakPresenter extends BasePresenter<ChooseGenderZodiakView> {

    public void showZodiakResult(int pred, int gender) {
        if (pred == 0) {
            mView.showMainZodiakScreen(gender);
        } else {
            mView.showLoveZodiakScreen(gender);
        }
    }

}
