package lili.tesla.foxdivination.presentation.screen.main.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.view.ChinaActivity;
import lili.tesla.foxdivination.presentation.screen.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView{

    public static void start(Context context ) {
        Intent intent = new Intent(context, MainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mPresenter = new MainPresenter();
        mPresenter.setView(this);
    }

    @OnClick (R.id.main_button_china)
    void onMainButtonChinaClick() {
        mPresenter.showChinaScreen();
    }

    @Override
    public void showChinaScreen() {
        ChinaActivity.start(this);
    }
}
