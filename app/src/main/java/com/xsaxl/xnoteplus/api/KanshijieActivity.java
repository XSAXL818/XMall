package com.xsaxl.xnoteplus.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.JsonParse;
import com.xsaxl.xnoteplus.Util.SSLAgent;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class KanshijieActivity extends AppCompatActivity implements View.OnClickListener{
    String url_gif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanshijie);
        Button bt = findViewById(R.id.bt7);
        bt.setOnClickListener(this);

    }
    public void onClick(View view) {
        if (view.getId() == R.id.bt7){
            Yuanshen();
            ImageView imageView = findViewById(R.id.image_kanshijie);
            Picasso.with(KanshijieActivity.this).load(url_gif).into(imageView);
        }
    }

    public void Yuanshen() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    URL url = new URL("https://api.andeer.top/API/face.php");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in = connection.getInputStream();
                    JsonParse jsonParse = new JsonParse();
                    String json = jsonParse.read(in);

                    JSONObject jsonObj = new JSONObject(json);
                    String data = jsonObj.optString("data");

                    JSONObject pic = new JSONObject(data);
                    url_gif = pic.optString("pic");

                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
}