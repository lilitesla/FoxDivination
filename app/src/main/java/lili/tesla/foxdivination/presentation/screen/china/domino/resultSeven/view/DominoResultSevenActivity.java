package lili.tesla.foxdivination.presentation.screen.china.domino.resultSeven.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Domino;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultSeven.presenter.DominoResultSevenPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class DominoResultSevenActivity extends BaseActivity implements DominoResultSevenView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, DominoResultSevenActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private DominoResultSevenPresenter mPresenter;
    private TextView[] captions;
    private TextView[] descriptions;
    private ImageView[] images;

    @BindView(R.id.textview_domino_result_seven_caption_1)
    TextView mTextviewDominoResultSevenCaption1;

    @BindView(R.id.textview_domino_result_seven_description_1)
    TextView mTextviewDominoResultSevenDescription1;

    @BindView(R.id.textview_domino_result_seven_caption_2)
    TextView mTextviewDominoResultSevenCaption2;

    @BindView(R.id.textview_domino_result_seven_description_2)
    TextView mTextviewDominoResultSevenDescription2;

    @BindView(R.id.textview_domino_result_seven_caption_3)
    TextView mTextviewDominoResultSevenCaption3;

    @BindView(R.id.textview_domino_result_seven_description_3)
    TextView mTextviewDominoResultSevenDescription3;

    @BindView(R.id.textview_domino_result_seven_caption_4)
    TextView mTextviewDominoResultSevenCaption4;

    @BindView(R.id.textview_domino_result_seven_description_4)
    TextView mTextviewDominoResultSevenDescription4;

    @BindView(R.id.textview_domino_result_seven_caption_5)
    TextView mTextviewDominoResultSevenCaption5;

    @BindView(R.id.textview_domino_result_seven_description_5)
    TextView mTextviewDominoResultSevenDescription5;

    @BindView(R.id.textview_domino_result_seven_caption_6)
    TextView mTextviewDominoResultSevenCaption6;

    @BindView(R.id.textview_domino_result_seven_description_6)
    TextView mTextviewDominoResultSevenDescription6;

    @BindView(R.id.textview_domino_result_seven_caption_7)
    TextView mTextviewDominoResultSevenCaption7;

    @BindView(R.id.textview_domino_result_seven_description_7)
    TextView mTextviewDominoResultSevenDescription7;

    @BindView(R.id.image_domino_result_seven_1)
    ImageView mImageDominoResultSeven1;

    @BindView(R.id.image_domino_result_seven_2)
    ImageView mImageDominoResultSeven2;

    @BindView(R.id.image_domino_result_seven_3)
    ImageView mImageDominoResultSeven3;

    @BindView(R.id.image_domino_result_seven_4)
    ImageView mImageDominoResultSeven4;

    @BindView(R.id.image_domino_result_seven_5)
    ImageView mImageDominoResultSeven5;

    @BindView(R.id.image_domino_result_seven_6)
    ImageView mImageDominoResultSeven6;

    @BindView(R.id.image_domino_result_seven_7)
    ImageView mImageDominoResultSeven7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domino_result_seven);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new DominoResultSevenPresenter();
        mPresenter.setView(this);

        captions = new TextView[] {
                mTextviewDominoResultSevenCaption1,
                mTextviewDominoResultSevenCaption2,
                mTextviewDominoResultSevenCaption3,
                mTextviewDominoResultSevenCaption4,
                mTextviewDominoResultSevenCaption5,
                mTextviewDominoResultSevenCaption6,
                mTextviewDominoResultSevenCaption7};

        descriptions = new TextView[] {
                mTextviewDominoResultSevenDescription1,
                mTextviewDominoResultSevenDescription2,
                mTextviewDominoResultSevenDescription3,
                mTextviewDominoResultSevenDescription4,
                mTextviewDominoResultSevenDescription5,
                mTextviewDominoResultSevenDescription6,
                mTextviewDominoResultSevenDescription7};

        images = new ImageView[] {
                mImageDominoResultSeven1,
                mImageDominoResultSeven2,
                mImageDominoResultSeven3,
                mImageDominoResultSeven4,
                mImageDominoResultSeven5,
                mImageDominoResultSeven6,
                mImageDominoResultSeven7};

        for (int i = 0; i < 7; i ++) {
            Utils.setTypefaceBold(captions[i]);
            Utils.setTypefaceLite(descriptions[i]);
        }

        mPresenter.showResults();
    }

    @OnClick(R.id.button_domino_result_seven_back)
    void onButtonDominoResultSevenBackClick() {
        finish();
    }

    @OnClick (R.id.button_domino_result_seven_close)
    void onButtonDominoResultSevenCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showResults(Domino[] dominoes) {
        for (int i = 0; i < dominoes.length; i ++) {
            descriptions[i].setText(dominoes[i].getDescription());
            images[i].setBackgroundResource(dominoes[i].getImageId());
        }
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }
}
