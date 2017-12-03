package lili.tesla.foxdivination.presentation.screen.jewish.kabbala.devination.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.devination.presenter.KabbalaDevinationPresenter;
import lili.tesla.foxdivination.presentation.screen.jewish.kabbala.result.view.KabbalaResultActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class KabbalaDevinationActivity extends BaseActivity implements KabbalaDevinationView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, KabbalaDevinationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private KabbalaDevinationPresenter mPresenter;

    @BindView(R.id.textview_kabbala_devination_manual)
    TextView mTextviewKabbalaDevinationManual;

    @BindView(R.id.textview_kabbala_devination_description)
    TextView mTextviewKabbalaDevinationDescription;

    @BindView(R.id.edittext_kabbala_devination_fio)
    EditText mEdittextKabbalaDevinationFio;

    @BindView(R.id.button_kabbala_devination_calc)
    Button mButtonKabbalaDevinationCalc;

    @BindView(R.id.button_kabbala_devination_show_result)
    Button mButtonKabbalaDevinationShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabbala_devination);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new KabbalaDevinationPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceLite(mTextviewKabbalaDevinationManual);
        Utils.setTypefaceLite(mTextviewKabbalaDevinationDescription);
    }

    @OnClick (R.id.button_kabbala_devination_back)
    void onBackClick(){
        finish();
    }

    @OnClick (R.id.button_kabbala_devination_calc)
    void onButtonKabbalaDevinationCalc() {
        String sFio = mEdittextKabbalaDevinationFio.getText().toString();
        mPresenter.calculate(sFio);
    }

    @OnClick (R.id.button_kabbala_devination_show_result)
    void onButtonKabbalaShowResult() {
        mPresenter.showResultScreen();
        finish();
    }

    @Override
    public void showCalculate(String sResult) {
       // mButtonKabbalaDevinationCalc.setVisibility(View.GONE);
        mButtonKabbalaDevinationShowResult.setVisibility(View.VISIBLE);
        mTextviewKabbalaDevinationDescription.setText(sResult);
    }

    @Override
    public void showResultScreen(String sResult, String sFio) {
        KabbalaResultActivity.start(this, sResult, sFio);
    }

}
