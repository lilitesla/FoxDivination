package lili.tesla.foxdivination.presentation.screen.africa.coffee.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.africa.coffee.main.presenter.CoffeeMainPresenter;
import lili.tesla.foxdivination.presentation.screen.africa.coffee.result.view.CoffeeResultActivity;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class CoffeeMainActivity extends BaseActivity implements CoffeeMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, CoffeeMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private CoffeeMainPresenter mPresenter;

    @BindView(R.id.textview_coffee_main_caption)
    TextView mTextViewCoffeeMainCaption;

    @BindView(R.id.textview_coffee_main_description)
    TextView mTextViewCoffeeMainDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new CoffeeMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewCoffeeMainCaption);
        Utils.setTypefaceLite(mTextViewCoffeeMainDescription);
    }

    @OnClick (R.id.button_coffee_main_back)
    void onButtonCoffeeMainBackClick() {
        finish();
    }

    @OnClick (R.id.button_coffee_main_start)
    void onButtonCoffeeMainStart() {
        mPresenter.showResultScreen();
    }

    @Override
    public void showResultScreen() {
        CoffeeResultActivity.start(this);
    }
}
