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

public class XingzuoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xingzuo);
        Button bt = findViewById(R.id.bt4);
        bt.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.bt4){
            Xingzuo();
        }

    }

    public void Xingzuo() throws RuntimeException {

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    SSLAgent.getInstance().trustAllHttpsCertificates();
                    String xingzuo = "";
                    EditText et = findViewById(R.id.et_xingzuo);
                    xingzuo = et.getText().toString().substring(0,2);

                    URL url = new URL("https://api.andeer.top/API/yunshi.php?title="+xingzuo);
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in = connection.getInputStream();
                    JsonParse jsonParse = new JsonParse();
                    String json = jsonParse.read(in);

                    JSONObject jsonObj = new JSONObject(json);
                    String data = jsonObj.optString("data");
                    JSONObject jsonData = new JSONObject(data);

                    String xz = jsonData.optString("星座");
                    String ms = jsonData.optString("描述");
                    String ys = jsonData.optString("幸运颜色");
                    String sz = jsonData.optString("幸运数字");
                    String yi = jsonData.optString("宜");
                    String ji = jsonData.optString("忌");

                    String yunshi = jsonData.optString("今日运势");
                    JSONObject jsonYunshi = new JSONObject(yunshi);
                    String yshi = jsonYunshi.optString("综合运势");

                    TextView t1 = findViewById(R.id.tv_xingzuo);
                    String str = "星        座: "+xz+"座\n描        述: "+ms+"\n幸运颜色: "+ys+"\n幸运数字: "+sz+"\n     宜      : "+yi+"\n     忌      : "+ji;
                    str = str+"\n\n今日运势: \n        "+yshi;
                    t1.setText(str);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        }).start();
    }
}