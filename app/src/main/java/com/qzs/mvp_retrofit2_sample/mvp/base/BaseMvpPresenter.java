package com.qzs.mvp_retrofit2_sample.mvp.base;

import android.util.Log;
import android.view.View;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.lang.ref.WeakReference;


public class BaseMvpPresenter<V extends IBaseMvpView> {

    /**
     * v层泛型引用
     */
    protected V mView;

    private WeakReference<V> weakReferenceView;
    //防止空指针
    protected V getView(){
        if(mView == null) {
            throw new IllegalStateException("view not attached");
        }
        else{
            return mView;
        }
    }

    public void attachMvpView(V view) {
        weakReferenceView = new WeakReference<>(view);
        this.mView = weakReferenceView.get();
    }


    public void detachMvpView() {
        weakReferenceView.clear();
        weakReferenceView = null;
        mView = null;
    }


}
