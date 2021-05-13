package com.submail.sdkAndroid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cmic.sso.sdk.AuthThemeConfig;
import com.cmic.sso.sdk.activity.LoginAuthActivity;
import com.cmic.sso.sdk.auth.BackPressedListener;
import com.cmic.sso.sdk.auth.LoginClickListener;
import com.submail.onelogin.sdk.utils.Logger;

import org.json.JSONObject;

//由于中国移动授权页依赖中国移动sdk内置的授权页，需要单独配置中国移动授权页
public class CmOneLoginViewConfig {
    Dialog alertDialog;

    public static AuthThemeConfig.Builder initConfig(final Context ctx) {


        return new AuthThemeConfig.Builder()
                .setStatusBar(0xff0086d0, false)//状态栏颜色、字体颜色
//                .setAuthLayoutResID(R.layout.empty_layout)
                .setAuthContentView(new CustomView(ctx))
                .setNavTextSize(20)
                .setNavTextColor(0xffffffff)//导航栏字体颜色
                .setNavColor(Color.BLUE)

                .setNumberSize(30,false)////手机号码字体大小
                .setNumberColor(0xff333333)//手机号码字体颜色
//                .setNumberOffsetX(30)//号码栏X偏移量 如不设置则默认居中
//                .setNumFieldOffsetY_B(200)
                .setNumFieldOffsetY(250)//号码栏Y偏移量

//                .setLogBtnText("本机号码一键登录")//登录按钮文本
//                .setLogBtnTextColor(0xFFFFFF)//登录按钮文本颜色
                .setLogBtnImgPath("submail_btn_bg")//登录按钮背景
                .setLogBtnText("一键登录", 0xffffffff, 15,false)
                .setLogBtnOffsetY_B(400)//登录按钮Y偏移量
                .setLogBtnOffsetY(400)//登录按钮Y偏移量
                .setLogBtn(500, 50)
                .setLogBtnMargin(30, 30)
                .setCheckTipText("请勾选协议")//未勾选时点击登录按钮的提示
                .setBackPressedListener(new BackPressedListener() {
                    @Override
                    public void onBackPressed() {
                        Toast.makeText(ctx,"返回键回调",Toast.LENGTH_SHORT).show();
                    }
                })
                .setLogBtnClickListener(new LoginClickListener() {
                    @Override
                    public void onLoginClickStart(Context context, JSONObject jsonObject) {
                        //登录开始监听
                    }

                    @Override
                    public void onLoginClickComplete(Context context, JSONObject jsonObject) {
                        //登录完成后监听
                    }
                })
//                .setCheckedImgPath("submail_login_checked")//checkbox被勾选图片
//                .setUncheckedImgPath("submail_login_unchecked")//checkbox未被勾选图片
                .setCheckBoxImgPath("submail_login_checked", "submail_login_unchecked", 9, 9)
                .setPrivacyState(false)//授权页check

                .setPrivacyAlignment("登录即同意" + AuthThemeConfig.PLACEHOLDER + "自定义协议一、自定义协议二、自定义协议三、自定义协议四、并使用本机号码校验", "自定义协议一", "https://www.baidu.com", "自定义协议二", "https://mysubmail.com",
                        "自定义协议三", "http://www.sina.com", "自定义协议四", "http://gz.58.com")
                .setPrivacyOffsetY(30)//隐私条款Y偏移量
                .setPrivacyOffsetY_B(30)//隐私条款Y偏移
                .setPrivacyMargin(20, 30)
                .setPrivacyText(10, 0xff666666, 0xff0085d0, true,false)
                .setClauseColor(0xffff0000, 0xff00ff00)//条款颜色
                .setClauseLayoutResID(R.layout.title_layout, "clause_back");
//

    }


}
