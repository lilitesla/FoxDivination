package lili.tesla.foxdivination.presentation.screen.africa.coffee.result.presenter;

import lili.tesla.foxdivination.data.Coffee;
import lili.tesla.foxdivination.presentation.application.App;
import lili.tesla.foxdivination.presentation.screen.africa.coffee.result.view.CoffeeResultView;
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

/**
 * Created by Лилия on 01.12.2017.
 */

public class CoffeeResultPresenter extends BasePresenter<CoffeeResultView> {

    public void showMainScreen() {
        mView.showMainScreen();
    }

    public void showResults() {

        int[] images = Utils.getRandomNums(100, 16);
        int count = 0;

        for (int i = 0; i < 16; i++) {
            images[i] = images[i]%3%2;

            if (images[i] == 1) {
                count ++;
            }
        }

        Coffee coffee = App.dataBaseAccess.getCoffee(count);
        coffee.setImages(images);

        mView.showResults(coffee);
    }


}
