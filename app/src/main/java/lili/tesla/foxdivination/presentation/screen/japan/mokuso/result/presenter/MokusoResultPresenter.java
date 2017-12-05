package lili.tesla.foxdivination.presentation.screen.japan.mokuso.result.presenter;

import java.util.Random;

import lili.tesla.foxdivination.data.Mokuso;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.japan.mokuso.result.view.MokusoResultView;

/**
 * Created by Лилия on 05.12.2017.
 */

public class MokusoResultPresenter extends BasePresenter<MokusoResultView> {

    private static final Random random = new Random();

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResult() {

        String indexId = "";

        for (int i = 0; i < 4; i ++) {
            int randomNum = random.nextInt(2) + 1;

            indexId += randomNum;

        }

        String description = App.dataBaseAccess.getMokuso(indexId);
        Mokuso mokuso = new Mokuso(indexId, description);

        mView.showResult(mokuso);
    }

}
