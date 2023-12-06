package com.xsaxl.xnoteplus.Util;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Test.AlertDialogTestActivity;
import com.xsaxl.xnoteplus.Test.AlertDialogTestAdapter;
import com.xsaxl.xnoteplus.entity.SpuAttr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Util {
    public static void showToast(Context context, String msg){
//        Toast toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        Toast toast = new Toast(context.getApplicationContext());
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
//        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }


    //返回一个系统当前时间
    public static String getSystemTime(){
        return DateFormat.format("yyyy-MM-dd HH:mm:ss", new Date()).toString();
    }

    // 传入SpuAttr的List，显示商品参数的对话框，同时传入上下文
    public static void showProductParameterDialog(List<SpuAttr> data, Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder( context );

        View view = View.inflate(context, R.layout.alert_layout,null);
        RecyclerView recyclerView = view.findViewById(R.id.alert_recycler_view);

        recyclerView = view.findViewById(R.id.alert_recycler_view);
        recyclerView.setAdapter(new AlertDialogTestAdapter(data));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


        builder.setView(view);

        builder.setPositiveButton("确定",null);
        builder.show();
    }

}
