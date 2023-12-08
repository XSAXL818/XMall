package com.xsaxl.xnoteplus.api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.JsonParse;
import com.xsaxl.xnoteplus.Util.SSLAgent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * API:微博热搜
 */
public class ResouActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resou);
        Button button3 = findViewById(R.id.bt3);
        button3.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.bt3){
            Resou();
        }
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
                    for (int i=0;i<10;i++){
                        JSONObject jsonData = array.getJSONObject(i);
                        int num = jsonData.optInt("num");
                        String title = jsonData.optString("title");
                        String hot1 = jsonData.optString("hot");
                        String hot = hot1.substring(0,hot1.length()-1);
                        resoulist = resoulist+num+":"+title+"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+hot+"\n";

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