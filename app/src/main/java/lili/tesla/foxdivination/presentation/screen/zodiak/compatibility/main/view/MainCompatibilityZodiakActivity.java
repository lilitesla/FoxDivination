package lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.main.presenter.MainCompatibilityZodiakPresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.result.view.ResultCompatibilityZodiakActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MainCompatibilityZodiakActivity extends BaseActivity implements MainCompatibilityZodiakView {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainCompatibilityZodiakActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MainCompatibilityZodiakPresenter mPresenter;

    @BindView(R.id.textview_zodiak_compatibility_man)
    TextView mTextviewMan;

    @BindView(R.id.textview_zodiak_compatibility_woman)
    TextView mTextviewWoman;

    @BindView(R.id.spinner_zodiak_compatibility_man)
    Spinner mSpinnerMan;

    @BindView(R.id.spinner_zodiak_compatibility_woman)
    Spinner mSpinnerWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_compatibility_zodiak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MainCompatibilityZodiakPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextviewMan);
        Utils.setTypefaceBold(mTextviewWoman);

    }

    @OnClick (R.id.button_zodiak_compatibility_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_zodiak_compatibility_start)
    void onButtonStartClick() {
        int spinIdMan = mSpinnerMan.getSelectedItemPosition() + 1;
        int spinIdWoman = mSpinnerWoman.getSelectedItemPosition() + 1;
        mPresenter.showResults(spinIdMan, spinIdWoman);
    }


    @Override
    public void showResults(int manZodiacId, int womanZodiacId) {
        ResultCompatibilityZodiakActivity.start(this, manZodiacId, womanZodiacId);
        finish();
    }
}
