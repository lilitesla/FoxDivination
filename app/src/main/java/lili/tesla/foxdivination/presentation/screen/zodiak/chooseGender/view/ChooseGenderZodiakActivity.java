package lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.presenter.ChooseGenderZodiakPresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.mainZodiak.view.MainZodiakActivity;

public class ChooseGenderZodiakActivity extends BaseActivity implements ChooseGenderZodiakView {

    public static final String EXTRA_KEY_ZODIAC = "KEY_ZODIAC";
    public static final String EXTRA_KEY_PRED = "KEY_PRED";


    public static void start(Context context, int pred, int zodiakId) {
        Intent intent = new Intent(context, ChooseGenderZodiakActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_ZODIAC, zodiakId);
        bundle.putInt( EXTRA_KEY_PRED, pred);

        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ChooseGenderZodiakPresenter mPresenter;
    private int mZodiakId;
    private int mPred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gender_zodiak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new ChooseGenderZodiakPresenter();
        mPresenter.setView(this);

        mZodiakId = getIntent().getIntExtra(EXTRA_KEY_ZODIAC, 0);
        mPred = getIntent().getIntExtra(EXTRA_KEY_PRED, 0);
    }

    @OnClick(R.id.button_choose_zodiak_gender_back)
    void onButtonChooseGenderBackClick() {
        finish();
    }

    @OnClick (R.id.image_choose_zodiak_gender_woman)
    void onButtonWomanClick() {
        mPresenter.showZodiakResult(mPred, 0);
        finish();
    }

    @OnClick (R.id.image_choose_zodiak_gender_man)
    void onButtonManClick() {
        mPresenter.showZodiakResult(mPred, 1);
        finish();
    }

    @Override
    public void showMainZodiakScreen(int gender, int pred) {
        MainZodiakActivity.start(this, gender, mZodiakId, pred);
    }

}
