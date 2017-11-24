package lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.view;

/**
 * Created by Лилия on 24.11.2017.
 */

public interface FateBookDevinationView {

    void showResultScreen(int predId);

    void showLine(int lineNum, boolean isSolid);

    void showResultButton();

    void showCoin(int coin1, int coin2, int coin3, boolean isYan);

    void changeManualText(int col);

}
