package com.ljt.testhandler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    public static String TAG=SecondActivity .class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,TAG+" ----->>>onClick() ");
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("info", "good good study");
        startService(intent);
    }
}
