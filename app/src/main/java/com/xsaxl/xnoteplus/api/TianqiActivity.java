package com.xsaxl.xnoteplus.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.JsonParse;
import com.xsaxl.xnoteplus.Util.SSLAgent;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class TianqiActivity extends AppCompatActivity implements View.OnClickListener{
    String city;
    String date;
    String wendu;
    String tianqi;
    String wind;
    String zhiliang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianqi);
        Button bt = findViewById(R.id.bt9);
        bt.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.bt9){

            Tianqi();
            TextView t1 = findViewById(R.id.tv_city);
            TextView t2 = findViewById(R.id.tv_date);
            TextView t3 = findViewById(R.id.tv_wendu);
            TextView t4 = findViewById(R.id.tv_tianqi);
            TextView t5 = findViewById(R.id.tv_wind);
            TextView t6 = findViewById(R.id.tv_zhiliang);
            t1.setText(city);
            t2.setText(date);
            t3.setText(wendu);
            t4.setText(tianqi);
            t5.setText(wind);
            t6.setText(zhiliang);
        }
    }

    public void Tianqi() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    EditText et = findViewById(R.id.et_tianqi);
                    String city1 = et.getText().toString();
                    URL url = new URL("https://api.andeer.top/API/daygas.php?msg="+city1+"&b=1");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in = connection.getInputStream();
                    JsonParse jsonParse = new JsonParse();
                    String json = jsonParse.read(in);

                    JSONObject jsonObj = new JSONObject(json);
                    String data = jsonObj.optString("data");
                    JSONObject jsonData = new JSONObject(data);

                    city = jsonData.optString("城市");
                    date = jsonData.optString("日期");
                    wendu = jsonData.optString("温度");
                    tianqi = jsonData.optString("天气");
                    wind = jsonData.optString("风度");
                    zhiliang = jsonData.optString("空气质量");



                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
}