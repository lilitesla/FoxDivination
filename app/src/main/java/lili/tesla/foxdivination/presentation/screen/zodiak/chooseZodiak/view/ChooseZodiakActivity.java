package lili.tesla.foxdivination.presentation.screen.zodiak.chooseZodiak.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.view.ChooseGenderZodiakActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.chooseZodiak.presenter.ChooseZodiakPresenter;

public class ChooseZodiakActivity extends BaseActivity implements ChooseZodiakView {

    public static final String EXTRA_KEY_PRED = "KEY_PRED";

    public static void start(Context context, int pred) {
        Intent intent = new Intent(context, ChooseZodiakActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_PRED, pred);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ChooseZodiakPresenter mPresenter;
    private int mPred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_zodiak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new ChooseZodiakPresenter();
        mPresenter.setView(this);


        mPred = getIntent().getIntExtra(EXTRA_KEY_PRED, 0);
    }

    @OnClick (R.id.ll_zodiak_aries)
    void onLLZAries() {
        mPresenter.showGenderScreen(1);
    }

    @OnClick (R.id.ll_zodiak_taurus)
    void onLLZTaurus() {
        mPresenter.showGenderScreen(2);
    }

    @OnClick (R.id.ll_zodiak_twins)
    void onLLZTwins() {
        mPresenter.showGenderScreen(3);
    }

    @OnClick (R.id.ll_zodiak_cancer)
    void onLLZCancer() {
        mPresenter.showGenderScreen(4);
    }

    @OnClick (R.id.ll_zodiak_lion)
    void onLLZLion() {
        mPresenter.showGenderScreen(5);
    }

    @OnClick (R.id.ll_zodiak_virgo)
    void onLLZVirgo() {
        mPresenter.showGenderScreen(6);
    }

    @OnClick (R.id.ll_zodiak_libra)
    void onLLZLibra() {
        mPresenter.showGenderScreen(7);
    }

    @OnClick (R.id.ll_zodiak_scorpio)
    void onLLZScorpio() {
        mPresenter.showGenderScreen(8);
    }

    @OnClick (R.id.ll_zodiak_sagittarius)
    void onLLZSagittarius() {
        mPresenter.showGenderScreen(9);
    }

    @OnClick (R.id.ll_zodiak_capricorn)
    void onLLZCapricorn() {
        mPresenter.showGenderScreen(10);
    }

    @OnClick (R.id.ll_zodiak_aquarius)
    void onLLZAquarius() {
        mPresenter.showGenderScreen(11);
    }

    @OnClick (R.id.ll_zodiak_fish)
    void onLLZFish() {
        mPresenter.showGenderScreen(12);
    }


    @OnClick (R.id.button_main_aries)
    void onButtonAries() {
        mPresenter.showGenderScreen(1);
    }

    @OnClick (R.id.button_main_taurus)
    void onButtonTaurus() {
        mPresenter.showGenderScreen(2);
    }

    @OnClick (R.id.button_main_twins)
    void onButtonTwins() {
        mPresenter.showGenderScreen(3);
    }

    @OnClick (R.id.button_main_cancer)
    void onButtonCancer() {
        mPresenter.showGenderScreen(4);
    }

    @OnClick (R.id.button_main_lion)
    void onButtonLion() {
        mPresenter.showGenderScreen(5);
    }

    @OnClick (R.id.button_main_virgo)
    void onButtonVirgo() {
        mPresenter.showGenderScreen(6);
    }

    @OnClick (R.id.button_main_libra)
    void onButtonLibra() {
        mPresenter.showGenderScreen(7);
    }

    @OnClick (R.id.button_main_scorpio)
    void onButtonScorpio() {
        mPresenter.showGenderScreen(8);
    }

    @OnClick (R.id.button_main_sagittarius)
    void onButtonSagittarius() {
        mPresenter.showGenderScreen(9);
    }

    @OnClick (R.id.button_main_capricorn)
    void onButtonCapricorn() {
        mPresenter.showGenderScreen(10);
    }

