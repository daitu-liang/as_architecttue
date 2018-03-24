package com.kakaxi.androidmvp.network.api.commom;


import com.kakaxi.androidmvp.model.user.UserInfo;
import com.kakaxi.androidmvp.network.HttpResult;
import com.kakaxi.androidmvp.network.api.NetApi;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiCommom {

    @FormUrlEncoded
    @POST(NetApi.USER_LOGIN)
    Observable<HttpResult<UserInfo>> getLogin(@FieldMap Map<String, String> map);

}
