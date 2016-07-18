package com.liompei.permissiondemo;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    ThePermission thePermission;

    public static final int EXTERNAL_STORAGE_REQ_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        thePermission = new ThePermission(this);
//        thePermission.getAllPermission();
        thePermission.getArrayPermission();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case EXTERNAL_STORAGE_REQ_CODE:
                // 如果请求被拒绝，那么通常grantResults数组为空
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.length > 0) {
                    //申请成功
                    Toast.makeText(MainActivity.this, "申请成功", Toast.LENGTH_SHORT).show();
                } else {
                    //申请失败,可以在这里做用户不授予权限的操作
                }
                break;
        }
    }

    //    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
////        Log.d("aaa", "requestCode: " + requestCode + "\npermissions: " + permissions[0] + permissions[1] + "  " + "\ngrantResult: " + grantResults[0] + grantResults[1]);
//        switch (requestCode) {
//            case 10:
//                //如果请求被拒绝,那么通常grantResults数组为空
//                boolean isA10 = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                boolean isB10 = grantResults[1] == PackageManager.PERMISSION_GRANTED;
//                if (grantResults.length > 0) {
//                    if (isA10 && isB10) {
//                        log("权限都获取了");
//                    } else if (isA10 && !isB10) {
//                        log("只有A获取了");
//                    } else if (!isA10 && isB10) {
//                        log("只有B获取了");
//                    } else if (!isA10 && !isB10) {
//                        log("都没有获取");
//                    }
//                }
//                break;
//            case 20:
//                boolean isA20 = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                if (grantResults.length > 0) {
//                    if (isA20) {
//                        log("取得了相机单一权限");
//                    } else {
//                        log("没有获取相机单一权限");
//                    }
//                }
//                break;
//            case 30:
//                boolean isB30 = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                if (isB30) {
//                    log("取得了内存卡权限");
//                } else {
//                    log("没有取得内存卡权限");
////                    new AlertDialog.Builder(this)
////                            .setTitle("警告")
////                            .setMessage("您没有给予软件所需权限,可能会导致部分功能无法使用,请在软件设置->app->郑州客运段中给予相应权限")
////                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
////                                @Override
////                                public void onClick(DialogInterface dialogInterface, int i) {
////                                    finish();
////                                }
////                            })
////                            .setNegativeButton("设置", new DialogInterface.OnClickListener() {
////                                @Override
////                                public void onClick(DialogInterface dialogInterface, int i) {
////
////                                }
////                            })
////                            .show();
//                }
//                break;
//        }


//    }
}
