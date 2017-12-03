package lili.tesla.foxdivination.presentation.screen.africa.spider.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.africa.spider.result.presenter.SpiderResultPresenter;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class SpiderResultActivity extends BaseActivity implements SpiderResultView {

    public static final String[] EXTRA_KEY_WISHES = {"KEY_WISH_1", "KEY_WISH_2", "KEY_WISH_3", "KEY_WISH_4", "KEY_WISH_5"};

    public static void start(Context context, String[] wishes) {
        Intent intent = new Intent(context, SpiderResultActivity.class);
        Bundle bundle = new Bundle();

        for (int i = 0; i < 5; i++) {
            bundle.putString( EXTRA_KEY_WISHES[i], wishes[i]);
        }

        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private SpiderResultPresenter mPresenter;
    private String[] mWishes;
    private ImageView[] mImages;
    private ImageView[] mWebImages;
    private TextView[] mTvWishes;

    @BindView(R.id.textview_spider_result_caption)
    TextView mTvSpiderResultCaption;

    @BindView(R.id.textview_spider_result_description)
    TextView mTvSpiderResultDescription;

    @BindView(R.id.image_spider_result_web_1)    ImageView mImageSpiderWeb1;
    @BindView(R.id.image_spider_result_web_2)    ImageView mImageSpiderWeb2;
    @BindView(R.id.image_spider_result_web_3)    ImageView mImageSpiderWeb3;
    @BindView(R.id.image_spider_result_web_4)    ImageView mImageSpiderWeb4;
    @BindView(R.id.image_spider_result_web_5)    ImageView mImageSpiderWeb5;

    @BindView(R.id.textview_spider_result_1)    TextView mTvSpiderResult1;
    @BindView(R.id.textview_spider_result_2)    TextView mTvSpiderResult2;
    @BindView(R.id.textview_spider_result_3)    TextView mTvSpiderResult3;
    @BindView(R.id.textview_spider_result_4)    TextView mTvSpiderResult4;
    @BindView(R.id.textview_spider_result_5)    TextView mTvSpiderResult5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new SpiderResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvSpiderResultCaption);
        Utils.setTypefaceLite(mTvSpiderResultDescription);

        mWishes = new String[5];
        for (int i = 0; i < 5; i++) {
            mWishes[i] = getIntent().getStringExtra(EXTRA_KEY_WISHES[i]);
        }

        mWebImages = new ImageView[] { mImageSpiderWeb1, mImageSpiderWeb2, mImageSpiderWeb3, mImageSpiderWeb4, mImageSpiderWeb5 };
        mTvWishes = new TextView[] { mTvSpiderResult1, mTvSpiderResult2, mTvSpiderResult3, mTvSpiderResult4, mTvSpiderResult5 };

        mPresenter.showResult();

    }

    @OnClick (R.id.button_spider_result_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_spider_result_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showResult(int[] wishes) {

        String description = "";

        for (int i = 0; i < 5; i ++) {

            if (wishes[i] == 0) {
                mWebImages[i].setVisibility(View.INVISIBLE);
                mTvWishes[i].setVisibility(View.INVISIBLE);
            } else {
                mTvWishes[i].setVisibility(View.VISIBLE);

                description += (i + 1) + ". " + mWishes[i] + "\n\n";

                if (wishes[i] == 2) {
                    mWebImages[i].setVisibility(View.VISIBLE);
                } else {
                    mWebImages[i].setVisibility(View.INVISIBLE);
                }
            }
        }

        mTvSpiderResultDescription.setText(description);
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }


}
