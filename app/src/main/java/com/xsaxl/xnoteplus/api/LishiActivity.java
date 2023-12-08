package com.xsaxl.xnoteplus.api;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LishiActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lishi);
        Button bt = findViewById(R.id.bt5);
        bt.setOnClickListener(this);


    }
    public void onClick(View view) {
        if (view.getId() == R.id.bt5){
            Lishi();
        }
    }

    public void Lishi() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    URL url = new URL("https://api.andeer.top/API/history.php");
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
                        String l = array.getString(i);
                        resoulist = resoulist+(i+1)+": "+l+"\n\n";

                    }

                    TextView t2 = findViewById(R.id.tv_lishi);

                    t2.setText(resoulist);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
}