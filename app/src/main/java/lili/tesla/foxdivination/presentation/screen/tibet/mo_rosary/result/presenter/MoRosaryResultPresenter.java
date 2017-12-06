package lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.result.presenter;

import lili.tesla.foxdivination.data.MoRosary;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.result.view.MoRosaryResultView;

/**
 * Created by Лилия on 07.12.2017.
 */

public class MoRosaryResultPresenter extends BasePresenter<MoRosaryResultView> {

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResults() {
        
        String indexId = "";

        // TODO: 07.12.2017 генерация indexId
        MoRosary moRosary = App.dataBaseAccess.getMoRosary(indexId);               

        mView.showResult(moRosary);
    }


}
