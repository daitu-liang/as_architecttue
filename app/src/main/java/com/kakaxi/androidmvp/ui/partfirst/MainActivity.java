package com.kakaxi.androidmvp.ui.partfirst;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kakaxi.androidmvp.R;
import com.kakaxi.androidmvp.base.BaseActivity;
import com.kakaxi.androidmvp.model.partyfirst.AttenListBean;
import com.kakaxi.androidmvp.presenter.partyfirst.PartFirstPresenterImp;
import com.kakaxi.androidmvp.presenter.partyfirst.PartyFirstContract;
import com.kakaxi.androidmvp.utils.ListUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<PartFirstPresenterImp> implements PartyFirstContract.View {

    @BindView(R.id.content_desc)
    TextView contentDesc;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitView(Bundle bundle) {

    }

    @Override
    protected Class getContractClazz() {
        return PartyFirstContract.class;
    }


    @Override
    public void showsToast(String msg) {

    }


    @Override
    public void getResponseResult(List<AttenListBean> list) {
        if(ListUtil.isEmpty(list))return;
        String des="";
        for (int i = 0; i < list.size(); i++) {
            des+=list.get(i).toString()+"\\n";
        }
        contentDesc.setText("結果：\n"+des);
    }



    @OnClick(R.id.button)
    public void onViewClicked() {
        mPresenter.getDataList();
    }
}
