package com.kakaxi.androidmvp.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.kakaxi.androidmvp.app.App;
import com.kakaxi.androidmvp.utils.Logger;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by leixiaoliang on 2017/1/6.
 */
public abstract class ApiSubscriberByContext<T> extends DisposableObserver<T> {
    private Logger log = Logger.getLogger("ApiSubscriber");


    private boolean showDialog = false;
    private Context context;
    private ProgressDialog pd;

    private boolean cancelable;
    public ApiSubscriberByContext() {
        showDialog = false;
    }

    public ApiSubscriberByContext(Context context) {
        this.context = context;
        showDialog = true;;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (showDialog) {
            initProgressDialog();
        }

    }

    @Override
    public void onNext(T t) {
        log.e("", "onNext-ApiSubscriber=" + this.isDisposed());
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
        dismissProgressDialog();
//        Toast.makeText(App.getContext(), "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        doCanlSubscribe();
    }

    @Override
    public void onComplete() {
        log.e("", "onComplete-CanlSubscriberror=" + this.isDisposed() + "-showDialog--" + showDialog);
        if (showDialog) {
            dismissProgressDialog();
        }
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

    private void initProgressDialog(){
        if (pd == null&&context!=null) {
            pd = new ProgressDialog(context);
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setMessage("   正在加载....");
            pd.setCancelable(cancelable);// 设置是否可以通过点击Back键取消
            pd.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {

                    }
                });
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }


    }

    private void dismissProgressDialog(){
        if (pd != null&&pd.isShowing()) {
            pd.dismiss();
        }
    }

}