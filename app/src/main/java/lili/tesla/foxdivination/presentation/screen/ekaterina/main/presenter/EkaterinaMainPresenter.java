package lili.tesla.foxdivination.presentation.screen.ekaterina.main.presenter;

import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.ekaterina.main.view.EkaterinaMainView;

/**
 * Created by Лилия on 25.11.2017.
 */

public class EkaterinaMainPresenter extends BasePresenter<EkaterinaMainView> {

    private boolean descriptionIsAbout = false;

    public void changeDescriptionText() {
        if (descriptionIsAbout) {
            mView.showAbout();
        } else {
            mView.showDescription();
        }
    }

    public void changeStateDescription() {
        descriptionIsAbout = !descriptionIsAbout;
    }

    public void showEkaterinaResult() {
        mView.showEkaterinaResult();
    }

}
