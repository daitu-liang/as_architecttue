package com.kakaxi.androidmvp.network.config;

import java.util.LinkedHashMap;
import java.util.Map;



public class BaseParamsMapUtil {
    /**
     * 公共参数
     * @return
     */
    public static Map<String, String> getParamsMap() {
        Map<String, String> paramsmap = new LinkedHashMap<>();
        paramsmap.put("i", "8");
        paramsmap.put("c", "entry");
        paramsmap.put("m", "triple");
        paramsmap.put("do", "route");
        return paramsmap;
    }
}
