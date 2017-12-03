package lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.presenter.ChooseGenderZodiakPresenter;
import lili.tesla.foxdivination.presentation.screen.zodiak.mainZodiak.view.MainZodiakActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class ChooseGenderZodiakActivity extends BaseActivity implements ChooseGenderZodiakView {

    public static final String EXTRA_KEY_PRED = "KEY_PRED";

    public static void start(Context context, int pred) {
        Intent intent = new Intent(context, ChooseGenderZodiakActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_PRED, pred);

        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ChooseGenderZodiakPresenter mPresenter;
    private int mPred;

    @BindView(R.id.textview_choose_gender_caption)
    TextView mTvChooseGenderCaption;

    @BindView(R.id.textview_choose_zodiak_caption)
    TextView mTvChooseZodiakCaption;

    @BindView(R.id.spinner_zodiak_gender)
    Spinner mSpinnerGender;

    @BindView(R.id.spinner_zodiak)
    Spinner mSpinnerZodiak;

    @BindView(R.id.image_zodiak_choose)
    ImageView mImageZodiak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gender_zodiak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new ChooseGenderZodiakPresenter();
        mPresenter.setView(this);

        mPred = getIntent().getIntExtra(EXTRA_KEY_PRED, 0);

        Utils.setTypefaceBold(mTvChooseGenderCaption);
        Utils.setTypefaceBold(mTvChooseZodiakCaption);

        if (mPred == 0) {
            mImageZodiak.setBackgroundResource(R.drawable.zodiak_main);
        } else {
            mImageZodiak.setBackgroundResource(R.drawable.zodiak_love);
        }

    }

    @OnClick(R.id.button_choose_zodiak_gender_back)
    void onBackClick() {
        finish();
    }

    @OnClick(R.id.button_choose_zodiak_gender_start)
    void onStartClick() {
        mPresenter.showZodiakResult();
    }

    @Override
    public void showMainZodiakScreen() {
        int gender = mSpinnerGender.getSelectedItemPosition();
        int zodiakId = mSpinnerZodiak.getSelectedItemPosition() + 1;
        MainZodiakActivity.start(this, gender, zodiakId, mPred);
        finish();
    }

}
