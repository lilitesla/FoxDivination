package lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.result.presenter;

import java.util.Random;

import lili.tesla.foxdivination.data.MoRosary;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.result.view.MoRosaryResultView;

/**
 * Created by Лилия on 07.12.2017.
 */

public class MoRosaryResultPresenter extends BasePresenter<MoRosaryResultView> {

    private static final Random random = new Random();

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResults() {
        
        String indexId = "";

        for (int i = 0; i < 3; i ++) {
            int randomNum = random.nextInt(3) + 1;
            indexId += randomNum;
        }

        MoRosary moRosary = App.dataBaseAccess.getMoRosary(indexId);
        mView.showResult(moRosary);
    }


}
