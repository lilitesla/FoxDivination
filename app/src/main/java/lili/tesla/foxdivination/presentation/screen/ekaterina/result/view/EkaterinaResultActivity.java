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

public class EkaterinaResultActivity extends BaseActivity implements EkaterinaResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, EkaterinaResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private EkaterinaResultPresenter mPresenter;

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

        mTextViewEkaterinaResultCaption1.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextViewEkaterinaResultDescription1.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));
        mTextViewEkaterinaResultCaption2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextViewEkaterinaResultDescription2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));
        mTextViewEkaterinaResultCaption3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextViewEkaterinaResultDescription3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));

        mPresenter.showResults();
    }

    @OnClick (R.id.button_ekaterina_result_back)
    void onButtonEkaterinaResultBackClick() {
        finish();
    }

    @OnClick (R.id.button_ekaterina_result_close)
    void onButtonEkaterinaResultCloseClick() {
        MainActivity.start(this);
        finish();
    }


    @Override
    public void showResults(Ekaterina ekaterina) {
        mTextViewEkaterinaResultCaption1.setText(ekaterina.getCaption1());
        mTextViewEkaterinaResultDescription1.setText(ekaterina.getDescription1());
        mTextViewEkaterinaResultCaption2.setText(ekaterina.getCaption2());
        mTextViewEkaterinaResultDescription2.setText(ekaterina.getDescription2());
        mTextViewEkaterinaResultCaption3.setText(ekaterina.getCaption3());
        mTextViewEkaterinaResultDescription3.setText(ekaterina.getDescription3());

        mImageEkaterinaResult1.setBackgroundResource(ekaterina.getImageId1());
        mImageEkaterinaResult2.setBackgroundResource(ekaterina.getImageId2());
        mImageEkaterinaResult3.setBackgroundResource(ekaterina.getImageId3());
    }
}
