package com.kakaxi.androidmvp.presenter.user;

import com.kakaxi.androidmvp.base.CommonPresenter;
import com.kakaxi.androidmvp.base.CommonView;
import com.kakaxi.androidmvp.model.annotation.Implement;
import com.kakaxi.androidmvp.model.user.UserInfo;

/**
 * Created by Administrator on 2018/3/24.
 */

@Implement(LoginPresenterImp.class)
public interface LoginContract {

    interface View extends CommonView{

       void  getResponseResult(UserInfo userInfo);
    }

    interface Presenter extends CommonPresenter{
        void login(String phone,String pwd);
        void regist();
        void forgetPwd();
    }
}
