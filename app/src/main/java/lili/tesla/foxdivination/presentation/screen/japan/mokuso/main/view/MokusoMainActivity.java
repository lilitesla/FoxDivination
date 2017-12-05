package lili.tesla.foxdivination.presentation.screen.japan.mokuso.main.view;

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
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.japan.mokuso.main.presenter.MokusoMainPresenter;
import lili.tesla.foxdivination.presentation.screen.japan.mokuso.result.view.MokusoResultActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MokusoMainActivity extends BaseActivity implements MokusoMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, MokusoMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MokusoMainPresenter mPresenter;

    @BindView(R.id.textview_mokuso_main_caption)
    TextView mTvMokusoCaption;

    @BindView(R.id.textview_mokuso_main_description)
    TextView mTvMokusoDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokuso_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MokusoMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvMokusoCaption);
        Utils.setTypefaceLite(mTvMokusoDescription);
    }

    @OnClick (R.id.button_mokuso_main_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_mokuso_main_start)
    void onStartClick() {
        mPresenter.showResultScreen();
    }

    @Override
    public void showResultScreen() {
        MokusoResultActivity.start(this);
    }
}
