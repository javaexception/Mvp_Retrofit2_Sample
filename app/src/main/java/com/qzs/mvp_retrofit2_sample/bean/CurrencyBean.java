package com.qzs.mvp_retrofit2_sample.bean;

import com.qzs.mvp_retrofit2_sample.http.BaseResponse;

/**
 * @author qinzishuai
 * 描述：  通用bean
 * 创建日期：2019/4/26
 *
 */
public class CurrencyBean <BaseResponse>{


    /**
     * msg : success
     * code : 0
     * data : {}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean  {
    }
}
