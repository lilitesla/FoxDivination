package lili.tesla.foxdivination.presentation.screen.japan.main.view;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.japan.hokku.main.view.HokkuMainActivity;
import lili.tesla.foxdivination.presentation.screen.japan.main.presenter.JapanPresenter;
import lili.tesla.foxdivination.presentation.screen.japan.mokuso.main.view.MokusoMainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class JapanActivity extends BaseActivity implements JapanView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, JapanActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private JapanPresenter mPresenter;

    @BindView(R.id.textview_japan_caption)
    TextView mTvJapanCaption;

    @BindView(R.id.textview_japan_description)
    TextView mTvJapanDescription;

    @BindView(R.id.textview_main_mokuso)
    TextView mTvMokuso;

    @BindView(R.id.textview_main_hokku)
    TextView mTvHokku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new JapanPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvJapanCaption);
        Utils.setTypefaceLite(mTvJapanDescription);

        Utils.setTypefaceLite(mTvMokuso);
        Utils.setTypefaceLite(mTvHokku);
    }

    @OnClick (R.id.button_japan_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.main_ll_mokuso)
    void onLlMokusoClick() {
        mPresenter.showMokusoScreen();
    }

    @OnClick (R.id.main_button_mokuso)
    void onButtonMokusoClick() {
        mPresenter.showMokusoScreen();
    }

    @OnClick (R.id.textview_main_mokuso)
    void onTvMokusoClick() {
        mPresenter.showMokusoScreen();
    }

    @OnClick (R.id.main_ll_hokku)
    void onLlHokkuClick() {
        mPresenter.showHokkuScreen();
    }

    @OnClick (R.id.main_button_hokku)
    void onButtonHokkuClick() {
        mPresenter.showHokkuScreen();
    }

    @OnClick (R.id.textview_main_hokku)
    void onTvHokkuClick() {
        mPresenter.showHokkuScreen();
    }

    @Override
    public void showMokusoScreen() {
        MokusoMainActivity.start(this);
    }

    @Override
    public void showHokkuScreen() {
        HokkuMainActivity.start(this);
    }
}
