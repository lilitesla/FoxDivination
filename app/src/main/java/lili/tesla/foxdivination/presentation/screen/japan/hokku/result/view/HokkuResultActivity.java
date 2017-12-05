package lili.tesla.foxdivination.presentation.screen.japan.hokku.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Hokku;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.japan.hokku.result.presenter.HokkuResultPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class HokkuResultActivity extends BaseActivity implements HokkuResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, HokkuResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private HokkuResultPresenter mPresenter;

    @BindView(R.id.textview_hokku_result)
    TextView mTvHokkuResult;

    @BindView(R.id.textview_hokku_result_author)
    TextView mTvHokkuAuthor;

    @BindView(R.id.textview_hokku_result_interp)
    TextView mTvHokkuInterp;

    @BindView(R.id.textview_hokku_result_description)
    TextView mTvHokkuDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hokku_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new HokkuResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvHokkuResult);
        Utils.setTypefaceBold(mTvHokkuInterp);
        Utils.setTypefaceLite(mTvHokkuAuthor);
        Utils.setTypefaceLite(mTvHokkuDescription);

        mPresenter.showResult();
    }

    @OnClick (R.id.button_hokku_result_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_hokku_result_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResult(Hokku hokku) {
        mTvHokkuResult.setText(hokku.getHokku());
        mTvHokkuAuthor.setText(hokku.getAuthor());
        mTvHokkuDescription.setText(hokku.getInterpretation());
    }
}
