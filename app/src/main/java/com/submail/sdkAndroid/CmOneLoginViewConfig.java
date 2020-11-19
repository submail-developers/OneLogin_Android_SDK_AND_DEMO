package com.submail.sdkAndroid;

import com.cmic.sso.sdk.AuthThemeConfig;

//由于中国移动授权页依赖中国移动sdk内置的授权页，需要单独配置中国移动授权页
public class CmOneLoginViewConfig {

    public static AuthThemeConfig.Builder initConfig(){

        return new AuthThemeConfig.Builder()
                .setStatusBar(0xffffffff,false)
                .setAuthLayoutResID(R.layout.cm_login_activity)
                .setClauseLayoutResID(R.layout.title_layout)
                .setNavTextSize(20)
                .setNavTextColor(0xff0085d0)//导航栏字体颜色
                .setNumberSize(20)////手机号码字体大小
                .setNumberColor(0xff333333)//手机号码字体颜色
                .setNumberOffsetX(30)//号码栏X偏移量
                .setNumFieldOffsetY_B(100)
                .setNumFieldOffsetY(100)//号码栏Y偏移量
                .setLogBtnText("本机号码一键登录")//登录按钮文本
                .setLogBtnTextColor(0xffffffff)//登录按钮文本颜色
                .setLogBtnImgPath("submail_btn_bg")//登录按钮背景
                .setLogBtnText("一键登录",0xffffffff,15)
                .setLogBtnOffsetY_B(400)//登录按钮Y偏移量
                .setLogBtnOffsetY(400)//登录按钮Y偏移量
                .setLogBtn(500,30)
                .setLogBtnMargin(30,30)
//                .setCheckedImgPath("submail_login_checked")//checkbox被勾选图片
//                .setUncheckedImgPath("submail_login_unchecked")//checkbox未被勾选图片
                .setCheckBoxImgPath("submail_login_checked","submail_login_unchecked",9,9)
                .setPrivacyState(true)//授权页check
                .setPrivacyAlignment("登录即同意" + AuthThemeConfig.PLACEHOLDER2 + "《应用自定义服务条款一》、《应用自定义服务条款二》并使用本机号码校验","《应用自定义服务条款一》","https://www.baidu.com","《应用自定义服务条款二》","https://www.hao123.com")
                .setPrivacyText(10,0xff666666,0xff0085d0,false)
                .setClauseColor(0xff666666,0xff0085d0)//条款颜色
                .setPrivacyMargin(20,30)
                .setPrivacyOffsetY(30)//隐私条款Y偏移量
                .setPrivacyOffsetY_B(30);//隐私条款Y偏移
    }







}
