package lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.divination.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.divination.presenter.MoRosaryDivinationPresenter;
import lili.tesla.foxdivination.presentation.screen.tibet.mo_rosary.result.view.MoRosaryResultActivity;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MoRosaryDivinationActivity extends BaseActivity implements MoRosaryDivinationView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, MoRosaryDivinationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MoRosaryDivinationPresenter mPresenter;
    private int mCha;
    private RadioButton[] mRbCha;

    @BindView(R.id.textview_mo_rosary_divination_manual)
    TextView mTvManual;

    @BindView(R.id.radio_group_mo_rosary_divination)
    RadioGroup mRgCha;

    @BindView(R.id.rb_cha_1)
    RadioButton mRbCha1;

    @BindView(R.id.rb_cha_2)
    RadioButton mRbCha2;

    @BindView(R.id.rb_cha_3)
    RadioButton mRbCha3;

    @BindView(R.id.rb_cha_4)
    RadioButton mRbCha4;

    @BindView(R.id.rb_cha_5)
    RadioButton mRbCha5;

    @BindView(R.id.rb_cha_6)
    RadioButton mRbCha6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_rosary_divination);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MoRosaryDivinationPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvManual);
        mCha = 0;

        mRbCha = new RadioButton[] { mRbCha1, mRbCha2, mRbCha3, mRbCha4, mRbCha5, mRbCha6 };

        for (int i = 0; i < 6; i++) {
            mRbCha[i].setText(getResources().getStringArray(R.array.mo_rosary_cha)[i]);
        }

        RadioButton radioButton = (RadioButton) mRgCha.getChildAt(0);
        radioButton.setChecked(true);

        mRgCha.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mCha = mRgCha.indexOfChild((RadioButton)mRgCha.findViewById(checkedId));
            }
        });
    }

    @OnClick(R.id.button_mo_rosary_divination_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_mo_rosary_divination_start)
    void onStartClick() {
        mPresenter.showResultScreen();
    }

    @Override
    public void showResultScreen() {
        MoRosaryResultActivity.start(this, mCha);
        finish();
    }
}
