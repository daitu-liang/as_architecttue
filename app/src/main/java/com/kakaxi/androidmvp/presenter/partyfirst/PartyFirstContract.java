package com.kakaxi.androidmvp.presenter.partyfirst;

import com.kakaxi.androidmvp.base.CommonPresenter;
import com.kakaxi.androidmvp.base.CommonView;
import com.kakaxi.androidmvp.model.annotation.Implement;
import com.kakaxi.androidmvp.model.partyfirst.AttenListBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/24.
 */
@Implement(PartFirstPresenterImp.class)
public interface PartyFirstContract {
    interface  View extends CommonView{
        void  getResponseResult(List<AttenListBean> list);
    }
    interface Presenter extends CommonPresenter {
        void getDataList();

    }
}
