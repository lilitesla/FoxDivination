package lili.tesla.foxdivination.presentation.screen.jewish.kabbala.main.view;

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
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.devination.view.KabbalaDevinationActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.main.presenter.KabbalaMainPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class KabbalaMainActivity extends BaseActivity implements KabbalaMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, KabbalaMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private KabbalaMainPresenter mPresenter;

    @BindView(R.id.textview_kabbala_main_caption)
    TextView mTextviewKabbalaMainCaption;

    @BindView(R.id.textview_kabbala_main_description)
    TextView mTextviewKabbalaMainDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabbala_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new KabbalaMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextviewKabbalaMainCaption);
        Utils.setTypefaceLite(mTextviewKabbalaMainDescription);
    }

    @OnClick (R.id.button_kabbala_main_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_kabbala_main_start)
    void onButtonKabbalaMainStartClick() {
        mPresenter.showKabbalaDivinationScreen();
    }

    @Override
    public void showKabbalaDivinationScreen() {
        KabbalaDevinationActivity.start(this);
    }
}
