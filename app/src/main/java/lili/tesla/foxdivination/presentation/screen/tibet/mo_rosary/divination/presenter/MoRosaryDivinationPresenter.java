package lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.divination.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.divination.view.MoRosarydDivinationView;

/**
 * Created by Лилия on 07.12.2017.
 */

public class MoRosaryDivinationPresenter extends BasePresenter<MoRosarydDivinationView> {

    public void showResultScreen(int cha){
        mView.showResultScreen(cha);
    }

}
