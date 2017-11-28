package lili.tesla.foxdivination.presentation.screen.jewish.kabbala.devination.presenter;

import java.util.ArrayList;
import java.util.List;

import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.devination.view.KabbalaDevinationView;

/**
 * Created by Лилия on 27.11.2017.
 */

public class KabbalaDevinationPresenter extends BasePresenter<KabbalaDevinationView> {

    private String sAlphabet;
    private String sFio;
    private List<Integer> listInt;

    public void calculate(String fio) {

        sFio = fio;
        fio = fio.toUpperCase().replace("Й", "И").replace(" ", "").replace("Ё", "Е")
        .replace("Ъ", "").replace("Ы", "").replace("Ь", "");

        int sum = 0;
        int num = 0;
        String sResult = "";

        for (int i = 0; i < fio.length(); i ++) {

           num = App.dataBaseAccess.getKabbalaAlphabetNum (String.valueOf(fio.charAt(i)));
           sum += num;

           sResult += num + " + ";
        }

        sResult = sResult.substring(0, sResult.length() - 2) + "= \n" + sum + " = \n";

        listInt = App.dataBaseAccess.getKabbalaValueList();

        int i = 0;
        sAlphabet = "";

        while (sum > 0) {
            if (listInt.get(i) <= sum) {

                sum -= listInt.get(i);
                sResult += listInt.get(i) + " + ";
                sAlphabet += listInt.get(i) + " - " + App.dataBaseAccess.getKabbalaDescription(listInt.get(i)) + "\n";

                i++;
            } else {
                i++;
            }
        }

        sResult = sResult.substring(0, sResult.length() - 2);

        mView.showCalculate(sResult);
    }

    public void showResultScreen() {
        mView.showResultScreen(sAlphabet, sFio);
    }


}
