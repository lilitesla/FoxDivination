package lili.tesla.foxdivination.presentation.screen.jewish.question.main.view;

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
import lili.tesla.foxdivination.presentation.screen.jewish.question.devination.view.JewishQuestionDevinationActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.question.main.presenter.JewishQuestionMainPresenter;
import lili.tesla.foxdivination.presentation.screen.jewish.question.result.view.JewishQuestionResultActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class JewishQuestionMainActivity extends BaseActivity implements JewishQuestionMainView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, JewishQuestionMainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private JewishQuestionMainPresenter mPresenter;

    @BindView(R.id.textview_jewish_question_main_caption)
    TextView mTextviewJewishQuestionMainCaption;

    @BindView(R.id.textview_jewish_question_main_description)
    TextView mTextviewJewishQuestionMainDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewish_question_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new JewishQuestionMainPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextviewJewishQuestionMainCaption);
        Utils.setTypefaceLite(mTextviewJewishQuestionMainDescription);
    }

    @OnClick (R.id.button_jewish_question_main_back)
    void onButtonJewishQuestionMainBackClick() {
        finish();
    }

    @OnClick (R.id.button_jewish_question_main_start)
    void onButtonJewishQuestionMainStart() {
        mPresenter.showJewishQuestionDevinationShow();
    }

    @Override
    public void showJewishQuestionDevinationShow() {
        JewishQuestionDevinationActivity.start(this);
    }
}
