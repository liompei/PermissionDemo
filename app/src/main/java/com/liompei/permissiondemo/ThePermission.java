package com.liompei.permissiondemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BLM on 2016/6/27.
 */
public class ThePermission {
    private Activity activity;
    public static final int EXTERNAL_STORAGE_REQ_CODE = 10;

    public ThePermission(Activity activity) {
        this.activity = activity;
    }



    public void getOnePermission() {
        //判断当前版本是否大于M
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //判断当前Activity是否获得了该权限
            if (ContextCompat.checkSelfPermission(activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                //没有授权,判断权限申请是否曾经被拒绝过
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(activity, "你曾经拒绝过此权限,需要重新获取", Toast.LENGTH_SHORT).show();
                    //进行权限请求
                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            EXTERNAL_STORAGE_REQ_CODE);
                } else {
                    //进行权限请求
                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            EXTERNAL_STORAGE_REQ_CODE);
                }

            }


        }
    }

    List<String> list = new ArrayList<>();

    private boolean noCamera;
    private boolean noWrite;

    public void getAllPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            noCamera = (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED);
            noWrite = (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED);

            list.add(Manifest.permission.CAMERA);
            list.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (noCamera && noWrite) {
                //如果两个权限都没有
                Log.d("aaa", "两个权限都没有");
                ActivityCompat.requestPermissions(activity, list.toArray(new String[list.size()]), 10);
            } else if (noCamera && !noWrite) {
                //没有相机权限
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 20);
            } else if (!noCamera && noWrite) {
                //没有SD卡权限
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 30);
            } else if (!noCamera && !noWrite) {
                //都有  不用做任何操作
            }
        }
    }

    public void getArrayPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            noCamera = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED;
            noWrite = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED;
            if (noCamera){
                ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.CAMERA},50);
            }
            if (noWrite){
                ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},60);
            }


        }
    }


}
