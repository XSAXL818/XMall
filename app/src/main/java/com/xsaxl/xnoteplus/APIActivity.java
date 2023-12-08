package com.xsaxl.xnoteplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
        Button bt11 = findViewById(R.id.bt_shuashipin);
    }

}