package com.qzs.mvp_retrofit2_sample.http;
import com.qzs.mvp_retrofit2_sample.bean.CurrencyBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author qinzishuai
 * 描述：  接口
 * 创建日期：2019/7/12
 *
 */
public interface ApiService {


    String BASE_URL = "http://39.98.179.212:8686/pig-joggle/";

    //网络请求时长
    int HTTP_TIME = 5000;

        @FormUrlEncoded
    @POST("healthApp/login")
    Observable<BaseResponse<CurrencyBean.DataBean>> getlogin(@Field("phone") String phone, @Field("code") String code);

}
