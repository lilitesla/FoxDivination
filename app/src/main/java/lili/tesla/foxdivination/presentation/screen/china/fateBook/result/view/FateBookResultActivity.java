package lili.tesla.foxdivination.presentation.screen.china.fateBook.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Prediction;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.view.FateBookDevinationActivity;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.main.presenter.FateBookMainPresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.result.presenter.FateBookResultPresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.result.view.FateBookResultView;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;

public class FateBookResultActivity extends BaseActivity implements FateBookResultView {

    public static final String EXTRA_KEY_ID = "KEY_ID";

    public static void start(Context context, int idPrediction) {
        Intent intent = new Intent(context, FateBookResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt( EXTRA_KEY_ID, idPrediction);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private FateBookResultPresenter mPresenter;

    @BindView(R.id.textview_fate_book_result_caption)
    TextView mTextViewFateBookResultCaption;

    @BindView(R.id.textview_fate_book_result_description)
    TextView mTextViewFateBookResultDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fate_book_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new FateBookResultPresenter();
        mPresenter.setView(this);
        mPresenter.showResults(getIntent().getIntExtra(EXTRA_KEY_ID, 0));

        mTextViewFateBookResultCaption.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextViewFateBookResultDescription.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));

    }

    @OnClick(R.id.button_fatebook_result_back)
    void onButtonFateBookResultBack() {
        finish();
    }

    @OnClick(R.id.button_fatebook_result_close)
    void onButtonFatebookResultClose() {
        MainActivity.start(this);
        finish();
    }

    @Override
    public void showResults(Prediction prediction) {

        mTextViewFateBookResultCaption.setText(prediction.getCaption());
        mTextViewFateBookResultDescription.setText(prediction.getDescription());

        // TODO: 25.11.2017 отрисовка гексаграммы
    }
}
