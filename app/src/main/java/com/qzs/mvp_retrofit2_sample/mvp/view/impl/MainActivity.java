package com.qzs.mvp_retrofit2_sample.mvp.view.impl;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qzs.mvp_retrofit2_sample.R;
import com.qzs.mvp_retrofit2_sample.mvp.base.BaseMvpActivity;
import com.qzs.mvp_retrofit2_sample.mvp.presenter.LoginPresenter;
import com.qzs.mvp_retrofit2_sample.mvp.view.ILoginView;
import com.qzs.mvp_retrofit2_sample.utils.DialogUtils;

public class MainActivity extends BaseMvpActivity<ILoginView, LoginPresenter>  implements  ILoginView {

    private EditText edPhone;
    private EditText edCode;
    private Button btn;

    private Dialog dialog;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        edPhone = (EditText) findViewById(R.id.ed_phone);
        edCode = (EditText) findViewById(R.id.ed_code);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        dialog = DialogUtils.createLoadingDialog(this, "请稍后...");
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btn){
            mPresenter.login();
        }

    }
    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @Override
    public Dialog getLoadDialog() {
        if (dialog==null){
            dialog = DialogUtils.createLoadingDialog(this, "请稍后...");
        }
        return dialog;
    }

    @Override
    public void cancelLoadDialog() {

        if (!MainActivity.this.isFinishing()&&dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }

    }

    @Override
    public String getPhone() {
        return edPhone.getText().toString();
    }

    @Override
    public String getCode() {
        return edCode.getText().toString();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFail() {

    }


}
