package lili.tesla.foxdivination.presentation.screen.jewish.mainJewish.view;

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
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.main.view.KabbalaMainActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.mainJewish.presenter.JewishPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class JewishActivity extends BaseActivity implements JewishView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, JewishActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private JewishPresenter mPresenter;

    @BindView (R.id.textview_jewish_caption)
    TextView mTextviewJewishCaption;

    @BindView (R.id.textview_jewish_description)
    TextView mTextviewJewishDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewish);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new JewishPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextviewJewishCaption);
        Utils.setTypefaceLite(mTextviewJewishDescription);
    }

    @OnClick (R.id.button_jewish_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.main_button_kabbala)
    void onButtonKabbalaClick() {
        mPresenter.showKabbalaScreen();
    }

    @OnClick (R.id.main_ll_kabbala)
    void onLlKabbalaClick() {
        mPresenter.showKabbalaScreen();
    }

    @OnClick (R.id.textview_main_kabbala)
    void onTvKabbalaClick() {
        mPresenter.showKabbalaScreen();
    }


    @Override
    public void showKabbalaScreen() {
        KabbalaMainActivity.start(this);
    }
}
