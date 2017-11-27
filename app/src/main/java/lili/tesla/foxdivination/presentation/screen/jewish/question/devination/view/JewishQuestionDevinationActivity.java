package lili.tesla.foxdivination.presentation.screen.jewish.question.devination.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.jewish.question.devination.presenter.JewishQuestionDevinationPresenter;

public class JewishQuestionDevinationActivity extends BaseActivity implements JewishQuestionDevinationView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, JewishQuestionDevinationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private JewishQuestionDevinationPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewish_question_devination);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new JewishQuestionDevinationPresenter();
        mPresenter.setView(this);


    }
}
