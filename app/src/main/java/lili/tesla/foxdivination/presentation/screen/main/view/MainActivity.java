package lili.tesla.foxdivination.presentation.screen.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.view.ChinaActivity;
import lili.tesla.foxdivination.presentation.screen.ekaterina.main.view.EkaterinaMainActivity;
import lili.tesla.foxdivination.presentation.screen.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView{

    public static void start(Context context ) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MainPresenter();
        mPresenter.setView(this);
    }

    @OnClick (R.id.main_button_china)
    void onMainButtonChinaClick() {
        mPresenter.showChinaScreen();
    }

    @OnClick (R.id.main_button_ekaterina)
    void onMainButtonEkaterinaClick() { mPresenter.showEkaterinaScreen(); }

    @Override
    public void showChinaScreen() {
        ChinaActivity.start(this);
    }

    @Override
    public void showEkaterinaScreen() {
        EkaterinaMainActivity.start(this);
    }
}
