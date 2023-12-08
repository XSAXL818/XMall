package com.xsaxl.xnoteplus.api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.JsonParse;
import com.xsaxl.xnoteplus.Util.SSLAgent;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * API:中英语录
 * API:答案之书
 */
public class YuluActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yulu);

//        JsonParse jsonParse = new JsonParse();
        Button button = findViewById(R.id.bt1);
        button.setOnClickListener(this);
        Button button2 = findViewById(R.id.bt2);
        button2.setOnClickListener(this);

    }


    public void onClick(View view) {
        if(view.getId() == R.id.bt1){
            Answer();
        }else if (view.getId() == R.id.bt2){
            Content();
        }else if (view.getId() == R.id.bt3){
            Resou();
        }

    }

    public void Answer() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    URL url = new URL("https://api.andeer.top/API/answer.php");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in = connection.getInputStream();
                    JsonParse jsonParse = new JsonParse();
                    String json = jsonParse.read(in);

                    JSONObject jsonObj = new JSONObject(json);
                    String data = jsonObj.optString("data");
                    JSONObject jsonData = new JSONObject(data);
                    String zh = jsonData.optString("zh");

                    String en = jsonData.optString("en");
                    TextView t1 = findViewById(R.id.zh);
                    TextView t2 = findViewById(R.id.en);

                    t2.setText(en);
                    t1.setText(zh);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }

    public void Content() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    URL url = new URL("https://api.andeer.top/API/word_en_ch.php");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in = connection.getInputStream();
                    JsonParse jsonParse = new JsonParse();
                    String json = jsonParse.read(in);

                    JSONObject jsonObj = new JSONObject(json);
                    String data = jsonObj.optString("content");
                    JSONObject jsonData = new JSONObject(data);
                    String zh = jsonData.optString("ch");

                    String en = jsonData.optString("en");
                    TextView t1 = findViewById(R.id.tv21);
                    TextView t2 = findViewById(R.id.tv22);

                    t2.setText(en);
                    t1.setText(zh);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
    public void Resou() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    URL url = new URL("https://api.andeer.top/API/hot_wb.php");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in = connection.getInputStream();
                    JsonParse jsonParse = new JsonParse();
                    String json = jsonParse.read(in);

                    JSONObject jsonObj = new JSONObject(json);
                    String data = jsonObj.optString("data");

                    String resoulist="";
                    JSONArray array = new JSONArray(data);
                    for (int i=0;i<array.length();i++){
                        JSONObject jsonData = array.getJSONObject(i);
                        int num = jsonData.optInt("num");
                        String title = jsonData.optString("title");
                        resoulist = resoulist+num+":"+title+"\n";

                    }

                    TextView t2 = findViewById(R.id.tv31);

                    t2.setText(resoulist);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
}