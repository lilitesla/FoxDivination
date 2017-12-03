package lili.tesla.foxdivination.presentation.screen.africa.spider.main.view;

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
import lili.tesla.foxdivination.presentation.screen.africa.spider.divination.view.SpiderDivinationActivity;
import lili.tesla.foxdivination.presentation.screen.africa.spider.main.presenter.SpiderMainPresenter;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class SpiderMainActivity extends BaseActivity implements SpiderMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, SpiderMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @BindView(R.id.textview_spider_main_caption)
    TextView mTvCaption;

    @BindView(R.id.textview_spider_main_description)
    TextView mTvDescription;

    private SpiderMainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new SpiderMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvCaption);
        Utils.setTypefaceLite(mTvDescription);
    }

    @OnClick (R.id.button_spider_main_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_spider_main_start)
    void onStartClick() {
        mPresenter.showDivinationScreen();
    }

    @Override
    public void showDivination() {
        SpiderDivinationActivity.start(this);
    }
}
