package lili.tesla.foxdivination.presentation.screen.china.domino.resultOne.view;

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
import lili.tesla.foxdivination.presentation.screen.china.domino.resultOne.presenter.DominoResultOnePresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class DominoResultOneActivity extends BaseActivity implements DominoResultOneView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, DominoResultOneActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private DominoResultOnePresenter mPresenter;

    @BindView(R.id.textview_domino_result_one_description)
    TextView mTextviewDominoResultOneDescription;

    @BindView(R.id.image_domino_result_one)
    ImageView mImageDominoResultOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domino_result_one);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new DominoResultOnePresenter();
        mPresenter.setView(this);

        Utils.setTypefaceLite(mTextviewDominoResultOneDescription);

        mPresenter.showResults();
    }

    @OnClick (R.id.button_domino_result_one_back)
    void onButtonDominoResultOneBackClick() {
        finish();
    }

    @OnClick (R.id.button_domino_result_one_close)
    void onButtonDominoResultOneCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showResults(Domino[] dominoes) {
        mTextviewDominoResultOneDescription.setText(dominoes[0].getDescription());
        mImageDominoResultOne.setBackgroundResource(dominoes[0].getImageId());
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }
}
