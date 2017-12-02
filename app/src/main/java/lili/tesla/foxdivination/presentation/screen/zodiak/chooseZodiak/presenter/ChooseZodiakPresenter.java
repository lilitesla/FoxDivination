package lili.tesla.foxdivination.presentation.screen.zodiak.chooseZodiak.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.chooseZodiak.view.ChooseZodiakView;

/**
 * Created by Лилия on 02.12.2017.
 */

public class ChooseZodiakPresenter extends BasePresenter<ChooseZodiakView> {

    public void showGenderScreen(int zodiakId) {
        mView.showGenderScreen(zodiakId);
    }

}
