package lili.tesla.foxdivination.presentation.screen.africa.coffee.result.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.data.Coffee;
import lili.tesla.foxdivination.presentation.screen.africa.coffee.result.presenter.CoffeeResultPresenter;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class CoffeeResultActivity extends BaseActivity implements CoffeeResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, CoffeeResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private CoffeeResultPresenter mPresenter;
    private ImageView[] images;

    @BindView(R.id.textview_coffee_result_caption)
    TextView mTextViewCoffeeResultCaption;

    @BindView(R.id.textview_coffee_result_description)
    TextView mTextViewCoffeeResultDescription;

    @BindView(R.id.image_coffee_result_1)  ImageView mImageResult1;
    @BindView(R.id.image_coffee_result_2)  ImageView mImageResult2;
    @BindView(R.id.image_coffee_result_3)  ImageView mImageResult3;
    @BindView(R.id.image_coffee_result_4)  ImageView mImageResult4;
    @BindView(R.id.image_coffee_result_5)  ImageView mImageResult5;
    @BindView(R.id.image_coffee_result_6)  ImageView mImageResult6;
    @BindView(R.id.image_coffee_result_7)  ImageView mImageResult7;
    @BindView(R.id.image_coffee_result_8)  ImageView mImageResult8;
    @BindView(R.id.image_coffee_result_9)  ImageView mImageResult9;
    @BindView(R.id.image_coffee_result_10)  ImageView mImageResult10;
    @BindView(R.id.image_coffee_result_11)  ImageView mImageResult11;
    @BindView(R.id.image_coffee_result_12)  ImageView mImageResult12;
    @BindView(R.id.image_coffee_result_13)  ImageView mImageResult13;
    @BindView(R.id.image_coffee_result_14)  ImageView mImageResult14;
    @BindView(R.id.image_coffee_result_15)  ImageView mImageResult15;
    @BindView(R.id.image_coffee_result_16)  ImageView mImageResult16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new CoffeeResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTextViewCoffeeResultCaption);
        Utils.setTypefaceLite(mTextViewCoffeeResultDescription);

        images = new ImageView[] {
                mImageResult1, mImageResult2, mImageResult3, mImageResult4,
                mImageResult5, mImageResult6, mImageResult7, mImageResult8,
                mImageResult9, mImageResult10, mImageResult11, mImageResult12,
                mImageResult13, mImageResult14, mImageResult15, mImageResult16};

        mPresenter.showResults();

    }

    @OnClick (R.id.button_coffee_result_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @OnClick (R.id.button_coffee_result_back)
    void onBackClick() {
        finish();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResults(Coffee coffee) {

        mTextViewCoffeeResultCaption.setText(coffee.getId() + ". " + coffee.getCaption());
        mTextViewCoffeeResultDescription.setText(coffee.getDescription());

        for (int i = 0; i < 16; i++) {
            images[i].setBackgroundResource(coffee.getImages()[i]);
        }

    }
}
