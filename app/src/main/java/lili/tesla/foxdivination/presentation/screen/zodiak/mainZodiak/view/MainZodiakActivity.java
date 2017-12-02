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


    public static void start(Context context, int gender, int zodiakId) {
        Intent intent = new Intent(context, MainZodiakActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_ZODIAC, zodiakId);
        bundle.putInt( EXTRA_KEY_GENDER, gender);

        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MainZodiakPresenter mPresenter;
    private int mZodiakId;
    private int mGender;

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

        Utils.setTypefaceBold(mTextViewMainZodiakCaption);
        Utils.setTypefaceLite(mTextViewMainZodiakDescription);

        mPresenter.showResults(mGender, mZodiakId);
    }

    @OnClick (R.id.button_main_zodiak_back)
    void onButtonBackClick() {
        finish();
    }

    @OnClick (R.id.button_main_zodiak_close)
    void onClose() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResults(Zodiac zodiac) {
        if (zodiac.getGender() == 0) {
            mTextViewMainZodiakCaption.setText(getResources().getString(R.string.gender_woman) + zodiac.getName());
        } else {
            mTextViewMainZodiakCaption.setText(getResources().getString(R.string.gender_man) + zodiac.getName());
        }

        mTextViewMainZodiakDescription.setText(zodiac.getDescription());
        mImageMainZodiak.setBackgroundResource(zodiac.getImage());
    }
}
