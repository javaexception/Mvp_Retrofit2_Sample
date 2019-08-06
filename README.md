# Mvp_Retrofit2_Sample
mvp_retrofit2+rxjava2+okhttp3
### MVP简介

>MVP 全称：Model-View-Presenter ；MVP 是从经典的模式MVC演变而来，它们的基本思想有相通的[地方](https://baike.baidu.com/item/%E5%9C%B0%E6%96%B9/2262175)：Controller/Presenter负责逻辑的处理，Model提供数据，View负责显示。

对于MVC不了解的朋友可以查此文：
[Android进阶之路(1)-详解MVC](https://www.jianshu.com/p/285f6a8d971f)

**Android中的MVP:**
- M层：适合做一些业务逻辑处理，比如数据库存取操作，网络操作，复杂的算法，耗时的任务等都在model层处理。和MVC类似

 - V层：对应的Activity，负责xml绘制与页面交互
- P层：负责View与Model之间的交互

![](https://upload-images.jianshu.io/upload_images/2787891-79be9a775b4d4459.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 为什么要用MVP
我们先想想上篇文章，我们讲到为什么要用MVC，当时我们总结了几点：
- 代码复用
- 耦合性低
- 方便维护的高等

然而我们在写MVC项目时候，也发现了一些问题：
1.对于Android中的Activity或者Fragment ，我们不能很清晰的区分它是View还是Controller，既有交互又有页面绘制，这就导致了activity和fragment很“庞大”

2.View与Model确实是分离的，但是关联性太强，这就导致activity与model的联系强，这样我们只要改一点点代码， model 、view、activity  都会变，维护成本太高，View与Model之前的耦合性太高。

而MVP最大的改变就是View与Model实现完全隔离。View把操作意图给P层，P收到后，会调用Model层来实现具体的逻辑， 逻辑实现后会再通知给P， P再通过View的接口回调给View。即便V和M更改了，也不会有影响，耦合性低。


### MVP DEMO
以登录模块为例，来实现MVP

**1.定义View接口- ILoginView**   
```
 /**
     * 获取view层的dialog
     *
     * @return retuen
     */
    Dialog getLoadDialog();

    /***
     * 关闭view层的dialog
     */
    void  cancelLoadDialog();

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
```
View接口大家都明白吧？就是你要告诉给P的意图。activity实现此接口。并调用P的方法：
```
    @Override
    public void cancelLoadDialog() {

        if (dialog!=null&&dialog.isShowing()){
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

```

```
     mPresenter.login();
```



**2.定义Model与ModelImpl**
Model：
```
public interface ILoginModel {


    void login(String phone,  String code, OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener);

}
```
ModelImpl  ：
```

    @Override
    public void login(String phone, String code, final OnLoadDatasListener<CurrencyBean.DataBean> onLoadDatasListener) {
    //填写具体的操作逻辑与onLoadDatasListener回调
    }
```

model实现类逻辑处理完成之后会通知给P，定义P：
```
    /**
     * 登陆
     */
    public void login() {
        if (mView == null) return;
        if (TextUtils.isEmpty(mView.getPhone()) || TextUtils.isEmpty(mView.getCode())) {
            mView.showMsg("手机号或密码不能为空");
            return;
        }
        mView.getLoadDialog().show();
    loginModel.login(mView.getPhone(), mView.getCode(), new OnLoadDatasListener<CurrencyBean.DataBean>() {
        @Override
        public void onSuccess(CurrencyBean.DataBean dataBean) {
            Gson gson=new Gson();
            mView.cancelLoadDialog();
            Log.e("qzs----   ",gson.toJson(dataBean)+"");
           mView.loginSuccess();
        }



        @Override
        public void onFailure(String error) {
            mView.cancelLoadDialog()；
            mView.loginFail();

        }
    });

    }
```
P通过View接口返回给View

另外MVP也是有缺点的：
 - 增加代码的复杂度
 - 实现难度增加
 - 如果某特定视图的渲染很多（activity），就会造成Presenter与该视图联系过于紧密，一旦该视图需要变更，那么Presenter也需要变更了，不能如预期的那样降低耦合度和增加复用性。

大家可以关注我的微信公众号：「秦子帅」一个有质量、有态度的公众号！

![公众号](https://upload-images.jianshu.io/upload_images/2787891-27c5da75f456332a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

