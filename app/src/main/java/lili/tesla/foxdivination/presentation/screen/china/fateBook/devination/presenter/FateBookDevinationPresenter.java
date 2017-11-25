package lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.presenter;

import java.util.Random;

import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.view.FateBookDevinationView;

/**
 * Created by Лилия on 24.11.2017.
 */

public class FateBookDevinationPresenter extends BasePresenter<FateBookDevinationView> {

    private final Random random = new Random();

    private String mPredIndex = "";
    private int clickNum = 0;

   public void showLines() {
       for (int i = 0; i < clickNum; i ++) {
           showLine(i);
       }

    }

    public void addLine() {
        clickNum ++;

        int coin1 = random.nextInt(2) + 1;
        int coin2 = random.nextInt(2) + 1;
        int coin3 = random.nextInt(2) + 1;

        if (coin1 + coin2 + coin3 > 4) {
            mPredIndex += "2";
        } else {
            mPredIndex += "1";
        }

        showLine(clickNum - 1);
        showCoin(coin1, coin2, coin3);
        changeManualText();

        if (clickNum == 6) {
            mView.showResultButton();
        }

    }

    public void showLine(int num) {
       mView.showLine(num, (mPredIndex.charAt(num) == '2'));
    }

    public void showCoin(int coin1, int coin2, int coin3) {
        mView.showCoin(coin1, coin2, coin3, mPredIndex.charAt(clickNum-1) == '2');
    }

    public void showResultScreen() {

        mView.showResultScreen(App.dataBaseAccess.getFateBookId(mPredIndex));
    }

    public void changeManualText() {
        mView.changeManualText(clickNum);
    }

}
