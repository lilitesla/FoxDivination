package lili.tesla.foxdivination.presentation.screen.japan.mokuso.result.view;

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
import lili.tesla.foxdivination.data.Mokuso;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.japan.mokuso.result.presenter.MokusoResultPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MokusoResultActivity extends BaseActivity implements MokusoResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, MokusoResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MokusoResultPresenter mPresenter;
    private ImageView[] images;

    @BindView(R.id.textview_mokuso_result_description)
    TextView mTvDescription;

    @BindView(R.id.image_mokuso_result_line_1)
    ImageView mImage1;

    @BindView(R.id.image_mokuso_result_line_2)
    ImageView mImage2;

    @BindView(R.id.image_mokuso_result_line_3)
    ImageView mImage3;

    @BindView(R.id.image_mokuso_result_line_4)
    ImageView mImage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokuso_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MokusoResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceLite(mTvDescription);

        images = new ImageView[] {mImage1, mImage2, mImage3, mImage4};

        mPresenter.showResult();
    }

    @OnClick (R.id.button_mokuso_result_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_mokuso_result_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResult(Mokuso mokuso) {
        mTvDescription.setText(mokuso.getDescription());

        for (int i = 0; i < 4; i++) {
            images[i].setBackgroundResource(mokuso.getImages()[i]);
        }
    }
}
