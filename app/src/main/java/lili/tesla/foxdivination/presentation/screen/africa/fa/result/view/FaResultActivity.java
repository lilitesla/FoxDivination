package lili.tesla.foxdivination.presentation.screen.africa.fa.result.view;

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
import lili.tesla.foxdivination.data.CoinsAfrica;
import lili.tesla.foxdivination.presentation.screen.africa.fa.result.presenter.FaResultPresenter;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class FaResultActivity extends BaseActivity implements FaResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, FaResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private FaResultPresenter mPresenter;
    private ImageView[] images;

    @BindView(R.id.textview_fa_result_caption)
    TextView mTvCaption;

    @BindView(R.id.textview_fa_result_description)
    TextView mTvDescription;

    @BindView(R.id.image_fa_result_1)
    ImageView mImageFa1;

    @BindView(R.id.image_fa_result_2)
    ImageView mImageFa2;

    @BindView(R.id.image_fa_result_3)
    ImageView mImageFa3;

    @BindView(R.id.image_fa_result_4)
    ImageView mImageFa4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new FaResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvCaption);
        Utils.setTypefaceLite(mTvDescription);

        images = new ImageView[]{mImageFa1, mImageFa2, mImageFa3, mImageFa4};

        mPresenter.showResults();
    }

    @OnClick (R.id.button_fa_result_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @OnClick (R.id.button_fa_result_back)
    void onBackClick() {
        finish();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResults(CoinsAfrica coins) {

        mTvCaption.setText(getResources().getString(R.string.reshka) + ": " + coins.getCountReshka() + ". " +
                getResources().getString(R.string.orel) + ": " + coins.getCountOrel() + ".");

        if (coins.getCountReshka() > coins.getCountOrel()) {
            mTvDescription.setText(getResources().getString(R.string.fa_yes));
        } else {
            if (coins.getCountReshka() < coins.getCountOrel()) {
                mTvDescription.setText(getResources().getString(R.string.fa_no));
            } else {
                mTvDescription.setText(getResources().getString(R.string.fa_unknown));
            }
        }

        for (int i = 0; i < images.length; i ++) {
            images[i].setBackgroundResource(coins.getCoins()[i].getImageId());
        }

    }
}
