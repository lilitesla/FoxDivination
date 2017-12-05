package lili.tesla.foxdivination.presentation.screen.japan.hokku.main.view;

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
import lili.tesla.foxdivination.presentation.screen.japan.hokku.main.presenter.HokkuMainPresenter;
import lili.tesla.foxdivination.presentation.screen.japan.hokku.result.view.HokkuResultActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class HokkuMainActivity extends BaseActivity implements HokkuMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, HokkuMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private HokkuMainPresenter mPresenter;

    @BindView(R.id.textview_hokku_main_caption)
    TextView mTvHokkuCaption;

    @BindView(R.id.textview_hokku_main_description)
    TextView mTvHokkuDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hokku_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new HokkuMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvHokkuCaption);
        Utils.setTypefaceLite(mTvHokkuDescription);
    }

    @OnClick(R.id.button_hokku_main_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_hokku_main_start)
    void onStartClick() {
        mPresenter.showResultScreen();
    }

    @Override
    public void showResultScreen() {
        HokkuResultActivity.start(this);
    }
}
