package com.kakaxi.androidmvp.presenter.partyfirst;

import com.kakaxi.androidmvp.base.BasePresenter;
import com.kakaxi.androidmvp.model.partyfirst.AttenListBean;
import com.kakaxi.androidmvp.network.ApiSubscriberByContext;
import com.kakaxi.androidmvp.network.ParamsMapUtils;
import com.kakaxi.androidmvp.network.RetrofitClient;
import com.kakaxi.androidmvp.network.api.home.ApiService;
import com.kakaxi.androidmvp.network.config.HttpConfig;
import com.kakaxi.androidmvp.view.MainActivity;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/24.
 */

public class PartFirstPresenterImp extends BasePresenter<MainActivity> implements PartyFirstContract.Presenter {
    @Override
    public void getDataList() {

        Map<String, String> map = ParamsMapUtils.setReminding("1");
        RetrofitClient.getInstance()
                .builder(ApiService.class)
                .geAttenList(map)
                .compose(HttpConfig.<List<AttenListBean>>toTransformer())
                .compose(mView.<List<AttenListBean>>bindToLifecycle())
                .subscribe(new ApiSubscriberByContext<List<AttenListBean>>(mView) {
                    @Override
                    protected void onSuccess(List<AttenListBean> bean) {
                        mView.getResponseResult(bean);

                    }
                });
    }
}
