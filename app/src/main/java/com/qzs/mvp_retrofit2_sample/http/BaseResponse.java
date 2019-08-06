/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qzs.mvp_retrofit2_sample.http;

import java.io.Serializable;
/**
 * @author qinzishuai
 * 描述：
 * 创建日期：2019/7/12
 *
 */
public class BaseResponse<T> implements Serializable {
    private static int SUCCESS_CODE = 0;//成功的code
    private static final long serialVersionUID = 5213230387175987834L;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int code;
    public String msg;
    public T data;


    public boolean isSuccess() {
        return getCode() == SUCCESS_CODE;
    }


}
