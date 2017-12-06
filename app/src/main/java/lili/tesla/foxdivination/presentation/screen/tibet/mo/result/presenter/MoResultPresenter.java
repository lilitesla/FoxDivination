package lili.tesla.foxdivination.presentation.screen.tibet.mo.result.presenter;

import lili.tesla.foxdivination.data.Mo;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.tibet.mo.result.view.MoResultView;

/**
 * Created by Лилия on 07.12.2017.
 */

public class MoResultPresenter extends BasePresenter<MoResultView> {

    private String[] slogs = new String[] {"АХ", "РА", "ПА", "НА", "ЦА", "ДХИ"};

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResult() {

        int randNum = 0;      // TODO: 07.12.2017 сделать нормальное получение рандомного числа
        String first = slogs[randNum];
        randNum = 0;     // TODO: 07.12.2017 сделать нормальное получение рандомного числа
        String second = slogs[randNum];
        Mo mo = App.dataBaseAccess.getMo(first, second);

        mView.showResult(mo);
    }

}
