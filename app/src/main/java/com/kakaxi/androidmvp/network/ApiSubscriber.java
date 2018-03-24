package com.kakaxi.androidmvp.network;

import android.content.Context;
import android.widget.Toast;

import com.kakaxi.androidmvp.app.App;
import com.kakaxi.androidmvp.utils.Logger;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by leixiaoliang on 2017/1/6.
 */
public abstract class ApiSubscriber<T> extends DisposableObserver<T> {
    private Logger log = Logger.getLogger("ApiSubscriber");

    private Context context;

    public ApiSubscriber() {
    }

    public ApiSubscriber(Context context) {
        this.context = context;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);

    }

    protected abstract void onSuccess(T bean);

    @Override
    public void onError(Throwable e) {
        log.e("", "onError---ApiSubscriber-message=" + e.getMessage());
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(App.getContext(), "请求超时", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(App.getContext(), "连接失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(App.getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
//        Toast.makeText(App.getContext(), "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        doCanlSubscribe();
    }

    @Override
    public void onComplete() {
        doCanlSubscribe();
    }

    /**
     * 断开上下流，解绑
     */
    public void doCanlSubscribe() {
        if (!this.isDisposed()) {
            this.dispose();
        }
    }


}