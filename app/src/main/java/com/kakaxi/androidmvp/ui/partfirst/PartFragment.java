package com.kakaxi.androidmvp.ui.partfirst;

import android.os.Bundle;

import com.kakaxi.androidmvp.R;
import com.kakaxi.androidmvp.base.BaseFragment;
import com.kakaxi.androidmvp.model.user.UserInfo;
import com.kakaxi.androidmvp.presenter.user.LoginContract;
import com.kakaxi.androidmvp.presenter.user.LoginPresenterImp;

/**
 * Created by Administrator on 2018/3/26.
 */

public class PartFragment extends BaseFragment<LoginPresenterImp> implements LoginContract.View{
    public static final String ARGUMENT_TASK_ID = "TASK_ID";
    public static PartFragment newInstance(String params) {
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_TASK_ID, params);
        PartFragment fragment = new PartFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void showsToast(String msg) {

    }

    @Override
    public void getResponseResult(UserInfo userInfo) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.pary_fragment;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        String params = getArguments().getString(ARGUMENT_TASK_ID);
//        mPresenter.regist();
    }

    @Override
    protected Class getContractClazz() {
        return LoginContract.class;
    }
}
