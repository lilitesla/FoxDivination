package lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.result.presenter;

import lili.tesla.foxdivination.data.ZodiacCompatibility;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.result.view.ResultCompatibilityZodiakView;

/**
 * Created by Лилия on 02.12.2017.
 */

public class ResultCompatibilityZodiakPresenter extends BasePresenter<ResultCompatibilityZodiakView> {

    public void showMainActivity() {
        mView.showMainScreen();
    }

    public void showResults(int manZodiacId, int womanZodiacId) {

        ZodiacCompatibility zodiacCompatibility = App.dataBaseAccess.getZodiacCompatibility(manZodiacId, womanZodiacId);
        mView.showResults(zodiacCompatibility);
    }

}
