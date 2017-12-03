package lili.tesla.foxdivination.presentation.screen.zodiak.mainZodiak.presenter;

import lili.tesla.foxdivination.data.Zodiac;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.mainZodiak.view.MainZodiakView;

/**
 * Created by Лилия on 02.12.2017.
 */

public class MainZodiakPresenter extends BasePresenter<MainZodiakView> {

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResults(int gender, int zodiakId, int pred) {

        if (pred == 0) {
            Zodiac zodiac = App.dataBaseAccess.getMainZodiac(gender, zodiakId);
            mView.showResults(zodiac, pred);
        } else {
            Zodiac zodiac = App.dataBaseAccess.getLoveZodiac(gender, zodiakId);
            mView.showResults(zodiac, pred);
        }

    }



}
