package com.kakaxi.androidmvp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/9.
 */

public class ToastUtils {

    private static Toast toast;
    public  static  void showToast(Context context, String message){
        if(toast==null){// 不用getApplicationContext的话,导致内存泄露
            toast= Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();
        }else {
            toast.setText(message);
            toast.show();
        }

    }
}
