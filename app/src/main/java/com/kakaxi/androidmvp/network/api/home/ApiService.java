package com.kakaxi.androidmvp.network.api.home;


import com.kakaxi.androidmvp.model.partyfirst.AttenListBean;
import com.kakaxi.androidmvp.model.user.UserInfo;
import com.kakaxi.androidmvp.network.HttpResult;
import com.kakaxi.androidmvp.network.api.NetApi;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

/**
 * Created by leixiaoliang on 2017/4/12.
 * 邮箱：lxliang1101@163.com
 */

public interface ApiService {


    /* @GET(NetApi.USER_WORKS_LIST)
     Observable<HttpResult<List<WorkItemBean>>> getWaitDoWorkList(@QueryMap() Map<String, String> map);
     */
    @FormUrlEncoded
    @POST(NetApi.USER_PUSH)
    Observable<HttpResult<Object>> gePuhs(@FieldMap Map<String, String> map);


    @FormUrlEncoded
    @POST(NetApi.USER_LOGIN)
    Observable<HttpResult<UserInfo>> getLogin(@FieldMap Map<String, String> map);


    @GET(NetApi.USER_WORKS_LIST)
    Observable<HttpResult<List<AttenListBean>>> geAttenList(@QueryMap() Map<String, String> map);


    /**
     * 上传单文件
     *
     * @param file
     * @return
     */
    @Multipart
    @POST(NetApi.UP_LOAD_PIC)
    Observable<ResponseBody> upLoadFile(@Part MultipartBody.Part file);


    /**
     * 上传带参Part
     *
     * @param file
     * @return
     */
    @Multipart

    @POST(NetApi.UP_LOAD_PIC)
    Observable<ResponseBody> upLoadFile(@Part("user_id") RequestBody description, @Part MultipartBody.Part file);

    /**
     * 上传多文件
     *
     * @param map
     * @return
     */
    @Multipart
    @POST(NetApi.UP_LOAD_PIC)
    Observable<ResponseBody> upLoadMutiFile(@PartMap Map<String, RequestBody> map);


}
