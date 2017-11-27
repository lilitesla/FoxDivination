package lili.tesla.foxdivination.presentation.screen.jewish.question.result.view;

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
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.question.result.presenter.JewishQuestionResultPresenter;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class JewishQuestionResultActivity extends BaseActivity implements JewishQuestionResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, JewishQuestionResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private JewishQuestionResultPresenter mPresenter;

    @BindView(R.id.textview_jewish_question_result_caption)
    TextView mTextviewJewishQuestionResultCaption;

    @BindView(R.id.textview_jewish_question_result_description)
    TextView mTextviewJewishQuestionResultDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewish_question_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new JewishQuestionResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextviewJewishQuestionResultCaption);
        Utils.setTypefaceLite(mTextviewJewishQuestionResultDescription);


    }

    @OnClick (R.id.button_jewish_question_result_back)
    void onButtonJewishQuestionResultBack() {
        finish();
    }

    @OnClick (R.id.button_jewish_question_result_close)
    void onButtonJewishQuestionResultClose() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }
}
