package com.kakaxi.androidmvp.model;


import com.kakaxi.androidmvp.base.BasePresenter;
import com.kakaxi.androidmvp.base.BaseView;
import com.kakaxi.androidmvp.model.annotation.Implement;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ContractProxy {
    private static final ContractProxy m_instance = new ContractProxy();

    public static ContractProxy getInstance() {
        return m_instance;
    }

    private ContractProxy() {
        m_objects = new HashMap<>();
    }

    private Map<Class, Object> m_objects;

    public void init(Class... clss) {
        for (Class cls : clss) {
            //判断这个类是不是存在Implement注解
            if (cls.isAnnotationPresent(Implement.class)) {
//                list.add(cls);
                for (Annotation ann : cls.getDeclaredAnnotations()) {
                    if (ann instanceof Implement) {
                        try {
                            //添加present
                            m_objects.put(cls, ((Implement) ann).value().newInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    // 初始化presenter add map
    public <T> T bind(Class clzz, BaseView var1) {
        if (!m_objects.containsKey(clzz)) {
            init(clzz);
        }
        //获取present
        BasePresenter presenter = ((BasePresenter) m_objects.get(clzz));
        if (var1 != presenter.getView()) {
            if (presenter.getView() != null) {
                presenter.detachView();
            }
            presenter.attachView(var1);
        }
        return (T) presenter;
    }

    // 解除绑定 移除map
    public void unbind(Class clzz, BaseView var1) {
        if (m_objects.containsKey(clzz)) {
            BasePresenter presenter = ((BasePresenter) m_objects.get(clzz));
            if (var1 != presenter.getView()) {
                if (presenter.getView() != null)
                    presenter.detachView();
                m_objects.remove(clzz);
            }

        }
    }
}