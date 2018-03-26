package com.kakaxi.androidmvp.presenter.user;

import com.kakaxi.androidmvp.base.BasePresenter;
import com.kakaxi.androidmvp.model.user.UserInfo;
import com.kakaxi.androidmvp.network.ApiSubscriberByContext;
import com.kakaxi.androidmvp.network.RetrofitClient;
import com.kakaxi.androidmvp.network.api.commom.ApiCommom;
import com.kakaxi.androidmvp.network.config.HttpConfig;
import com.kakaxi.androidmvp.view.user.LoginActivity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/24.
 */


public class LoginPresenterImp extends BasePresenter<LoginActivity> implements LoginContract.Presenter {
    @Override
    public void login(String phone, String pwd) {
        if(!isViewBind())return;
        Map<String, String> paramsmap = new LinkedHashMap<>();
        paramsmap.put("name", phone);
        paramsmap.put("password", pwd);
        RetrofitClient.getInstance()
                .builder(ApiCommom.class)
                .getLogin(paramsmap)
                .compose(HttpConfig.<UserInfo>toTransformer())
                .compose(mView.<UserInfo>bindToLifecycle())
                .subscribe(new ApiSubscriberByContext<UserInfo>(mView) {
                    @Override
                    protected void onSuccess(UserInfo bean) {
                        if(isViewBind()){
                            mView.showsToast("登录成功");
                            mView.getResponseResult(bean);
                        }

                    }
                });
    }

    @Override
    public void regist() {

    }

    @Override
    public void forgetPwd() {

    }
}
