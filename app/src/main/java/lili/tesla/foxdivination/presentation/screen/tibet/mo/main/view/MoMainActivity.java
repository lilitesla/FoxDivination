package lili.tesla.foxdivination.presentation.screen.tibet.mo.main.view;

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
import lili.tesla.foxdivination.presentation.screen.tibet.mo.main.presenter.MoMainPresenter;
import lili.tesla.foxdivination.presentation.screen.tibet.mo.result.view.MoResultActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MoMainActivity extends BaseActivity implements MoMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, MoMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MoMainPresenter mPresenter;

    @BindView(R.id.textview_mo_main_caption)
    TextView mTvMoCaption;

    @BindView(R.id.textview_mo_main_description)
    TextView mTvMoDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MoMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvMoCaption);
        Utils.setTypefaceLite(mTvMoDescription);
    }

    @OnClick(R.id.button_mo_main_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_mo_main_start)
    void onStartClick() {
        mPresenter.showResultsScreen();
    }

    @Override
    public void showResultsScreen() {
        MoResultActivity.start(this);
    }
}
