package com.kakaxi.androidmvp.app;

import android.app.Application;
import android.content.Context;

import com.kakaxi.androidmvp.utils.PreferencesManager;

/**
 * Created by Administrator on 2018/3/22.
 */

public class App extends Application {
    public static Context CONTEXT;
    public static PreferencesManager preferenceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData() {

        preferenceManager = PreferencesManager.getInstance(this);

    }

    private static void setContext(Context mContext) {
        CONTEXT = mContext;
    }

    public static Context getContext() {
        return CONTEXT;
    }

    public static PreferencesManager getPreferenceManager() {
        return preferenceManager;
    }
}
