package lili.tesla.foxdivination.presentation.screen.ekaterina.result.presenter;

import java.util.Random;

import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Ekaterina;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.ekaterina.result.view.EkaterinaResultView;
import lili.tesla.foxdivination.presentation.util.Utils;

/**
 * Created by Лилия on 25.11.2017.
 */

public class EkaterinaResultPresenter extends BasePresenter<EkaterinaResultView> {

    public void showResults() {

        int[] nums = Utils.getRandomNums(40, 3);

        Ekaterina ekaterina = App.dataBaseAccess.getEkaterinaPrediction(nums);

        mView.showResults(ekaterina);
    }

}
