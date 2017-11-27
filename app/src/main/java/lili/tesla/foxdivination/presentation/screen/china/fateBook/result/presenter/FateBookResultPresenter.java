package lili.tesla.foxdivination.presentation.screen.china.fateBook.result.presenter;

import lili.tesla.foxdivination.data.Prediction;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.result.view.FateBookResultView;

/**
 * Created by Лилия on 24.11.2017.
 */

public class FateBookResultPresenter extends BasePresenter<FateBookResultView> {

    private String mPredId = "";
    private Prediction mPrediction;

    public void showResults(String predId) {
        if (mPredId == "") {
            mPredId = predId;
            mPrediction = App.dataBaseAccess.getFateBookPrediction(mPredId);
        }
        mView.showResults(mPrediction);
    }

    public void showMainScreen() {
        mView.showMainScreen();
    }

}
