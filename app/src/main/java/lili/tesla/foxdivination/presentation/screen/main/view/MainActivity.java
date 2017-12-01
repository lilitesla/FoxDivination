package lili.tesla.foxdivination.presentation.screen.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.africa.main.view.AfricaMainActivity;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.view.ChinaActivity;
import lili.tesla.foxdivination.presentation.screen.ekaterina.main.view.EkaterinaMainActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.mainJewish.view.JewishActivity;
import lili.tesla.foxdivination.presentation.screen.main.presenter.MainPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MainActivity extends BaseActivity implements MainView{

    public static void start(Context context ) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MainPresenter mPresenter;

    @BindView(R.id.textview_main_china)
    TextView mTextViewMainChina;

    @BindView(R.id.textview_main_ekaterina)
    TextView mTextViewMainEkaterina;

    @BindView(R.id.textview_main_jewish)
    TextView mTextViewMainJewish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceLite(mTextViewMainChina);
        Utils.setTypefaceLite(mTextViewMainEkaterina);
        Utils.setTypefaceLite(mTextViewMainJewish);
    }

    @OnClick (R.id.main_button_china)
    void onMainButtonChinaClick() {
        mPresenter.showChinaScreen();
    }

    @OnClick (R.id.main_ll_china)
    void onMainLlChinaClick() {
        mPresenter.showChinaScreen();
    }

    @OnClick (R.id.textview_main_china)
    void onMainTvChinaClick() {
        mPresenter.showChinaScreen();
    }

    @OnClick (R.id.main_button_ekaterina)
    void onMainButtonEkaterinaClick() { mPresenter.showEkaterinaScreen(); }

    @OnClick (R.id.main_ll_ekaterina)
    void onMainLlEkaterinaClick() { mPresenter.showEkaterinaScreen(); }

    @OnClick (R.id.textview_main_ekaterina)
    void onMainTvEkaterinaClick() { mPresenter.showEkaterinaScreen(); }

    @OnClick (R.id.main_button_jewish)
    void onMainButtonJewishClick() { mPresenter.showJewishScreen(); }

    @OnClick (R.id.main_ll_jewish)
    void onMainLlJewishClick() { mPresenter.showJewishScreen(); }

    @OnClick (R.id.textview_main_jewish)
    void onMainTvJewishClick() { mPresenter.showJewishScreen(); }

    @OnClick (R.id.main_ll_africa)
    void onMainLlAfricaClick() { mPresenter.showAfricaScreen(); }

    @OnClick (R.id.main_button_africa)
    void onMainButtonAfricaClick() { mPresenter.showAfricaScreen(); }

    @OnClick (R.id.textview_main_africa)
    void onMainTextViewAfricaClick() { mPresenter.showAfricaScreen(); }

    @Override
    public void showChinaScreen() {
        ChinaActivity.start(this);
    }

    @Override
    public void showEkaterinaScreen() {
        EkaterinaMainActivity.start(this);
    }

    @Override
    public void showJewishScreen() {
        JewishActivity.start(this);
    }

    @Override
    public void showAfricaScreen() {
        AfricaMainActivity.start(this);
    }


}
