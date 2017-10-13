package com.ljt.testhandler;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

public static String TAG= ThirdActivity.class.getSimpleName();
    private Button btn;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btn = (Button) findViewById(R.id.btn_3);
        tv = (TextView) findViewById(R.id.tv_3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    private void update() {
        UpdateTask updateTask = new UpdateTask(this);
        updateTask.execute();
    }
        class UpdateTask extends AsyncTask<Void,Integer,Integer>{
            private Context mContext;
            UpdateTask(Context context){
                this.mContext=context;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                 Log.d(TAG,TAG+" ----->>>onPreExecute() ");

            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Log.d(TAG,TAG+" ----->>> onPostExecute() ");
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                 Log.d(TAG,TAG+" ----->>>onProgressUpdate() ");
                tv.setText(""+values[0]);
            }

            @Override
            protected Integer doInBackground(Void... params) {
                Log.d(TAG,TAG+" ----->>>doInBackground() ");
                int i=0;
                while(i<10){
                    i++;
                    publishProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                return null;
            }
    }
}
