package com.xsaxl.xnoteplus.api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.JsonParse;
import com.xsaxl.xnoteplus.Util.SSLAgent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * API:微博热搜
 */
public class ResouActivity extends AppCompatActivity implements View.OnClickListener{

    String title;
    String hot;
    int num;
    JSONArray array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resou);
        Button button3 = findViewById(R.id.bt3);
        button3.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.bt3) {
            Resou();
            if(array !=null){
                TextView tv0 = findViewById(R.id.resou0);
                TextView tv00 = findViewById(R.id.resou00);
                TextView tv1 = findViewById(R.id.resou1);
                TextView tv11 = findViewById(R.id.resou11);
                TextView tv2 = findViewById(R.id.resou2);
                TextView tv22 = findViewById(R.id.resou22);
                TextView tv3 = findViewById(R.id.resou3);
                TextView tv33 = findViewById(R.id.resou33);
                TextView tv4 = findViewById(R.id.resou4);
                TextView tv44 = findViewById(R.id.resou44);
                TextView tv5 = findViewById(R.id.resou5);
                TextView tv55 = findViewById(R.id.resou55);
                TextView tv6 = findViewById(R.id.resou6);
                TextView tv66 = findViewById(R.id.resou66);
                TextView tv7 = findViewById(R.id.resou7);
                TextView tv77 = findViewById(R.id.resou77);
                TextView tv8 = findViewById(R.id.resou8);
                TextView tv88 = findViewById(R.id.resou88);
                TextView tv9 = findViewById(R.id.resou9);
                TextView tv99 = findViewById(R.id.resou99);

                for (int i = 0; i < 10; i++) {

                    try {
                        JSONObject jsonData = array.getJSONObject(i);
                        num = jsonData.optInt("num");
                        title = num + ": " + jsonData.optString("title");
                        String hot1 = jsonData.optString("hot");
                        hot = "热度： " + hot1.substring(0, hot1.length() - 1);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    switch (i) {
                        case 0:
                            tv0.setText(title);
                            tv00.setText(hot);
                        case 1:
                            tv1.setText(title);
                            tv11.setText(hot);
                        case 2:
                            tv2.setText(title);
                            tv22.setText(hot);
                        case 3:
                            tv3.setText(title);
                            tv33.setText(hot);
                        case 4:
                            tv4.setText(title);
                            tv44.setText(hot);
                        case 5:
                            tv5.setText(title);
                            tv55.setText(hot);
                        case 6:
                            tv6.setText(title);
                            tv66.setText(hot);
                        case 7:
                            tv7.setText(title);
                            tv77.setText(hot);
                        case 8:
                            tv8.setText(title);
                            tv88.setText(hot);
                        case 9:
                            tv9.setText(title);
                            tv99.setText(hot);

                    }
                }
            }

        }
    }

    public void Resou(){

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
                    array = new JSONArray(data);


//                        resoulist = resoulist+num+":"+title+"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+hot+"\n";
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
}