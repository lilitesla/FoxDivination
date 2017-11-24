package lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.devination.presenter.FateBookDevinationPresenter;
import lili.tesla.foxdivination.presentation.screen.china.fateBook.result.view.FateBookResultActivity;

public class FateBookDevinationActivity extends BaseActivity implements FateBookDevinationView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, FateBookDevinationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private FateBookDevinationPresenter mPresenter;

    @BindView(R.id.button_fatebook_divination_toss_a_coin)
    Button mButtonTossCoin;

    @BindView(R.id.button_fatebook_divination_show_result)
    Button mButtonShowResult;

    @BindView(R.id.textview_fatebook_divination_description)
    TextView mTextviewFatebookDivinationDescription;

    @BindView(R.id.textview_fatebook_in_yan)
    TextView mTextviewFatebookInYan;

    @BindView(R.id.image_fatebook_divination_1)
    ImageView mImageFateBookDivination1;

    @BindView(R.id.image_fatebook_divination_2)
    ImageView mImageFateBookDivination2;

    @BindView(R.id.image_fatebook_divination_3)
    ImageView mImageFateBookDivination3;

    @BindView(R.id.ll_fate_book_coins)
    LinearLayout mLlFateBookCoins;


    @BindView(R.id.image_fatebook_divination_line_1)
    ImageView mFateBookDivinationLine1;

    @BindView(R.id.image_fatebook_divination_line_2)
    ImageView mFateBookDivinationLine2;

    @BindView(R.id.image_fatebook_divination_line_3)
    ImageView mFateBookDivinationLine3;

    @BindView(R.id.image_fatebook_divination_line_4)
    ImageView mFateBookDivinationLine4;

    @BindView(R.id.image_fatebook_divination_line_5)
    ImageView mFateBookDivinationLine5;

    @BindView(R.id.image_fatebook_divination_line_6)
    ImageView mFateBookDivinationLine6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fate_book_devination);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new FateBookDevinationPresenter();
        mPresenter.setView(this);

        mTextviewFatebookInYan.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/seguisb.ttf"));
        mTextviewFatebookDivinationDescription.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/segoeuil.ttf"));

        mPresenter.showLines();
    }

    @OnClick (R.id.button_fatebook_divination_toss_a_coin)
    void onButtonTossACoinClick() {
        mPresenter.addLine();
    }

    @OnClick (R.id.button_fatebook_divination_show_result)
    void onButtonFateBookShowResult() {
        mPresenter.showResultScreen();
    }

    @OnClick (R.id.button_fatebook_divination_back)
    void onButtonFateBookDivinationBackClick() {
        finish();
    }

    @Override
    public void showResultScreen(int predId) {
        FateBookResultActivity.start(this, predId);
        finish();
    }

    @Override
    public void showLine(int lineNum, boolean isSolid) {
        switch (lineNum) {
            case 1: {
                mFateBookDivinationLine1.setVisibility(View.VISIBLE);
                if (isSolid) {
                    mFateBookDivinationLine1.setBackgroundResource(R.drawable.fatebook_solid_line);
                } else {
                    mFateBookDivinationLine1.setBackgroundResource(R.drawable.fatebook_dashed_line);
                }
                break;
            }
            case 2: {
                mFateBookDivinationLine2.setVisibility(View.VISIBLE);
                if (isSolid) {
                    mFateBookDivinationLine2.setBackgroundResource(R.drawable.fatebook_solid_line);
                } else {
                    mFateBookDivinationLine2.setBackgroundResource(R.drawable.fatebook_dashed_line);
                }
                break;
            }
            case 3: {
                mFateBookDivinationLine3.setVisibility(View.VISIBLE);
                if (isSolid) {
                    mFateBookDivinationLine3.setBackgroundResource(R.drawable.fatebook_solid_line);
                } else {
                    mFateBookDivinationLine3.setBackgroundResource(R.drawable.fatebook_dashed_line);
                }
                break;
            }
            case 4: {
                mFateBookDivinationLine4.setVisibility(View.VISIBLE);
                if (isSolid) {
                    mFateBookDivinationLine4.setBackgroundResource(R.drawable.fatebook_solid_line);
                } else {
                    mFateBookDivinationLine4.setBackgroundResource(R.drawable.fatebook_dashed_line);
                }
                break;
            }
            case 5: {
                mFateBookDivinationLine5.setVisibility(View.VISIBLE);
                if (isSolid) {
                    mFateBookDivinationLine5.setBackgroundResource(R.drawable.fatebook_solid_line);
                } else {
                    mFateBookDivinationLine5.setBackgroundResource(R.drawable.fatebook_dashed_line);
                }
                break;
            }
            case 6: {
                mFateBookDivinationLine6.setVisibility(View.VISIBLE);
                if (isSolid) {
                    mFateBookDivinationLine6.setBackgroundResource(R.drawable.fatebook_solid_line);
                } else {
                    mFateBookDivinationLine6.setBackgroundResource(R.drawable.fatebook_dashed_line);
                }
                break;
            }
        }
    }

    @Override
    public void showResultButton() {
        mButtonTossCoin.setVisibility(View.GONE);
        mButtonShowResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCoin(int coin1, int coin2, int coin3, boolean isYan) {

        mTextviewFatebookInYan.setVisibility(View.VISIBLE);
        mLlFateBookCoins.setVisibility(View.VISIBLE);

        if (coin1 == 2) {
            mImageFateBookDivination1.setBackgroundResource(R.drawable.fatebook_yan);
        } else {
            mImageFateBookDivination1.setBackgroundResource(R.drawable.fatebook_in);
        }

        if (coin2 == 2) {
            mImageFateBookDivination2.setBackgroundResource(R.drawable.fatebook_yan);
        } else {
            mImageFateBookDivination2.setBackgroundResource(R.drawable.fatebook_in);
        }

        if (coin3 == 2) {
            mImageFateBookDivination3.setBackgroundResource(R.drawable.fatebook_yan);
        } else {
            mImageFateBookDivination3.setBackgroundResource(R.drawable.fatebook_in);
        }

        if (isYan) {
            mTextviewFatebookInYan.setText(R.string.fate_book_divination_yan);

        } else {
            mTextviewFatebookInYan.setText(R.string.fate_book_divination_in);
        }
    }

    @Override
    public void changeManualText(int col) {
        mTextviewFatebookDivinationDescription.setText(getResources().getStringArray(R.array.fate_book_divination_manual)[col - 1]);
    }
}
