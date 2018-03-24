package com.kakaxi.androidmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kakaxi.androidmvp.model.ContractProxy;
import com.kakaxi.androidmvp.utils.ScreenManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/22.
 */

public abstract class BaseActivity<T extends BasePresenter>  extends RxAppCompatActivity implements BaseView<T> {

    //    定义Presenter
    protected  T mPresenter;
    protected Unbinder unbinder;

    //    获取布局资源文件
    protected  abstract  int getLayoutId();

//    初始化数据

    protected  abstract void onInitView(Bundle bundle);

//    初始化事件Event

    protected   void onEvent(){

    };

    //    获得抽取接口Class对象
    protected  abstract  Class getContractClazz();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenManager.getScreenManager().pushActivity(this, true);
        if(getLayoutId()!=0)
        {
//            设置布局资源文件
            setContentView(getLayoutId());
//            注解绑定
            unbinder=  ButterKnife.bind(this);
            bindPresenter();
            onInitView(savedInstanceState);
            onEvent();
        }
    }

    private  void bindPresenter()
    {
        if(getContractClazz()!=null)
        {
            mPresenter=getPresenterImpl();
        }
    }

    private <T> T getPresenterImpl()
    {

        return ContractProxy.getInstance().bind(getContractClazz(),this);
    }

    @Override
    protected void onStart() {

        if(mPresenter!=null&&!mPresenter.isViewBind())
        {
            ContractProxy.getInstance().bind(getContractClazz(),this);
        }
        super.onStart();
    }

    /**
     *  activity摧毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if(mPresenter!=null)
        {
            ContractProxy.getInstance().unbind(getContractClazz(),this);
            mPresenter.detachView();
        }

        ScreenManager.getScreenManager().popActivity(this);
    }


}
