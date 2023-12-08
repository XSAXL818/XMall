package com.xsaxl.xnoteplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.xsaxl.xnoteplus.api.LishiActivity;
import com.xsaxl.xnoteplus.api.ResouActivity;
import com.xsaxl.xnoteplus.api.XingzuoActivity;
import com.xsaxl.xnoteplus.api.YuluActivity;

/**
 * API合集
 * 用于调用对应api
 */
public class APIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        Button bt = findViewById(R.id.bt_yulu);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(APIActivity.this, YuluActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });
        Button bt2 = findViewById(R.id.bt_resou);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(APIActivity.this, ResouActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt3 = findViewById(R.id.bt_xingzuo);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(APIActivity.this, XingzuoActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt4 = findViewById(R.id.bt_lishi);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(APIActivity.this, LishiActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

    }

}