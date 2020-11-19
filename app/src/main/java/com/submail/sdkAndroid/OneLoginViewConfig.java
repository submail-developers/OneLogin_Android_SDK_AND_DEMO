package com.submail.sdkAndroid;

import android.content.Context;
import android.view.View;

import com.submail.onelogin.sdk.client.SubSDK;
import com.submail.onelogin.sdk.ui.LoginPageConfig;

//联通和电信授权页配置
public class OneLoginViewConfig {
    public static LoginPageConfig initXmlConfig(final Context ctx) {
        return new LoginPageConfig.Builder()
                //设置授权页是否使用弹框模式（可选）
                .setDialogTheme(false, 400, 500, 50, 50, false)
                //设置“登录授权页”的布局文件ID
                .setAuthActivityLayoutId(R.layout.submail_login_activity)
                .setStusBar(R.color.colorAccent,true)//设置状态栏颜色和是否隐藏
                //设置“登录授权页”的控件ID
                .setAuthActivityViewIds(R.id.submail_login_nav_back, //导航栏返回按钮ID
                        R.id.submail_login_number,                   //脱敏号码控件ID
                        R.id.submail_login_provider,                 //品牌标识控件ID
                        R.id.submail_login_submit_layout,            //登录按钮控件ID
                        R.id.submail_login_submit_loading,           //登录加载中控件ID（必须为LoadingView控件）
                        R.id.submail_login_switch_tv,                //切换登录方式控件ID
                        R.id.submail_login_checkbox,                 //隐私协议勾选框控件ID
                        R.id.submail_login_agreement)                //隐私协议文本控件ID
                //设置“隐私协议页面”的布局文件id
                .setWebviewActivityLayoutId(R.layout.submail_activity_agreement)
                //设置“隐私协议页面”的控件id
                .setWebviewActivityViewIds(R.id.submail_login_web_nav_iv, //导航栏返回按钮ID
                        R.id.submail_login_webview)                       //协议内容WebView控件ID
                //添加View及点击事件（可选）
                .setExtendView(R.id.submail_login_nav_back, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SubSDK.quitActivity(ctx);
                    }
                })
                .setPrivacyPolicy(R.id.submail_login_agreement_primary1,"https://www.mysubmail.com")
                .build();


    }

}
