package com.xsaxl.xnoteplus.Test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.Util;
import com.xsaxl.xnoteplus.entity.SpuAttr;

import java.util.ArrayList;
import java.util.List;

public class AlertDialogTestActivity extends AppCompatActivity {

    private Button button;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_test);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogTestActivity.this);
//
//                View view = View.inflate(AlertDialogTestActivity.this,R.layout.alert_layout,null);
//
                List<SpuAttr> data = new ArrayList<>();
                SpuAttr spuAttr = new SpuAttr();
                spuAttr.setSpu_attr_name("颜色");
                spuAttr.setSpu_attr_value("红色");
                data.add(spuAttr);
                spuAttr = new SpuAttr();
                spuAttr.setSpu_attr_name("尺寸");
                spuAttr.setSpu_attr_value("大");
                data.add(spuAttr);
//
//
//
//                recyclerView = view.findViewById(R.id.alert_recycler_view);
//                recyclerView.setAdapter(new AlertDialogTestAdapter(data));
//                GridLayoutManager gridLayoutManager = new GridLayoutManager(AlertDialogTestActivity.this, 1);
//                recyclerView.setLayoutManager(gridLayoutManager);
//
//
//                builder.setView(view);
//
//                builder.setPositiveButton("确定",null);
//                builder.show();

                Util.showProductParameterDialog(data,AlertDialogTestActivity.this);
            }

        });



    }
}