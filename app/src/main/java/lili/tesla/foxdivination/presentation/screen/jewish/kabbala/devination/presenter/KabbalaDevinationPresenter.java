package lili.tesla.foxdivination.presentation.screen.jewish.kabbala.devination.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.devination.view.KabbalaDevinationView;

/**
 * Created by Лилия on 27.11.2017.
 */

public class KabbalaDevinationPresenter extends BasePresenter<KabbalaDevinationView> {

    private String sAlphabet;
    private String sFio;

    public void calculate(String fio) {

        sFio = fio;
        sAlphabet = "";
        String sResult = "";
        // TODO: 28.11.2017 расчет sResult и sAlphabet

        mView.showCalculate(sResult);
    }

    public void showResultScreen() {
        mView.showResultScreen(sAlphabet, sFio);
    }


}
