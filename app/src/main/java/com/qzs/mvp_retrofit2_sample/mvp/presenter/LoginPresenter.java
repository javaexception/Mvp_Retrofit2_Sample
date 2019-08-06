package com.qzs.mvp_retrofit2_sample.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.qzs.mvp_retrofit2_sample.bean.CurrencyBean;
import com.qzs.mvp_retrofit2_sample.mvp.base.BaseMvpPresenter;
import com.qzs.mvp_retrofit2_sample.mvp.model.ILoginModel;
import com.qzs.mvp_retrofit2_sample.mvp.model.OnLoadDatasListener;
import com.qzs.mvp_retrofit2_sample.mvp.model.impl.LoginModelImpl;
import com.qzs.mvp_retrofit2_sample.mvp.view.ILoginView;
/**
 * @author qinzishuai
 * 描述：
 * 创建日期：2019/7/12
 *
 */

public class LoginPresenter extends BaseMvpPresenter<ILoginView> {

    /**
     * m层
     */
    private ILoginModel loginModel;

    /**
     * mvp模式  p层持有  v 和m 的接口引用 来进行数据的传递  起一个中间层的作用
     */
    public LoginPresenter() {

        this.loginModel = new LoginModelImpl();
    }

    /**
     * 登陆
     */
    public void login() {


        if (mView == null) return;
        if (TextUtils.isEmpty(mView.getPhone()) || TextUtils.isEmpty(mView.getCode())) {
            mView.showMsg("手机号或密码不能为空");
            return;
        }

 getView().getLoadDialog().show();
    loginModel.login(mView.getPhone(), mView.getCode(), new OnLoadDatasListener<CurrencyBean.DataBean>() {
        @Override
        public void onSuccess(CurrencyBean.DataBean dataBean) {
            Gson gson=new Gson();

            getView().cancelLoadDialog();
            Log.e("qzs----   ",gson.toJson(dataBean)+"");
            getView().loginSuccess();
        }



        @Override
        public void onFailure(String error) {
            getView().cancelLoadDialog();
            getView().showMsg(error);
            getView().loginFail();

        }
    });

    }
}
