package com.submail.sdk;


import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;


import com.submail.onelogin.sdk.client.SubCallback;
import com.submail.onelogin.sdk.client.SubSDK;

import com.submail.onelogin.sdk.utils.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.util.Locale;


public class MainActivity extends Activity {

}