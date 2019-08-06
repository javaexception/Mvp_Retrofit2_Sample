package com.qzs.mvp_retrofit2_sample.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.qzs.mvp_retrofit2_sample.common.IActivity;
import com.trello.rxlifecycle2.components.RxActivity;



public abstract class BaseMvpActivity<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> extends RxActivity implements IBaseMvpView, IActivity , View.OnClickListener{

    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachMvpView((V) this);
        initView();

        initData( savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMvpView();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
