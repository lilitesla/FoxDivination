package lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.result.view;

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
import lili.tesla.foxdivination.data.Mo;
import lili.tesla.foxdivination.data.MoRosary;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.screen.tibet.mo.result.view.MoResultView;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.result.presenter.MoRosaryResultPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MoRosaryResultActivity extends BaseActivity implements MoRosaryResultView {

    public static final String EXTRA_KEY_INDEX = "KEY_INDEX";

    public static void start(Context context, int indexPrediction) {
        Intent intent = new Intent(context, MoRosaryResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_KEY_INDEX, indexPrediction);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MoRosaryResultPresenter mPresenter;
    private int mIndexPred;
    private ImageView[] images;

    @BindView(R.id.textview_mo_rosary_result_caption)
    TextView mTvCaption;

    @BindView(R.id.textview_mo_rosary_result_description)
    TextView mTvDescription;

    @BindView(R.id.image_mo_rosary_result_1)
    ImageView mImage1;

    @BindView(R.id.image_mo_rosary_result_2)
    ImageView mImage2;

    @BindView(R.id.image_mo_rosary_result_3)
    ImageView mImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_rosary_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MoRosaryResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvCaption);
        Utils.setTypefaceLite(mTvDescription);

        images = new ImageView[] {mImage1, mImage2, mImage3};

        mIndexPred = getIntent().getIntExtra(EXTRA_KEY_INDEX, 0);
        mPresenter.showResults();
    }

    @OnClick(R.id.button_mo_rosary_result_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_mo_rosary_result_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResult(MoRosary moRosary) {
        mTvCaption.setText(getResources().getStringArray(R.array.mo_rosary_cha)[mIndexPred]);
        mTvDescription.setText(moRosary.getAnswers()[mIndexPred]);

        // TODO: 08.12.2017 заменить картинки
    }

}
