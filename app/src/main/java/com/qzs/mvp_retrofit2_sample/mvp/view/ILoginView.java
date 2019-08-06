package com.qzs.mvp_retrofit2_sample.mvp.view;

import android.app.Dialog;

import com.qzs.mvp_retrofit2_sample.mvp.base.IBaseMvpView;


public interface ILoginView extends IBaseMvpView {



    /**
     * 获取手机号参数
     *
     * @return username
     */
    String getPhone();

    /**
     * 获取密码
     *
     * @return password
     */
    String getCode();

    /**
     * 弹出消息
     *
     * @param msg msg
     */
    void showMsg(String msg);

    /***
     * 登录成功
     */
    void loginSuccess();

    /***
     * 登录失败
     */
    void loginFail();
}
