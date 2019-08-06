package com.qzs.mvp_retrofit2_sample.mvp.model.impl;



import android.util.Log;

import com.qzs.mvp_retrofit2_sample.bean.CurrencyBean;
import com.qzs.mvp_retrofit2_sample.http.BaseObserver;
import com.qzs.mvp_retrofit2_sample.http.BaseResponse;
import com.qzs.mvp_retrofit2_sample.http.RetrofitFactory;
import com.qzs.mvp_retrofit2_sample.mvp.model.ILoginModel;
import com.qzs.mvp_retrofit2_sample.mvp.model.OnLoadDatasListener;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * @author qinzishuai
 * 描述：    model实现类
 * 创建日期：2019/7/12
 *
 */
public class LoginModelImpl implements ILoginModel {

    /***
     * 登录
     * @param phone
     * @param code
     * @param onLoadDatasListener
     */
    @Override
    public void login(String phone, String code, final OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener) {

        RetrofitFactory
                .getInstence()
                .getLogin(phone, code, new BaseObserver<CurrencyBean.DataBean>() {
                    @Override
                    protected void onSuccees(CurrencyBean.DataBean dataBean) throws Exception {
                        onLoadDatasListener.onSuccess(dataBean);

                    }

                    @Override
                    protected void onFailure(String error, boolean isNetWorkError) throws Exception {
                        onLoadDatasListener.onFailure(error);
                    }
                });


    }
}
