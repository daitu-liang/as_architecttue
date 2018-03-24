package com.kakaxi.androidmvp.view.user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.kakaxi.androidmvp.R;
import com.kakaxi.androidmvp.base.BaseActivity;
import com.kakaxi.androidmvp.model.user.UserInfo;
import com.kakaxi.androidmvp.presenter.user.LoginContract;
import com.kakaxi.androidmvp.presenter.user.LoginPresenterImp;
import com.kakaxi.androidmvp.utils.ToastUtils;
import com.kakaxi.androidmvp.view.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<LoginPresenterImp> implements LoginContract.View {



    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitView(Bundle bundle) {

        email.setText("222222222222222");

    }
    @OnClick(R.id.email_sign_in_button)
    public void onViewClicked() {
        Log.i("info","点击登录");
        mPresenter.login("13333333333", "123456");
    }

    protected   void onEvent(){
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(LoginActivity.this, "iiiiii");
            }
        });
    };

    @Override
    protected Class getContractClazz() {
        return LoginContract.class;
    }


    @Override
    public void showsToast(String msg) {
        ToastUtils.showToast(this, msg);
    }


    @Override
    public void getResponseResult(UserInfo userInfo) {
        startActivity(MainActivity.getIntent(this));

    }

}

