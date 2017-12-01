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

    @BindView(R.id.image_coffee_result_1)  ImageView mImageCoffeeResult1;
    @BindView(R.id.image_coffee_result_2)  ImageView mImageCoffeeResult2;
    @BindView(R.id.image_coffee_result_3)  ImageView mImageCoffeeResult3;
    @BindView(R.id.image_coffee_result_4)  ImageView mImageCoffeeResult4;
    @BindView(R.id.image_coffee_result_5)  ImageView mImageCoffeeResult5;
    @BindView(R.id.image_coffee_result_6)  ImageView mImageCoffeeResult6;
    @BindView(R.id.image_coffee_result_7)  ImageView mImageCoffeeResult7;
    @BindView(R.id.image_coffee_result_8)  ImageView mImageCoffeeResult8;
    @BindView(R.id.image_coffee_result_9)  ImageView mImageCoffeeResult9;
    @BindView(R.id.image_coffee_result_10)  ImageView mImageCoffeeResult10;
    @BindView(R.id.image_coffee_result_11)  ImageView mImageCoffeeResult11;
    @BindView(R.id.image_coffee_result_12)  ImageView mImageCoffeeResult12;
    @BindView(R.id.image_coffee_result_13)  ImageView mImageCoffeeResult13;
    @BindView(R.id.image_coffee_result_14)  ImageView mImageCoffeeResult14;
    @BindView(R.id.image_coffee_result_15)  ImageView mImageCoffeeResult15;
    @BindView(R.id.image_coffee_result_16)  ImageView mImageCoffeeResult16;

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
                mImageCoffeeResult1, mImageCoffeeResult2, mImageCoffeeResult3, mImageCoffeeResult4,
                mImageCoffeeResult5, mImageCoffeeResult6, mImageCoffeeResult7, mImageCoffeeResult8,
                mImageCoffeeResult9, mImageCoffeeResult10, mImageCoffeeResult11, mImageCoffeeResult12,
                mImageCoffeeResult13, mImageCoffeeResult14, mImageCoffeeResult15, mImageCoffeeResult16};

        mPresenter.showResults();

    }

    @OnClick (R.id.button_coffee_result_close)
    void onButtonCoffeeResultCloseClick() {
        mPresenter.showMainScreen();
    }

    @OnClick (R.id.button_coffee_result_back)
    void onButtonCoffeeResultBack() {
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
