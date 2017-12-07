package lili.tesla.foxdivination.presentation.screen.tibet.mo.result.view;

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
import lili.tesla.foxdivination.data.Mo;
import lili.tesla.foxdivination.presentation.screen.base.BaseActivity;
import lili.tesla.foxdivination.presentation.screen.main.view.MainActivity;
import lili.tesla.foxdivination.presentation.screen.tibet.mo.result.presenter.MoResultPresenter;
import lili.tesla.foxdivination.presentation.util.Utils;

public class MoResultActivity extends BaseActivity implements MoResultView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, MoResultActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private MoResultPresenter mPresenter;

    @BindView(R.id.textview_mo_result_1)
    TextView mTvMoResult1;

    @BindView(R.id.textview_mo_result_2)
    TextView mTvMoResult2;

    @BindView(R.id.textview_mo_result_caption)
    TextView mTvMoCaption;

    @BindView(R.id.textview_mo_result_description)
    TextView mTvMoDescription;

    @BindView(R.id.textview_mo_result_tasks_caption)
    TextView mTvMoTasksCaption;

    @BindView(R.id.textview_mo_result_tasks_description)
    TextView mTvMoTasksDescription;

    @BindView(R.id.textview_mo_result_family_caption)
    TextView mTvMoFamilyCaption;

    @BindView(R.id.textview_mo_result_family_description)
    TextView mTvMoFamilyDescription;

    @BindView(R.id.textview_mo_result_things_caption)
    TextView mTvMoThingsCaption;

    @BindView(R.id.textview_mo_result_things_description)
    TextView mTvMoThingsDescription;

    @BindView(R.id.textview_mo_result_private_life_caption)
    TextView mTvMoPrivateLifeCaption;

    @BindView(R.id.textview_mo_result_private_life_description)
    TextView mTvMoPrivateLifeDescription;

    @BindView(R.id.textview_mo_result_friends_caption)
    TextView mTvMoFriendsCaption;

    @BindView(R.id.textview_mo_result_friends_description)
    TextView mTvMoFriendsDescription;

    @BindView(R.id.textview_mo_result_enemyes_caption)
    TextView mTvMoEnemyesCaption;

    @BindView(R.id.textview_mo_result_enemyes_description)
    TextView mTvMoEnemyesDescription;

    @BindView(R.id.textview_mo_result_rest_caption)
    TextView mTvMoRestCaption;

    @BindView(R.id.textview_mo_result_rest_description)
    TextView mTvMoRestDescription;

    @BindView(R.id.textview_mo_result_health_caption)
    TextView mTvMoHealthCaption;

    @BindView(R.id.textview_mo_result_health_description)
    TextView mTvMoHealthDescription;

    @BindView(R.id.textview_mo_result_self_improvement_caption)
    TextView mTvMoSelfImprovementCaption;

    @BindView(R.id.textview_mo_result_self_improvement_description)
    TextView mTvMoSelfImprovementDescription;

    @BindView(R.id.textview_mo_result_business_caption)
    TextView mTvMoBusinessCaption;

    @BindView(R.id.textview_mo_result_business_description)
    TextView mTvMoBusinessDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);
        mPresenter = new MoResultPresenter();
        mPresenter.setView(this);

        Utils.setTypefaceBold(mTvMoResult1);
        Utils.setTypefaceBold(mTvMoResult2);
        Utils.setTypefaceBold(mTvMoCaption);
        Utils.setTypefaceBold(mTvMoTasksCaption);
        Utils.setTypefaceBold(mTvMoFamilyCaption);
        Utils.setTypefaceBold(mTvMoThingsCaption);
        Utils.setTypefaceBold(mTvMoPrivateLifeCaption);
        Utils.setTypefaceBold(mTvMoFriendsCaption);
        Utils.setTypefaceBold(mTvMoEnemyesCaption);
        Utils.setTypefaceBold(mTvMoRestCaption);
        Utils.setTypefaceBold(mTvMoHealthCaption);
        Utils.setTypefaceBold(mTvMoSelfImprovementCaption);
        Utils.setTypefaceBold(mTvMoBusinessCaption);

        Utils.setTypefaceLite(mTvMoDescription);
        Utils.setTypefaceLite(mTvMoTasksDescription);
        Utils.setTypefaceLite(mTvMoFamilyDescription);
        Utils.setTypefaceLite(mTvMoThingsDescription);
        Utils.setTypefaceLite(mTvMoPrivateLifeDescription);
        Utils.setTypefaceLite(mTvMoFriendsDescription);
        Utils.setTypefaceLite(mTvMoEnemyesDescription);
        Utils.setTypefaceLite(mTvMoRestDescription);
        Utils.setTypefaceLite(mTvMoHealthDescription);
        Utils.setTypefaceLite(mTvMoSelfImprovementDescription);
        Utils.setTypefaceLite(mTvMoBusinessDescription);

        mPresenter.showResult();
    }

    @OnClick(R.id.button_mo_result_back)
    void onBackClick() {
        finish();
    }

    @OnClick (R.id.button_mo_result_close)
    void onCloseClick() {
        mPresenter.showMainScreen();
    }

    @Override
    public void showMainScreen() {
        MainActivity.start(this);
    }

    @Override
    public void showResult(Mo mo) {
        mTvMoResult1.setText(mo.getFirst());
        mTvMoResult2.setText(mo.getSecond());
        mTvMoCaption.setText(mo.getCaption());
        mTvMoDescription.setText(mo.getDescription());
        mTvMoTasksDescription.setText(mo.getTasks());
        mTvMoFamilyDescription.setText(mo.getFamily());
        mTvMoThingsDescription.setText(mo.getThings());
        mTvMoPrivateLifeDescription.setText(mo.getPrivate_life());
        mTvMoFriendsDescription.setText(mo.getFriends());
        mTvMoEnemyesDescription.setText(mo.getEnemyes());
        mTvMoRestDescription.setText(mo.getRest());
        mTvMoHealthDescription.setText(mo.getHealth());
        mTvMoSelfImprovementDescription.setText(mo.getSelf_improvement());
        mTvMoBusinessDescription.setText(mo.getBusiness());
    }
}
