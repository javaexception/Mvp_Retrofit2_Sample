package com.qzs.mvp_retrofit2_sample.mvp.model;


import com.qzs.mvp_retrofit2_sample.bean.CurrencyBean;
import com.qzs.mvp_retrofit2_sample.http.BaseResponse;
/**
 * @author qinzishuai
 * 描述：  model
 * 创建日期：2019/7/12
 *
 */
public interface ILoginModel {


    void login(String phone,  String code, OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener);

}
