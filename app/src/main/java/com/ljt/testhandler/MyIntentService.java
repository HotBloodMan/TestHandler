package com.ljt.testhandler;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public static String TAG= MyIntentService.class.getSimpleName();
    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    public void onCreate() {
        super.onCreate();
         Log.d(TAG,TAG+" ----->>>onCreate() ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         Log.d(TAG,TAG+" ----->>>onStartCommand() ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG,TAG+" ----->>>onHandleIntent() "+Thread.currentThread().getName() + "--" + intent.getStringExtra("info") );
        for(int i = 0; i < 100; i++){ //耗时操作
            Log.i("onHandleIntent--",  i + "--" + Thread.currentThread().getName());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
         Log.d(TAG,TAG+" ----->>>onDestroy() ");
    }
}
