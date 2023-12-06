package com.xsaxl.xnoteplus.Util;

import android.content.Context;
import android.content.DialogInterface;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.Date;

public class Util {
    public static void showToast(Context context, String msg){
//        Toast toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        Toast toast = new Toast(context.getApplicationContext());
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
//        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }
    public static void showDeleteNoteDialog( Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("删除确认");
        builder.setMessage("确认删除所选的1条笔记吗？");
        builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 删除成功的Toast
                Toast toast = Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT);
                // 弹出的Toast不要带图标
                toast.setText("删除成功");

                toast.show();

            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();
    }

    //返回一个系统当前时间
    public static String getSystemTime(){
        return DateFormat.format("yyyy-MM-dd HH:mm:ss", new Date()).toString();
    }

}
