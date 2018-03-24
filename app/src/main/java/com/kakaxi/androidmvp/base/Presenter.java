package com.kakaxi.androidmvp.base;

/**
 * Created by Administrator on 2018/3/23.
 */

public interface Presenter<View> {
    //    绑定View控件
    void attachView(View view);
    //    注销View控件
    void detachView();
}
