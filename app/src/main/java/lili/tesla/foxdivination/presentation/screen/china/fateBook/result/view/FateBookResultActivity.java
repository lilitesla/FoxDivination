package lili.tesla.foxdivination.presentation.screen.china.fateBook.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Prediction;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.view.FateBookDevinationActivity;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.main.presenter.FateBookMainPresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.result.presenter.FateBookResultPresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.result.view.FateBookResultView;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class FateBookResultActivity extends BaseActivity implements FateBookResultView {

    public static final String EXTRA_KEY_INDEX = "KEY_ID";

    public static void start(Context context, String indexPrediction) {
        Intent intent = new Intent(context, FateBookResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString( EXTRA_KEY_INDEX, indexPrediction);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private FateBookResultPresenter mPresenter;
    private ArrayList<ImageView> lImage;

    @BindView(R.id.textview_fatebook_result_caption)
    TextView mTextViewFateBookResultCaption;

    @BindView(R.id.textview_fatebook_result_description)
    TextView mTextViewFateBookResultDescription;

    @BindView(R.id.image_fatebook_result_line_1)
    ImageView mImageFateBookResultLine1;

    @BindView(R.id.image_fatebook_result_line_2)
    ImageView mImageFateBookResultLine2;

    @BindView(R.id.image_fatebook_result_line_3)
    ImageView mImageFateBookResultLine3;

    @BindView(R.id.image_fatebook_result_line_4)
    ImageView mImageFateBookResultLine4;

    @BindView(R.id.image_fatebook_result_line_5)
    ImageView mImageFateBookResultLine5;

    @BindView(R.id.image_fatebook_result_line_6)
    ImageView mImageFateBookResultLine6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fate_book_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new FateBookResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewFateBookResultCaption);
        Utils.setTypefaceLite(mTextViewFateBookResultDescription);

        lImage = new ArrayList<>(6);

        lImage.add(mImageFateBookResultLine1);
        lImage.add(mImageFateBookResultLine2);
        lImage.add(mImageFateBookResultLine3);
        lImage.add(mImageFateBookResultLine4);
        lImage.add(mImageFateBookResultLine5);
        lImage.add(mImageFateBookResultLine6);

        mPresenter.showResults(getIntent().getStringExtra(EXTRA_KEY_INDEX));
    }

    @OnClick(R.id.button_fatebook_result_back)
    void onButtonFateBookResultBack() {
        finish();
    }

    @OnClick(R.id.button_fatebook_result_close)
    void onButtonFatebookResultClose() {
        MainActivity.start(this);
        finish();
    }

    @Override
    public void showResults(Prediction prediction) {

        mTextViewFateBookResultCaption.setText(prediction.getCaption());
        mTextViewFateBookResultDescription.setText(prediction.getDescription());

        for (int i = 0; i < 6; i ++) {
            if (prediction.getIndex_id().charAt(i) == '2') {
                lImage.get(i).setBackgroundResource(R.drawable.fatebook_solid_line);
            } else {
                lImage.get(i).setBackgroundResource(R.drawable.fatebook_dashed_line);
            }
        }

    }

}
