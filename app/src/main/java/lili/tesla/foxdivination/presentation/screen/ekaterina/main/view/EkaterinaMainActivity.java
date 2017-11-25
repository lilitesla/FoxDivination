package lili.tesla.foxdivination.presentation.screen.ekaterina.main.view;

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
import lili.tesla.foxdivination.presentation.screen.ekaterina.main.presenter.EkaterinaMainPresenter;
import lili.tesla.foxdivination.presentation.screen.ekaterina.result.view.EkaterinaResultActivity;

public class EkaterinaMainActivity extends BaseActivity implements EkaterinaMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, EkaterinaMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private EkaterinaMainPresenter mPresenter;

    @BindView(R.id.textview_ekaterina_main_caption)
    TextView mTextViewEkaterinaMainCaption;

    @BindView(R.id.textview_ekaterina_main_description)
    TextView mTextViewEkaterinaMainDescription;

    @BindView(R.id.button_about_ekaterina)
    TextView mButtonAboutEkaterina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekaterina_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new EkaterinaMainPresenter();
        mPresenter.setView(this);

        mTextViewEkaterinaMainCaption.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextViewEkaterinaMainDescription.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));
        mButtonAboutEkaterina.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));

    }

    @OnClick (R.id.button_ekaterina_main_back)
    void onButtonEkaterinaMainBackClick() {
        finish();
    }

    @OnClick (R.id.button_about_ekaterina)
    void onButtonAboutEkaterinaClick() {
        mPresenter.changeStateDescription();
        mPresenter.changeDescriptionText();
    }

    @OnClick (R.id.button_ekaterina_main_start)
    void onButtonEkaterinaMainStartClick() {
        EkaterinaResultActivity.start(this);
    }


    @Override
    public void showAbout() {
        mButtonAboutEkaterina.setText(R.string.description);
        mTextViewEkaterinaMainDescription.setText(R.string.ekaterina_about);
    }

    @Override
    public void showDescription() {
        mButtonAboutEkaterina.setText(R.string.about_devination);
        mTextViewEkaterinaMainDescription.setText(R.string.ekaterina_description);

    }

    @Override
    public void showEkaterinaResult() {
        EkaterinaResultActivity.start(this);
    }
}
