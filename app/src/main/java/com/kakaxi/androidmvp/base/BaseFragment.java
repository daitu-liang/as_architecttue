package com.kakaxi.androidmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kakaxi.androidmvp.model.ContractProxy;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/22.
 */
public abstract class BaseFragment<T extends BasePresenter> extends RxFragment implements BaseView<T> {
    protected Unbinder unbinder;
    protected View rootView;
    protected Context mContext = null;//context

    //    定义Presenter
    protected  T mPresenter;

    //    获取布局资源文件
    protected  abstract  int getLayoutId();

//    初始化数据

    protected  abstract void onInitView(Bundle bundle);

//    初始化事件Event

    protected    void onEvent(){

    };

    //    获得抽取接口Class对象
    protected  abstract Class getContractClazz();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() != 0) {
            rootView = inflater.inflate(getLayoutId(), null);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        unbinder= ButterKnife.bind(this, rootView);
        bindPresenter();
        onInitView(savedInstanceState);
        onEvent();
        return rootView;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }

    @Override
    public void onStart() {
        if (mPresenter != null && !mPresenter.isViewBind()) {
            ContractProxy.getInstance().bind(getContractClazz(),this);
        }
        super.onStart();
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindPresenter();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (mPresenter != null)
        {
            ContractProxy.getInstance().unbind(getContractClazz(),this);
            mPresenter.detachView();
        }

    }

}
