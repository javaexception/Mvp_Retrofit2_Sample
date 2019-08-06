package com.qzs.mvp_retrofit2_sample.common;

import android.os.Bundle;

import java.util.concurrent.ExecutionException;
/**
 * @author qinzishuai
 * 描述：
 * 创建日期：2019/7/12
 *
 */
public interface IActivity {

    int getLayout();

    void initView();

    void initData(Bundle savedInstanceState);
}
