package lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.main.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    private int mManZodiacId;
    private int mWomanZodiacId;

    @BindView(R.id.textview_zodiak_compatibility_man)
    TextView mTextviewMan;

    @BindView(R.id.textview_zodiak_compatibility_woman)
    TextView mTextviewWoman;

    @BindView(R.id.textview_zodiac_man)
    TextView mTvMan;

    @BindView(R.id.textview_zodiac_woman)
    TextView mTvWoman;

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
        Utils.setTypefaceLite(mTvMan);
        Utils.setTypefaceLite(mTvWoman);

        Utils.setTextSpannable(mTvMan);
        Utils.setTextSpannable(mTvWoman);

        mManZodiacId = 0;
        mWomanZodiacId = 0;

    }

    @OnClick (R.id.button_zodiak_compatibility_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_zodiak_compatibility_start)
    void onButtonStartClick() {
        mPresenter.showResults();
    }

    @OnClick (R.id.textview_zodiac_man)
    void onTvZodiacManClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainCompatibilityZodiakActivity.this);
        builder.setTitle(R.string.choose_zodiak)
                .setPositiveButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        })
                .setSingleChoiceItems(R.array.zodiak, mManZodiacId,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                mManZodiacId = item;
                                mTvMan.setText(getResources().getStringArray(R.array.zodiak)[mManZodiacId]);
                                Utils.setTextSpannable(mTvMan);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @OnClick (R.id.textview_zodiac_woman)
    void onTvZodiacWomanClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainCompatibilityZodiakActivity.this);
        builder.setTitle(R.string.choose_zodiak)
                .setPositiveButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        })
                .setSingleChoiceItems(R.array.zodiak, mWomanZodiacId,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                mWomanZodiacId = item;
                                mTvWoman.setText(getResources().getStringArray(R.array.zodiak)[mWomanZodiacId]);
                                Utils.setTextSpannable(mTvWoman);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void showResults() {
        ResultCompatibilityZodiakActivity.start(this, mManZodiacId + 1, mWomanZodiacId + 1);
        finish();
    }
}
