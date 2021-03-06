package lili.tesla.foxdivination.presentation.screen.africa.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.africa.coffee.main.view.CoffeeMainActivity;
import lili.tesla.foxdivination.presentation.screen.africa.fa.main.view.FaMainActivity;
import lili.tesla.foxdivination.presentation.screen.africa.main.presenter.AfricaMainPresenter;
import lili.tesla.foxdivination.presentation.screen.africa.spider.main.view.SpiderMainActivity;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class AfricaMainActivity extends BaseActivity implements AfricaMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, AfricaMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private AfricaMainPresenter mPresenter;

    @BindView(R.id.textview_africa_caption)
    TextView mTextViewAfricaCaption;

    @BindView(R.id.textview_africa_description)
    TextView mTextViewAfricaDescription;

    @BindView(R.id.textview_main_coffee)
    TextView mMainTextviewCoffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africa_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new AfricaMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewAfricaCaption);
        Utils.setTypefaceLite(mTextViewAfricaDescription);
        Utils.setTypefaceLite(mMainTextviewCoffee);
    }

    @OnClick (R.id.main_ll_coffee)
    void onMainLlCoffeeClick() {
        mPresenter.showCoffeeScreen();
    }

    @OnClick (R.id.main_button_coffee)
    void onMainButtonCoffeeClick() {
        mPresenter.showCoffeeScreen();
    }

    @OnClick (R.id.textview_main_coffee)
    void onTextViewMainCoffee() {
        mPresenter.showCoffeeScreen();
    }


    @OnClick (R.id.main_ll_fa)
    void onMainLLFaClick() {
        mPresenter.showFaScreen();
    }

    @OnClick (R.id.main_button_fa)
    void onMainButtonFaClick() {
        mPresenter.showFaScreen();
    }

    @OnClick (R.id.textview_main_fa)
    void onMainTvFaClick()  {
        mPresenter.showFaScreen();
    }


    @OnClick (R.id.main_ll_spider)
    void onMainLLSpiderClick() {
        mPresenter.showSpiderScreen();
    }

    @OnClick (R.id.main_button_spider)
    void onMainButtonSpiderClick() {
        mPresenter.showSpiderScreen();
    }

    @OnClick (R.id.textview_main_spider)
    void onMainTvSpiderClick()  {
        mPresenter.showSpiderScreen();
    }



    @OnClick (R.id.button_africa_back)
    void onBackClick() {
        finish();
    }

    @Override
    public void showCoffeeScreen() {
        CoffeeMainActivity.start(this);
    }

    @Override
    public void showFaScreen() {
        FaMainActivity.start(this);
    }

    @Override
    public void showSpiderScreen() {
        SpiderMainActivity.start(this);
    }
}
