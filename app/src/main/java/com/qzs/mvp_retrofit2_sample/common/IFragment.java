package com.qzs.mvp_retrofit2_sample.common;

import android.os.Bundle;



public interface IFragment {

    int getLayout();

    void initView();

    void initData(Bundle savedInstanceState);
}
