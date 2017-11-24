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
import lili.tesla.foxdivination.presentation.screen.china.fateBook.main.view.FateBookMainActivity;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.presenter.ChinaPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new ChinaPresenter();
        mPresenter.setView(this);

        mTextViewChinaCaption.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextViewChinaDescription.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));

    }

    @OnClick (R.id.button_fate_book)
    void onButtonFateBookClick() {
        mPresenter.showFateBookScreen();
    }

    @OnClick (R.id.button_china_back)
    void onButtonChinaBackClick() {
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
}
