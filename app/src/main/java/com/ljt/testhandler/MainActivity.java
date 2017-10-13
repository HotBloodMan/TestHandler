package com.ljt.testhandler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static String TAG= MainActivity.class.getSimpleName();
    private HandlerThread mHT;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //子线程
        mHT=new HandlerThread("h-t");
        mHT.start();
        handler=new Handler(mHT.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                 Log.d(TAG,TAG+" ----->>> "+"消息： " + msg.what + "  线程： " + Thread.currentThread().getName()  );
            }
        };
        //主线程给子线程发
        handler.sendEmptyMessage(1);
        //子线程给子线程发消息
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程给handler发送消息
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHT.quit();
    }
}
