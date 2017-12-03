package lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.ZodiacCompatibility;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.result.presenter.ResultCompatibilityZodiakPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class ResultCompatibilityZodiakActivity extends BaseActivity implements ResultCompatibilityZodiakView {

    public static final String EXTRA_KEY_MAN_ZODIAC = "KEY_MAN_ZODIAC";
    public static final String EXTRA_KEY_WOMAN_ZODIAC = "KEY_WOMAN_ZODIAC";

    public static void start(Context context, int manZodiacId, int womanZodiacId) {
        Intent intent = new Intent(context, ResultCompatibilityZodiakActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_MAN_ZODIAC, manZodiacId);
        bundle.putInt( EXTRA_KEY_WOMAN_ZODIAC, womanZodiacId);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ResultCompatibilityZodiakPresenter mPresenter;
    private int mManZodiacId;
    private int mWomanZodiacId;

    @BindView(R.id.textview_compatibility_zodiak_caption)
    TextView mTextviewCaption;

    @BindView(R.id.textview_compatibility_zodiak_description)
    TextView mTextviewDescription;

    @BindView(R.id.textview_compatibility_zodiak_caption_1)
    TextView mTextviewCaption1;

    @BindView(R.id.textview_compatibility_zodiak_description_1)
    TextView mTextviewDescription1;

    @BindView(R.id.textview_compatibility_zodiak_caption_2)
    TextView mTextviewCaption2;

    @BindView(R.id.textview_compatibility_zodiak_description_2)
    TextView mTextviewDescription2;

    @BindView(R.id.textview_compatibility_zodiak_caption_3)
    TextView mTextviewCaption3;

    @BindView(R.id.textview_compatibility_zodiak_description_3)
    TextView mTextviewDescription3;

    @BindView(R.id.textview_compatibility_zodiak_caption_4)
    TextView mTextviewCaption4;

    @BindView(R.id.textview_compatibility_zodiak_description_4)
    TextView mTextviewDescription4;

    @BindView(R.id.textview_compatibility_zodiak_caption_5)
    TextView mTextviewCaption5;

    @BindView(R.id.textview_compatibility_zodiak_description_5)
    TextView mTextviewDescription5;


    @BindView(R.id.image_compatibility_zodiak_man)
    ImageView mImageMan;

    @BindView(R.id.image_compatibility_zodiak_woman)
    ImageView mImageWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_compatibility_zodiak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new ResultCompatibilityZodiakPresenter();
        mPresenter.setView(this);

        mManZodiacId = getIntent().getIntExtra(EXTRA_KEY_MAN_ZODIAC, 0);
        mWomanZodiacId = getIntent().getIntExtra(EXTRA_KEY_WOMAN_ZODIAC, 0);

        Utils.setTypefaceBold(mTextviewCaption);
        Utils.setTypefaceLite(mTextviewDescription);

        Utils.setTypefaceBold(mTextviewCaption1);
        Utils.setTypefaceLite(mTextviewDescription1);

        Utils.setTypefaceBold(mTextviewCaption2);
        Utils.setTypefaceLite(mTextviewDescription2);

        Utils.setTypefaceBold(mTextviewCaption3);
        Utils.setTypefaceLite(mTextviewDescription3);

        Utils.setTypefaceBold(mTextviewCaption4);
        Utils.setTypefaceLite(mTextviewDescription4);

        Utils.setTypefaceBold(mTextviewCaption5);
        Utils.setTypefaceLite(mTextviewDescription5);

        mPresenter.showResults(mManZodiacId, mWomanZodiacId);
    }

    @OnClick (R.id.button_compatibility_zodiak_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_compatibility_zodiak_close)
    void onCloseClick() { mPresenter.showMainActivity(); }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResults(ZodiacCompatibility zodiacCompatibility) {

        mImageMan.setBackgroundResource(zodiacCompatibility.getManImageId());
        mImageWoman.setBackgroundResource(zodiacCompatibility.getWomanImageId());

        mTextviewCaption.setText(getResources().getString(R.string.gender_man) + " " + zodiacCompatibility.getManZodiac() + "\n" +
                getResources().getString(R.string.gender_woman) + " " + zodiacCompatibility.getWomanZodiac());

        mTextviewDescription.setText(getResources().getString(R.string.compatibility) + ": " + zodiacCompatibility.getPercent() + "%");

        mTextviewCaption1.setText(zodiacCompatibility.getCaption1());
        mTextviewDescription1.setText(zodiacCompatibility.getDescription1());

        mTextviewCaption2.setText(zodiacCompatibility.getCaption2());
        mTextviewDescription2.setText(zodiacCompatibility.getDescription2());

        mTextviewCaption3.setText(zodiacCompatibility.getCaption3());
        mTextviewDescription3.setText(zodiacCompatibility.getDescription3());

        mTextviewCaption4.setText(zodiacCompatibility.getCaption4());
        mTextviewDescription4.setText(zodiacCompatibility.getDescription4());

        mTextviewCaption5.setText(zodiacCompatibility.getCaption5());
        mTextviewDescription5.setText(zodiacCompatibility.getDescription5());

    }


}
