package lili.tesla.foxdivination.presentation.screen.zodiak.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.chooseGender.view.ChooseGenderZodiakActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.compatibility.main.view.MainCompatibilityZodiakActivity;
import lili.tesla.foxdivination.presentation.screen.zodiak.main.presenter.ZodiakPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class ZodiakActivity extends BaseActivity implements ZodiakView{

    public static void start(Context context ) {
        Intent intent = new Intent(context, ZodiakActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ZodiakPresenter mPresenter;

    @BindView(R.id.textview_zodiak_caption)
    TextView mTextViewZodiakCaption;

    @BindView(R.id.textview_zodiak_description)
    TextView mTextViewZodiakDescription;

    @BindView(R.id.textview_main_zodiak)
    TextView mTextViewMainZodiak;

    @BindView(R.id.textview_zodiak_love)
    TextView mTextViewLoveZodiak;

    @BindView(R.id.textview_zodiak_compatibility)
    TextView mTextViewCompZodiak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiak);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new ZodiakPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewZodiakCaption);
        Utils.setTypefaceLite(mTextViewZodiakDescription);
        Utils.setTypefaceLite(mTextViewMainZodiak);
        Utils.setTypefaceLite(mTextViewLoveZodiak);
        Utils.setTypefaceLite(mTextViewCompZodiak);

    }

    @OnClick (R.id.button_zodiak_back)
    void onBackClick() {
        finish();
    }


    @OnClick (R.id.ll_zodiak_main)
    void onLlZodiakMainClick() {
        mPresenter.showMainZodiakScreen();
    }

    @OnClick (R.id.button_main_zodiak)
    void onButtonZodiakMainClick() {
        mPresenter.showMainZodiakScreen();
    }

    @OnClick (R.id.textview_main_zodiak)
    void onTextViewZodiakMainClick() {
        mPresenter.showMainZodiakScreen();
    }


    @OnClick (R.id.ll_zodiak_love)
    void onLlZodiakLoveClick() {
        mPresenter.showLoveZodiakScreen();
    }

    @OnClick (R.id.button_zodiak_love)
    void onButtonZodiakLoveClick() {
        mPresenter.showLoveZodiakScreen();
    }

    @OnClick (R.id.textview_zodiak_love)
    void onTextViewZodiakLoveClick() {
        mPresenter.showLoveZodiakScreen();
    }


    @OnClick (R.id.ll_zodiak_compatibility)
    void onLlZodiakCompatibilityClick() {
        mPresenter.showCompatibilityZodiakScreen();
    }

    @OnClick (R.id.button_zodiak_compatibility)
    void onButtonZodiakCompatibilityClick() {
        mPresenter.showCompatibilityZodiakScreen();
    }

    @OnClick (R.id.textview_zodiak_compatibility)
    void onTextViewZodiakCompatibilityClick() {
        mPresenter.showCompatibilityZodiakScreen();
    }


    @Override
    public void showMainZodiakScreen() {
        ChooseGenderZodiakActivity.start(this, 0);
    }

    @Override
    public void showLoveZodiakScreen() {
        ChooseGenderZodiakActivity.start(this, 1);
    }

    @Override
    public void showCompatibilityZodiakScreen() {
        MainCompatibilityZodiakActivity.start(this);
    }
}
