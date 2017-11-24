package lili.tesla.foxdivination.presentation.screen.china.fateBook.result.presenter;

import lili.tesla.foxdivination.data.Prediction;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.result.view.FateBookResultView;

/**
 * Created by Лилия on 24.11.2017.
 */

public class FateBookResultPresenter extends BasePresenter<FateBookResultView> {

    private int mPredId = 0;
    private Prediction mPrediction;

    public void showResults(int predId) {
        if (mPredId == 0) {
            mPredId = predId;
            mPrediction = App.dataBaseAccess.getFateBookPrediction(mPredId);
        }
        mView.showResults(mPrediction);
    }


}
