package lili.tesla.foxdivination.presentation.screen.ekaterina.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Ekaterina;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.ekaterina.result.presenter.EkaterinaResultPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class EkaterinaResultActivity extends BaseActivity implements EkaterinaResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, EkaterinaResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private EkaterinaResultPresenter mPresenter;

    private TextView[] captions;
    private TextView[] descriptions;
    private ImageView[] images;

    @BindView(R.id.textview_ekaterina_result_caption_1)
    TextView mTextViewEkaterinaResultCaption1;

    @BindView(R.id.textview_ekaterina_result_description_1)
    TextView mTextViewEkaterinaResultDescription1;

    @BindView(R.id.textview_ekaterina_result_caption_2)
    TextView mTextViewEkaterinaResultCaption2;

    @BindView(R.id.textview_ekaterina_result_description_2)
    TextView mTextViewEkaterinaResultDescription2;

    @BindView(R.id.textview_ekaterina_result_caption_3)
    TextView mTextViewEkaterinaResultCaption3;

    @BindView(R.id.textview_ekaterina_result_description_3)
    TextView mTextViewEkaterinaResultDescription3;

    @BindView(R.id.image_ekaterina_result_1)
    ImageView mImageEkaterinaResult1;

    @BindView(R.id.image_ekaterina_result_2)
    ImageView mImageEkaterinaResult2;

    @BindView(R.id.image_ekaterina_result_3)
    ImageView mImageEkaterinaResult3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekaterina_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new EkaterinaResultPresenter();
        mPresenter.setView(this);

        captions = new TextView[] {
                mTextViewEkaterinaResultCaption1,
                mTextViewEkaterinaResultCaption2,
                mTextViewEkaterinaResultCaption3};

        descriptions = new TextView[] {
                mTextViewEkaterinaResultDescription1,
                mTextViewEkaterinaResultDescription2,
                mTextViewEkaterinaResultDescription3};

        images = new ImageView[] {
                mImageEkaterinaResult1,
                mImageEkaterinaResult2,
                mImageEkaterinaResult3};

        for (int i = 0; i < 3; i ++) {
            Utils.setTypefaceBold(captions[i]);
            Utils.setTypefaceLite(descriptions[i]);
        }

        mPresenter.showResults();
    }

    @OnClick (R.id.button_ekaterina_result_back)
    void onButtonEkaterinaResultBackClick() {
        finish();
    }

    @OnClick (R.id.button_ekaterina_result_close)
    void onButtonEkaterinaResultCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showResults(Ekaterina ekaterina) {
        for (int i = 0; i < 3; i ++) {
            captions[i].setText(ekaterina.getCaptions()[i]);
            descriptions[i].setText(ekaterina.getDescriptions()[i]);
            images[i].setBackgroundResource(ekaterina.getImageIdes()[i]);
        }
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }
}
