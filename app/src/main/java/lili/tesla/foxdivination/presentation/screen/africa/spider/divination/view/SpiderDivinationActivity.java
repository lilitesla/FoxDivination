package lili.tesla.foxdivination.presentation.screen.africa.spider.divination.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.africa.spider.divination.presenter.SpiderDivinationPresenter;
import lili.tesla.foxdivination.presentation.screen.africa.spider.result.view.SpiderResultActivity;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class SpiderDivinationActivity extends BaseActivity implements SpiderDivinationView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, SpiderDivinationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private SpiderDivinationPresenter mPresenter;
    private EditText[] edits;

    @BindView(R.id.textview_spider_divination_manual)  TextView mTvManual;

    @BindView(R.id.edittext_spider_divination_wish_1)  EditText mEtWish1;
    @BindView(R.id.edittext_spider_divination_wish_2)  EditText mEtWish2;
    @BindView(R.id.edittext_spider_divination_wish_3)  EditText mEtWish3;
    @BindView(R.id.edittext_spider_divination_wish_4)  EditText mEtWish4;
    @BindView(R.id.edittext_spider_divination_wish_5)  EditText mEtWish5;

    @BindView(R.id.button_spider_divination_show_result)
    Button mButtonShowResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider_divination);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new SpiderDivinationPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvManual);

        edits = new EditText[]{mEtWish1, mEtWish2, mEtWish3, mEtWish4, mEtWish5};
    }

    @OnTextChanged (R.id.edittext_spider_divination_wish_1)
    void onEdit1Changed() {
        mPresenter.showButtonResult();
    }

    @OnTextChanged (R.id.edittext_spider_divination_wish_2)
    void onEdit2Changed() {
        mPresenter.showButtonResult();
    }

    @OnTextChanged (R.id.edittext_spider_divination_wish_3)
    void onEdit3Changed() {
        mPresenter.showButtonResult();
    }

    @OnTextChanged (R.id.edittext_spider_divination_wish_4)
    void onEdit4Changed() {
        mPresenter.showButtonResult();
    }

    @OnTextChanged (R.id.edittext_spider_divination_wish_5)
    void onEdit5Changed() {
        mPresenter.showButtonResult();
    }


    @OnClick (R.id.button_spider_divination_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_spider_divination_show_result)
    void onButtonShowResultClick() {
        mPresenter.showResult();
    }


    private boolean isAllWishFill() {
        boolean result = true;
        for (int i = 0; i < 5; i ++) {
            if (edits[i].getText().toString() .equals("")) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public void showButtonResult() {
        if (isAllWishFill()) {
            mButtonShowResult.setVisibility(View.VISIBLE);
        } else {
            mButtonShowResult.setVisibility(View.GONE);
        }
    }

    @Override
    public void showResult() {
        String[] wishes = new String[5];

        for (int i = 0; i < 5; i++) {
            wishes[i] = edits[i].getText().toString();
        }

        SpiderResultActivity.start(this, wishes);
        finish();
    }
}
