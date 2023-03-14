package com.submail.sdk;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;

import com.cmic.gen.sdk.view.AuthLoginCallBack;
import com.cmic.gen.sdk.view.GenAuthLoginListener;
import com.cmic.gen.sdk.view.GenAuthThemeConfig;
import com.cmic.gen.sdk.view.GenBackPressedListener;
import com.cmic.gen.sdk.view.GenCheckBoxListener;
import com.cmic.gen.sdk.view.GenCheckedChangeListener;
import com.cmic.gen.sdk.view.GenLoginClickListener;
import com.submail.sdk.R;


import org.json.JSONObject;

//由于中国移动授权页依赖中国移动sdk内置的授权页，需要单独配置中国移动授权页
public class CmOneLoginViewConfig {
    Dialog alertDialog;

    public static GenAuthThemeConfig.Builder initConfig(final Context ctx) {


        return new GenAuthThemeConfig.Builder()
                .setStatusBar(0xffffffff,true)//状态栏颜色、字体颜色
                .setFitsSystemWindows(true)
//                .setAuthContentView(getLayoutInflater().inflate(R.layout.empty_layout,relativeLayout,false))
                .setAuthLayoutResID(R.layout.cm_login_activity)
                .setClauseLayoutResID(R.layout.title_layout,"returnId")
                .setNavTextSize(20)
                .setNavTextColor(0xffffffff)//导航栏字体颜色
                .setNavColor(Color.RED)
                .setNumberSize(30,false)////手机号码字体大小
                .setNumberColor(0xff333333)//手机号码字体颜色
                .setNumberOffsetX(100)//号码栏X偏移量
                .setNumFieldOffsetY_B(100)
                .setNumFieldOffsetY(250)//号码栏Y偏移量

                .setLogBtnText("本机号码一键登录")//登录按钮文本
                .setLogBtnTextColor(0xffffffff)//登录按钮文本颜色
                .setLogBtnImgPath("umcsdk_login_btn_bg")//登录按钮背景
                .setLogBtnText(" ",0xffffffff,16,false)
                .setLogBtnOffsetY_B(400)//登录按钮Y偏移量
                .setLogBtnOffsetY(400)//登录按钮Y偏移量
//                .setLogBtn(500,30)
                .setLogBtnMargin(30,30)
                .setCheckTipText("请勾选协议")
                .setGenBackPressedListener(new GenBackPressedListener() {
                    @Override
                    public void onBackPressed() {
                        Toast.makeText(ctx,"返回键回调", Toast.LENGTH_SHORT).show();
                    }
                })
                .setLogBtnClickListener(new GenLoginClickListener() {
                    @Override
                    public void onLoginClickStart(Context context, JSONObject jsonObj) {

                    }

                    @Override
                    public void onLoginClickComplete(Context context, JSONObject jsonObj) {

                    }
                })
                .setGenAuthLoginListener(new GenAuthLoginListener() {
                    @Override
                    public void onAuthLoginListener(Context context, AuthLoginCallBack authLoginCallBack) {
                    }
                })

                .setGenCheckBoxListener(new GenCheckBoxListener() {
                    @Override
                    public void onLoginClick(Context context, JSONObject jsonObj) {
                        Toast.makeText(context,"自定义勾选提示", Toast.LENGTH_LONG).show();
                    }
                })
                .setGenCheckedChangeListener(new GenCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(boolean b) {
                        Log.d("是否勾选协议",b+"");
                    }
                })

                .setCheckedImgPath("umcsdk_check_image")//checkbox被勾选图片
                .setUncheckedImgPath("umcsdk_uncheck_image")//checkbox未被勾选图片
                .setCheckBoxImgPath("umcsdk_check_image","umcsdk_uncheck_image",9,9)
                .setPrivacyState(false)//授权页check

                .setPrivacyAlignment("登录即同意" + GenAuthThemeConfig.PLACEHOLDER + "应用自定义服务条款一、应用自定义服务条款二、条款3和条款4并使用本机号码校验","应用自定义服务条款一","https://www.baidu.com","应用自定义服务条款二","https://www.hao123.com",
                        "条款3","http://www.sina.com","条款4","http://gz.58.com")
                .setPrivacyText(10,0xff666666,0xff0085d0,false, true)
                .setClauseColor(0xff666666,0xff0085d0)//条款颜色

                .setPrivacyMargin(50,50)
                .setPrivacyOffsetY(30)//隐私条款Y偏移量
                .setPrivacyOffsetY_B(40)//隐私条款Y偏移量
                .setCheckBoxLocation(0)
                .setAppLanguageType(0)
                .setBackButton(true)
                .setWebDomStorage(true)
                .setPrivacyAnimation("umcsdk_anim_shake")
                .setPrivacyBookSymbol(true);

//                .setAuthPageActIn("in_activity","out_activity")
//                .setAuthPageActOut("in_activity","out_activity")

//                .setAuthPageWindowMode(300, 300)
//                .setAuthPageWindowOffset(0,0)
//                .setThemeId(R.style.loginDialog);
//                .setWindowBottom(1)

    }


}
