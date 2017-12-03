package lili.tesla.foxdivination.presentation.screen.zodiak.mainZodiak.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Zodiac;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.mainZodiak.presenter.MainZodiakPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MainZodiakActivity extends BaseActivity implements MainZodiakView {

    public static final String EXTRA_KEY_ZODIAC = "KEY_ZODIAC";
    public static final String EXTRA_KEY_GENDER = "KEY_GENDER";
    public static final String EXTRA_KEY_PRED = "KEY_PRED";


    public static void start(Context context, int gender, int zodiakId, int pred) {
        Intent intent = new Intent(context, MainZodiakActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_ZODIAC, zodiakId);
        bundle.putInt( EXTRA_KEY_GENDER, gender);
        bundle.putInt( EXTRA_KEY_PRED, pred);

        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MainZodiakPresenter mPresenter;
    private int mZodiakId;
    private int mGender;
    private int mPred;

    @BindView (R.id.textview_main_zodiak_caption)
    TextView mTextViewMainZodiakCaption;

    @BindView (R.id.textview_main_zodiak_description)
    TextView mTextViewMainZodiakDescription;

    @BindView (R.id.image_button_main_zodiak)
    ImageView mImageMainZodiak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_zodiak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MainZodiakPresenter();
        mPresenter.setView(this);

        mZodiakId = getIntent().getIntExtra(EXTRA_KEY_ZODIAC, 0);
        mGender = getIntent().getIntExtra(EXTRA_KEY_GENDER, 0);
        mPred = getIntent().getIntExtra(EXTRA_KEY_PRED, 0);


        Utils.setTypefaceBold(mTextViewMainZodiakCaption);
        Utils.setTypefaceLite(mTextViewMainZodiakDescription);

        mPresenter.showResults(mGender, mZodiakId, mPred);
    }

    @OnClick (R.id.button_main_zodiak_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_main_zodiak_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResults(Zodiac zodiac, int pred) {

        String caption = new String();

        if (pred == 0) {
            caption = getResources().getString(R.string.main_zodiak) + "\n";
        } else {
            caption = getResources().getString(R.string.love_zodiak) + "\n";
        }

        if (zodiac.getGender() == 0) {
            caption += getResources().getString(R.string.gender_woman) + " - " + zodiac.getName();
        } else {
            caption += getResources().getString(R.string.gender_man) + " - " + zodiac.getName();
        }

        mTextViewMainZodiakCaption.setText(caption);
        mTextViewMainZodiakDescription.setText(zodiac.getDescription());
        mImageMainZodiak.setBackgroundResource(zodiac.getImage());
    }
}
