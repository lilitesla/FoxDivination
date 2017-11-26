package lili.tesla.foxdivination.presentation.screen.china.domino.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.domino.main.presenter.DominoMainPresenter;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultOne.view.DominoResultOneActivity;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultSeven.view.DominoResultSevenActivity;
import lili.tesla.foxdivination.presentation.screen.china.domino.resultThree.view.DominoResultThreeActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class DominoMainActivity extends BaseActivity implements DominoMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, DominoMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private DominoMainPresenter mPresenter;

    @BindView(R.id.textview_domino_main_caption)
    TextView mTextViewDominoMainCaption;

    @BindView(R.id.textview_domino_main_description)
    TextView mTextViewDominoMainDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domino_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new DominoMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewDominoMainCaption);
        Utils.setTypefaceLite(mTextViewDominoMainDescription);
    }

    @OnClick (R.id.button_domino_main_back)
    void onButtonDominoMainBackClick() {
        finish();
    }

    @OnClick (R.id.button_domino_one)
    void onButtonDominoOneClick() {
        mPresenter.showDominoResultOneScreen();
    }

    @OnClick (R.id.button_domino_three)
    void onButtonDominoThreeClick() {
        mPresenter.showDominoResultThreeScreen();
    }

    @OnClick (R.id.button_domino_seven)
    void onButtonDominoSevenClick() {
        mPresenter.showDominoResultSevenScreen();
    }

    @Override
    public void showDominoResultOneScreen() {
        DominoResultOneActivity.start(this);
    }

    @Override
    public void showDominoResultThreeScreen() {
        DominoResultThreeActivity.start(this);
    }

    @Override
    public void showDominoResultSevenScreen() {
        DominoResultSevenActivity.start(this);
    }
}
