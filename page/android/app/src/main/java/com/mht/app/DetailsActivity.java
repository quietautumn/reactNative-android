package com.mht.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;

import android.app.Activity;  
import android.view.View;  
import android.widget.Button;  
import android.widget.EditText;  

import com.facebook.react.bridge.Arguments;  
import com.facebook.react.bridge.ReactContext;  
import com.facebook.react.bridge.WritableMap;  
import com.facebook.react.modules.core.DeviceEventManagerModule;  

/*
 * 项目名:    InteractsWithAndroid
 * 包名       com.interactswithandroid
 * 文件名:    DetailsActivity
 * 创建者:    ZSY
 * 创建时间:  2017/10/15 on 22:07
 * 描述:     TODO
 */
public class DetailsActivity extends AppCompatActivity {
    EditText Ev1;    //定义上下文对象  
    public static ReactContext myContext;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.details_activity);
  
        Ev1 = (EditText)findViewById(R.id.editText1);    
  
        //第一种方式    
        Button Btn1 = (Button)findViewById(R.id.button1);//获取按钮资源    
        Btn1.setOnClickListener(new Button.OnClickListener(){//创建监听    
            public void onClick(View v) {    
                String strTmp = "点击Button01";    
                Ev1.setText(strTmp);    
            } 
        });    
  
        //第二种方式    
       // Button Btn2 = (Button) findViewById(R.id.button2);//获取按钮资源
       // Btn2.setOnClickListener(listener);//设置监听
  
    }  
  
    /*Button.OnClickListener listener = new Button.OnClickListener(){//创建监听对象
        public void onClick(View v){     
           // Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
            Intent intent = new Intent(DetailsActivity.this, ActivityMain.class);
            intent.putExtra("result", "Home");
            startActivity(intent);
            finish();
        }    
  
    };  */
  
  
    //第三种方式(Android1.6版本及以后的版本中提供了)    
    public void Btn3OnClick(View view){    
        //String strTmp="点击Button03";  
        //Ev1.setText(strTmp);  
        Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
        intent.putExtra("result", "Home");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); 
        startActivity(intent);
        //finish(); 
    }    
}
