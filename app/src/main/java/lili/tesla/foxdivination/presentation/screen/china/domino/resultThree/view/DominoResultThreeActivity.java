package lili.tesla.foxdivination.presentation.screen.china.domino.resultThree.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Domino;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultThree.presenter.DominoResultThreePresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class DominoResultThreeActivity extends BaseActivity implements DominoResultThreeView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, DominoResultThreeActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private DominoResultThreePresenter mPresenter;
    private TextView[] captions;
    private TextView[] descriptions;
    private ImageView[] images;

    @BindView(R.id.textview_domino_result_three_caption_1)
    TextView mTextviewDominoResultThreeCaption1;

    @BindView(R.id.textview_domino_result_three_description_1)
    TextView mTextviewDominoResultThreeDescription1;

    @BindView(R.id.textview_domino_result_three_caption_2)
    TextView mTextviewDominoResultThreeCaption2;

    @BindView(R.id.textview_domino_result_three_description_2)
    TextView mTextviewDominoResultThreeDescription2;

    @BindView(R.id.textview_domino_result_three_caption_3)
    TextView mTextviewDominoResultThreeCaption3;

    @BindView(R.id.textview_domino_result_three_description_3)
    TextView mTextviewDominoResultThreeDescription3;

    @BindView(R.id.image_domino_result_three_1)
    ImageView mImageDominoResultThree1;

    @BindView(R.id.image_domino_result_three_2)
    ImageView mImageDominoResultThree2;

    @BindView(R.id.image_domino_result_three_3)
    ImageView mImageDominoResultThree3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domino_result_three);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new DominoResultThreePresenter();
        mPresenter.setView(this);

        captions = new TextView[] {
                mTextviewDominoResultThreeCaption1,
                mTextviewDominoResultThreeCaption2,
                mTextviewDominoResultThreeCaption3};

        descriptions = new TextView[] {
                mTextviewDominoResultThreeDescription1,
                mTextviewDominoResultThreeDescription2,
                mTextviewDominoResultThreeDescription3};

        images = new ImageView[] {
                mImageDominoResultThree1,
                mImageDominoResultThree2,
                mImageDominoResultThree3};

        for (int i = 0; i < 3; i ++) {
            Utils.setTypefaceBold(captions[i]);
            Utils.setTypefaceLite(descriptions[i]);
        }

        mPresenter.showResults();
    }

    @OnClick(R.id.button_domino_result_three_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_domino_result_three_close)
    void onCloseClick() {
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
