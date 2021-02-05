package com.submail.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.submail.onelogin.sdk.client.SubSDK;

public class CustomView extends RelativeLayout {
    private ImageView backView;

    public CustomView(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.cm_login_activity, this, true);
        backView = (ImageView) view.findViewById(R.id.back);
        backView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SubSDK.quitActivity(context);
            }
        });
    }

}


