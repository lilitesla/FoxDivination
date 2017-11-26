package lili.tesla.foxdivination.presentation.screen.china.fateBook.main.view;

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
import lili.tesla.foxdivination.presentation.screen.base.BasePresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.presenter.FateBookDevinationPresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.view.FateBookDevinationActivity;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.main.presenter.FateBookMainPresenter;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.view.ChinaActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class FateBookMainActivity extends BaseActivity implements FateBookMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, FateBookMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private FateBookMainPresenter mPresenter;

    @BindView(R.id.textview_fatebook_main_caption)
    TextView mTextViewFateBookMainCaption;

    @BindView(R.id.textview_fatebook_main_description)
    TextView mTextViewFateBookMainDescription;

    @BindView(R.id.button_about_fatebook)
    TextView mButtonAboutFatebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fate_book_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new FateBookMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewFateBookMainCaption);
        Utils.setTypefaceLite(mTextViewFateBookMainDescription);
        Utils.setTypefaceLite(mButtonAboutFatebook);

    }

    @OnClick (R.id.button_fatebook_main_back)
    void onButtonFateBookMainBackClick() {
        mPresenter.showChinaScreen();
    }

    @OnClick (R.id.button_about_fatebook)
    void onButtonFateBookAbout() {
        mPresenter.changeStateDescription();
        mPresenter.changeDescriptionText();
    }

    @OnClick (R.id.button_fatebook_main_start)
    void onButtonFateBookMainStart() {
        mPresenter.showFateBookDivination();
    }

    @Override
    public void showChinaScreen() {
        ChinaActivity.start(this);
        finish();
    }

    @Override
    public void showFateBookDivination() {
        FateBookDevinationActivity.start(this);
    }

    @Override
    public void showAbout() {
        mButtonAboutFatebook.setText(R.string.description);
        mTextViewFateBookMainDescription.setText(R.string.fate_book_main_about);
    }

    @Override
    public void showDescription() {
        mButtonAboutFatebook.setText(R.string.about_devination);
        mTextViewFateBookMainDescription.setText(R.string.fate_book_main_description);
    }
}
