package lili.tesla.foxdivination.presentation.screen.africa.spider.main.presenter;

import lili.tesla.foxdivination.presentation.screen.africa.spider.main.view.SpiderMainView;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;

/**
 * Created by Лилия on 03.12.2017.
 */

public class SpiderMainPresenter extends BasePresenter<SpiderMainView> {

    public void showDivinationScreen() {
        mView.showDivination();
    }

}
