package com.mht.app;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import android.app.Activity;  
import android.text.TextUtils;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

import java.util.HashMap;
import java.util.Map;

public class MyNativeModule extends ReactContextBaseJavaModule {

        private ReactApplicationContext reactContext;

        public MyNativeModule(ReactApplicationContext reactContext) {
            super(reactContext);
            this.reactContext = reactContext;
        } 
        @Override
        public String getName() {
            //返回的这个名字是必须的，在rn代码中需要这个名字来调用该类的方法。
            return "MyNativeModule";
        }
        //函数不能有返回值，因为被调用的原生代码是异步的，原生代码执行结束之后只能通过回调函数或者发送信息给rn那边。
        @ReactMethod
            public void rnCallNative(String msg, Callback callback) {  
            Toast.makeText(reactContext, msg, Toast.LENGTH_SHORT).show();
            callback.invoke("来自原生模块的回调数据");
        }
        @ReactMethod
        public void startActivityByString(String activityName, String title) {
            try {
                Activity currentActivity = getCurrentActivity();
                if (null != currentActivity) {

                    Class aimActivity = Class.forName(activityName);
                    Intent intent = new Intent(currentActivity, aimActivity);
                    intent.putExtra("title", title);
                    currentActivity.startActivity(intent);

                }
            } catch (Exception e) {
                throw new JSApplicationIllegalArgumentException(
                        "Could not open the activity : " + e.getMessage());
            }
        }
        @ReactMethod
        public void getDataFromIntent(Callback successBack, Callback errorBack) {
            try {
                Activity currentActivity = getCurrentActivity();
               // Toast.makeText(currentActivity, currentActivity.getClass().getName(), Toast.LENGTH_SHORT).show();
                String result = currentActivity.getIntent().getStringExtra("result");
                if (TextUtils.isEmpty(result)) {
                    result = "No Data";
                }
                successBack.invoke(result);
            } catch (Exception e) {
                errorBack.invoke(e.getMessage());
            }
        }
}