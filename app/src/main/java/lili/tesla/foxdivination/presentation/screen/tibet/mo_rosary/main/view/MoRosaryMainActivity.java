package lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.main.view;

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
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.divination.view.MoRosaryDivinationActivity;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.main.presenter.MoRosaryMainPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MoRosaryMainActivity extends BaseActivity implements MoRosaryMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, MoRosaryMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MoRosaryMainPresenter mPresenter;

    @BindView(R.id.textview_mo_rosary_main_caption)
    TextView mTvMoRosaryCaption;

    @BindView(R.id.textview_mo_rosary_main_description)
    TextView mTvMoRosaryDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_rosary_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MoRosaryMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvMoRosaryCaption);
        Utils.setTypefaceLite(mTvMoRosaryDescription);
    }

    @OnClick(R.id.button_mo_rosary_main_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_mo_rosary_main_start)
    void onStartClick() {
        mPresenter.showDivinationScreen();
    }

    @Override
    public void showDivinationScreen() {
        MoRosaryDivinationActivity.start(this);
    }
}
