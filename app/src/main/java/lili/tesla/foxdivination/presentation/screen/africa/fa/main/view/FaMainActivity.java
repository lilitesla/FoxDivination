package lili.tesla.foxdivination.presentation.screen.africa.fa.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.africa.fa.main.presenter.FaMainPresenter;
import lili.tesla.foxdivination.presentation.screen.africa.fa.result.view.FaResultActivity;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class FaMainActivity extends BaseActivity implements FaMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, FaMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private FaMainPresenter mPresenter;

    @BindView(R.id.textview_fa_main_caption)
    TextView mTvCaption;

    @BindView(R.id.textview_fa_main_description)
    TextView mTvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new FaMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvCaption);
        Utils.setTypefaceLite(mTvDescription);
    }

    @OnClick (R.id.button_fa_main_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_fa_main_start)
    void onFaStartClick() {
        mPresenter.showResultScreen();
    }

    @Override
    public void showResultScreen() {
        FaResultActivity.start(this);
    }
}