    @OnClick (R.id.button_main_aquarius)
    void onButtonAquarius() {
        mPresenter.showGenderScreen(11);
    }

    @OnClick (R.id.button_main_fish)
    void onButtonFish() {
        mPresenter.showGenderScreen(12);
    }


    @OnClick (R.id.button_main_aries_background)
    void onButtonAriesBackground() {
        mPresenter.showGenderScreen(1);
    }

    @OnClick (R.id.button_main_taurus_background)
    void onButtonTaurusBackground() {
        mPresenter.showGenderScreen(2);
    }

    @OnClick (R.id.button_main_twins_background)
    void onButtonTwinsBackground() {
        mPresenter.showGenderScreen(3);
    }

    @OnClick (R.id.button_main_cancer_background)
    void onButtonCancerBackground() {
        mPresenter.showGenderScreen(4);
    }

    @OnClick (R.id.button_main_lion_background)
    void onButtonLionBackground() {
        mPresenter.showGenderScreen(5);
    }

    @OnClick (R.id.button_main_virgo_background)
    void onButtonVirgoBackground() {
        mPresenter.showGenderScreen(6);
    }

    @OnClick (R.id.button_main_libra_background)
    void onButtonLibraBackground() {
        mPresenter.showGenderScreen(7);
    }

    @OnClick (R.id.button_main_scorpio_background)
    void onButtonScorpioBackground() {
        mPresenter.showGenderScreen(8);
    }

    @OnClick (R.id.button_main_sagittarius_background)
    void onButtonSagittariusBackground() {
        mPresenter.showGenderScreen(9);
    }

    @OnClick (R.id.button_main_capricorn_background)
    void onButtonCapricornBackground() {
        mPresenter.showGenderScreen(10);
    }

    @OnClick (R.id.button_main_aquarius_background)
    void onButtonAquariusBackground() {
        mPresenter.showGenderScreen(11);
    }

    @OnClick (R.id.button_main_fish_background)
    void onButtonFishBackground() {
        mPresenter.showGenderScreen(12);
    }


    @OnClick (R.id.textview_main_aries)
    void onTvAries() {
        mPresenter.showGenderScreen(1);
    }

    @OnClick (R.id.textview_main_taurus)
    void onTvTaurus() {
        mPresenter.showGenderScreen(2);
    }

    @OnClick (R.id.textview_main_twins)
    void onTvTwins() {
        mPresenter.showGenderScreen(3);
    }

    @OnClick (R.id.textview_main_cancer)
    void onTvCancer() {
        mPresenter.showGenderScreen(4);
    }

    @OnClick (R.id.textview_main_lion)
    void onTvLion() {
        mPresenter.showGenderScreen(5);
    }

    @OnClick (R.id.textview_main_virgo)
    void onTvVirgo() {
        mPresenter.showGenderScreen(6);
    }

    @OnClick (R.id.textview_main_libra)
    void onTvLibra() {
        mPresenter.showGenderScreen(7);
    }

    @OnClick (R.id.textview_main_scorpio)
    void onTvScorpio() {
        mPresenter.showGenderScreen(8);
    }

    @OnClick (R.id.textview_main_sagittarius)
    void onTvSagittarius() {
        mPresenter.showGenderScreen(9);
    }

    @OnClick (R.id.textview_main_capricorn)
    void onTvCapricorn() {
        mPresenter.showGenderScreen(10);
    }

    @OnClick (R.id.textview_main_aquarius)
    void onTvAquarius() {
        mPresenter.showGenderScreen(11);
    }

    @OnClick (R.id.textview_main_fish)
    void onTvFish() {
        mPresenter.showGenderScreen(12);
    }

    @OnClick (R.id.button_choose_zodiak_back)
    void onButtonChooseZodiakBackClick() {
        finish();
    }

    @Override
    public void showGenderScreen(int zodiakId) {
        ChooseGenderZodiakActivity.start(this, mPred, zodiakId);
    }
}
