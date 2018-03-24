package com.kakaxi.androidmvp.network;


import com.kakaxi.androidmvp.network.config.BaseParamsMapUtil;

import java.util.Map;

/**
 * Created by leixiaoliang on 2017/4/13.
 * 邮箱：lxliang1101@163.com
 */

public class ParamsMapUtils extends BaseParamsMapUtil {

    private static Map<String, String> mapParams;

    /**
     * 默认参数
     * @return
     */
    public static Map<String, String> getDefaultParams() {
        return getParamsMap();
    }

    public static Map<String, String> setWaitDoWorkList(String date) {
        mapParams = getDefaultParams();
        mapParams.put("r", "backLog");
        mapParams.put("date", date);
        return mapParams;
    }

    public static Map<String, String> setReminding(String case_status) {
        mapParams = getDefaultParams();
        mapParams.put("r", "reminding");
        mapParams.put("user_id", "1625");
        mapParams.put("case_status", case_status);
        return mapParams;
    }
}
