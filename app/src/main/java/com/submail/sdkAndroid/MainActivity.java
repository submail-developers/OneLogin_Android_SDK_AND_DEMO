package com.submail.sdkAndroid;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.cmic.sso.sdk.AuthThemeConfig;
import com.submail.onelogin.sdk.client.SubCallback;
import com.submail.onelogin.sdk.client.SubSDK;
import com.submail.onelogin.sdk.ui.LoginPageConfig;
import com.submail.onelogin.sdk.utils.Logger;


public class MainActivity extends Activity {

    private Button bt, bt2, bt3, bt4;
    private Context mCtx;
    private static String appid = "";
    private static String appkey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        mCtx = this;

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubSDK.isShowLog(true);
                SubSDK.init(mCtx, appid, appkey, new SubCallback() {
                    @Override
                    public void onResult(boolean var1, final String var2) {
                        Logger.d("测试结果：", var1 + "，" + var2);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(mCtx, var2, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubSDK.getLoginAccessCode(mCtx, new SubCallback() {
                    @Override
                    public void onResult(boolean var1,final String var2) {
                        Logger.d("测试结果：", var1 + "，" + var2);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(mCtx, var2, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int netType=getNetworkType();
                if(netType==1){
                    AuthThemeConfig authThemeConfig=CmOneLoginViewConfig.initConfig(mCtx).build();
                    SubSDK.getLoginToken(mCtx, authThemeConfig,new SubCallback() {
                        @Override
                        public void onResult(boolean var1, final String var2) {
                            Logger.d("测试结果：", var1 + "，" + var2);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mCtx, var2, Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }else if(netType==2||netType==3){
                    LoginPageConfig loginPageConfig = OneLoginViewConfig.initXmlConfig(mCtx);
                    SubSDK.getLoginToken(mCtx, loginPageConfig,new SubCallback() {
                        @Override
                        public void onResult(boolean var1,final String var2) {
                            Logger.d("测试结果：", var1 + "，" + var2);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mCtx, var2, Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }else{
                    Logger.d("测试结果：","未知网络");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mCtx, "未知网络错误", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubSDK.getPhoneNumber(mCtx, new SubCallback() {
                    @Override
                    public void onResult(boolean var1,final String var2) {
                        Logger.d("测试结果：", var1 + "，" + var2);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(mCtx, var2, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });


    }

    //获取当前手机流量卡所属运营商网络 0-未知网络 1-移动 2-联通  3-电信
    public int getNetworkType(){
        return SubSDK.getNetworkType(mCtx);
    }

    //获取token后sdk不会关闭授权页，需要调用sdk中的方法关闭授权页
    public void quitLoginActivity(){
        SubSDK.quitActivity(mCtx);
    }




}