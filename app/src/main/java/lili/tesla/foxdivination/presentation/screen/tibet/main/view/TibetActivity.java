package lili.tesla.foxdivination.presentation.screen.tibet.main.view;

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
import lili.tesla.foxdivination.presentation.screen.tibet.main.presenter.TibetPresenter;
import lili.tesla.foxdivination.presentation.screen.tibet.mo.main.view.MoMainActivity;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.main.view.MoRosaryMainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class TibetActivity extends BaseActivity implements TibetView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, TibetActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private TibetPresenter mPresenter;

    @BindView(R.id.textview_tibet_caption)
    TextView mTvTibetCaption;

    @BindView(R.id.textview_tibet_description)
    TextView mTvTibetDescription;

    @BindView(R.id.textview_main_mo)
    TextView mTvMo;

    @BindView(R.id.textview_main_mo_rosary)
    TextView mTvMoRosary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tibet);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new TibetPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvTibetCaption);
        Utils.setTypefaceLite(mTvTibetDescription);

        Utils.setTypefaceLite(mTvMo);
        Utils.setTypefaceLite(mTvMoRosary);
    }

    @OnClick(R.id.button_tibet_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.main_ll_mo)
    void onLlMokusoClick() {
        mPresenter.showMoScreen();
    }

    @OnClick (R.id.main_button_mo)
    void onButtonMokusoClick() {
        mPresenter.showMoScreen();
    }

    @OnClick (R.id.textview_main_mo)
    void onTvMokusoClick() {
        mPresenter.showMoScreen();
    }

    @OnClick (R.id.main_ll_mo_rosary)
    void onLlHokkuClick() {
        mPresenter.showMoRosaryScreen();
    }

    @OnClick (R.id.main_button_mo_rosary)
    void onButtonHokkuClick() {
        mPresenter.showMoRosaryScreen();
    }

    @OnClick (R.id.textview_main_mo_rosary)
    void onTvHokkuClick() {
        mPresenter.showMoRosaryScreen();
    }

    @Override
    public void showMoScreen() {
        MoMainActivity.start(this);
    }

    @Override
    public void showMoRosaryScreen() {
        MoRosaryMainActivity.start(this);
    }
}
