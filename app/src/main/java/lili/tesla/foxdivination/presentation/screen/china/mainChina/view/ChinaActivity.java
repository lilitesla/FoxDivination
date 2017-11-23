package lili.tesla.foxdivination.presentation.screen.china.mainChina.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.mainChina.presenter.ChinaPresenter;

public class ChinaActivity extends BaseActivity implements ChinaView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, ChinaActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ChinaPresenter mPresenter;

    @BindView(R.id.textview_china_caption)     TextView mTextViewChinaCaption;
    @BindView(R.id.textview_china_description) TextView mTextViewChinaDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china);
        ButterKnife.bind(this);
        mPresenter = new ChinaPresenter();
        mPresenter.setView(this);

        mTextViewChinaCaption.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextViewChinaDescription.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));


    }
}
