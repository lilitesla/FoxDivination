package lili.tesla.foxdivination.presentation.screen.jewish.kabbala.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.result.presenter.KabbalaResultPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class KabbalaResultActivity extends BaseActivity implements KabbalaResultView {

    public static final String EXTRA_KEY_RESULT = "KEY_RESULT";
    public static final String EXTRA_KEY_FIO = "KEY_FIO";


    public static void start(Context context, String sResult, String sFio ) {
        Intent intent = new Intent(context, KabbalaResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString( EXTRA_KEY_RESULT, sResult);
        bundle.putString( EXTRA_KEY_FIO, sFio);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private KabbalaResultPresenter mPresenter;

    @BindView(R.id.textview_kabbala_result_caption)
    TextView mTextviewKabbalaResultCaption;

    @BindView(R.id.textview_kabbala_result_description)
    TextView mTextviewKabbalaResultDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabbala_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new KabbalaResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextviewKabbalaResultCaption);
        Utils.setTypefaceLite(mTextviewKabbalaResultDescription);

        mPresenter.showResults (getIntent().getStringExtra(EXTRA_KEY_RESULT), getIntent().getStringExtra(EXTRA_KEY_FIO));

    }

    @OnClick (R.id.button_kabbala_result_close)
    void onButtonKabbalaResultClose() {
        mPresenter.showMainScreen();
    }

    @OnClick (R.id.button_kabbala_main_back)
    void onButtonKabbalaMainBack() {
        finish();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResult(String sResult, String sFio) {
        mTextviewKabbalaResultCaption.setText(sFio);
        mTextviewKabbalaResultDescription.setText(sResult);
    }
}
