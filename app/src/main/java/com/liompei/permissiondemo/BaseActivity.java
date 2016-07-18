package com.liompei.permissiondemo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by BLM on 2016/6/27.
 */
public class BaseActivity extends AppCompatActivity {
    public void toast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    public void log(String msg) {
        Log.d("zzzzzzz", msg);
    }
}
