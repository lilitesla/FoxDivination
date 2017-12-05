package lili.tesla.foxdivination.presentation.screen.china.mainChina.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.domino.main.view.DominoMainActivity;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.main.view.FateBookMainActivity;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.presenter.ChinaPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class ChinaActivity extends BaseActivity implements ChinaView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, ChinaActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ChinaPresenter mPresenter;

    @BindView(R.id.textview_china_caption)     TextView mTextViewChinaCaption;
    @BindView(R.id.textview_china_description) TextView mTextViewChinaDescription;
    @BindView(R.id.textview_fatebook)          TextView mTextViewFatebook;
    @BindView(R.id.textview_domino)            TextView mTextViewDomino;
    @BindView(R.id.textview_madjong)           TextView mTextViewMadjong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new ChinaPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewChinaCaption);
        Utils.setTypefaceLite(mTextViewChinaDescription);
        Utils.setTypefaceLite(mTextViewFatebook);
        Utils.setTypefaceLite(mTextViewDomino);
        Utils.setTypefaceLite(mTextViewMadjong);

    }

    @OnClick (R.id.main_ll_fatebook)
    void onLLFateBookClick() {
        mPresenter.showFateBookScreen();
    }

    @OnClick (R.id.button_fatebook)
    void onButtonFateBookClick() {
        mPresenter.showFateBookScreen();
    }

    @OnClick (R.id.textview_fatebook)
    void onTvFateBookClick() {
        mPresenter.showFateBookScreen();
    }


    @OnClick (R.id.main_ll_domino)
    void onLLDominoClick() { mPresenter.showDominoScreen(); }

    @OnClick (R.id.button_domino)
    void onButtonDominoClick() { mPresenter.showDominoScreen(); }

    @OnClick (R.id.textview_domino)
    void onTvDominoClick() { mPresenter.showDominoScreen(); }


    @OnClick (R.id.main_ll_madjong)
    void onLLMadjongClick() {
        mPresenter.showMadjongScreen();
    }

    @OnClick (R.id.button_madjong)
    void onButtonMadjongClick() {
        mPresenter.showMadjongScreen();
    }

    @OnClick (R.id.textview_madjong)
    void onTvMadjongClick() {
        mPresenter.showMadjongScreen();
    }


    @OnClick (R.id.button_china_back)
    void onBackClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
        finish();
    }

    @Override
    public void showFateBookScreen() {
        FateBookMainActivity.start(this);
    }

    @Override
    public void showDominoScreen() {
        DominoMainActivity.start(this);
    }

    @Override
    public void showMadjongScreen() {

    }
}
