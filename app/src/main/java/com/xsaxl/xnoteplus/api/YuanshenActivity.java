package com.xsaxl.xnoteplus.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.JsonParse;
import com.xsaxl.xnoteplus.Util.SSLAgent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class YuanshenActivity extends AppCompatActivity implements View.OnClickListener{
    public String url_pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuanshen);
        Button bt = findViewById(R.id.bt6);
        bt.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.bt6){
            Yuanshen();
            ImageView imageView = findViewById(R.id.image_yuanshen);
            Picasso.with(YuanshenActivity.this).load(url_pic).into(imageView);
        }
    }

    public void Yuanshen() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    URL url = new URL("https://api.andeer.top/API/op.php");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in = connection.getInputStream();
                    JsonParse jsonParse = new JsonParse();
                    String json = jsonParse.read(in);

                    JSONObject jsonObj = new JSONObject(json);
                    String data = jsonObj.optString("data");

                    JSONObject pic = new JSONObject(data);
                    url_pic = pic.optString("pic");

//                    ImageView imageView = findViewById(R.id.image_yuanshen);
//                    Picasso.with(YuanshenActivity.this).load(url_pic).into(imageView);

                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
}