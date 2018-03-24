package com.kakaxi.androidmvp.base;

/**
 * Created by Administrator on 2018/3/23.
 */

public class BasePresenter<T extends BaseView> implements Presenter<T> {
    protected T mView;
    //绑定view
    @Override
    public void attachView(T view) {
        this.mView=view;
    }

    //解绑view
    @Override
    public void detachView() {
        this.mView=null;
    }
    public T getView() {
        return mView;
    }

    public boolean isViewBind()
    {
        return mView!=null;
    }

}
