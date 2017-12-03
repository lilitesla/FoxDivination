package lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
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
    private int mGender;
    private int mZodiakId;

    @BindView(R.id.textview_choose_gender_caption)
    TextView mTvChooseGenderCaption;

    @BindView(R.id.textview_choose_zodiak_caption)
    TextView mTvChooseZodiakCaption;

    @BindView(R.id.image_zodiak_choose)
    ImageView mImageZodiak;

    @BindView(R.id.textview_gender)
    TextView mTvGender;

    @BindView(R.id.textview_zodiac)
    TextView mTvZodiac;

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

        Utils.setTypefaceLite(mTvGender);
        Utils.setTypefaceLite(mTvZodiac);

        Utils.setTextSpannable(mTvGender);
        Utils.setTextSpannable(mTvZodiac);

        if (mPred == 0) {
            mImageZodiak.setBackgroundResource(R.drawable.zodiak_main);
        } else {
            mImageZodiak.setBackgroundResource(R.drawable.zodiak_love);
        }

        mGender = 0;
        mZodiakId = 0;

    }

    @OnClick (R.id.textview_gender)
    void onTvGenderClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChooseGenderZodiakActivity.this);
        builder.setTitle(R.string.choose_gender)
                .setPositiveButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        })
                .setSingleChoiceItems(R.array.gender, mGender,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                mGender = item;
                                mTvGender.setText(getResources().getStringArray(R.array.gender)[mGender]);
                                Utils.setTextSpannable(mTvGender);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @OnClick (R.id.textview_zodiac)
    void onTvZodiacClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChooseGenderZodiakActivity.this);
        builder.setTitle(R.string.choose_zodiak)
                .setPositiveButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        })
                .setSingleChoiceItems(R.array.zodiak, mZodiakId,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                mZodiakId = item;
                                mTvZodiac.setText(getResources().getStringArray(R.array.zodiak)[mZodiakId]);
                                Utils.setTextSpannable(mTvZodiac);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
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
        MainZodiakActivity.start(this, mGender, mZodiakId + 1, mPred);
        finish();
    }



}
