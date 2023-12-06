package com.xsaxl.xnoteplus;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xsaxl.xnoteplus.UI.BlankFragment1;
import com.xsaxl.xnoteplus.UI.BlankFragment2;
import com.xsaxl.xnoteplus.UI.BlankFragment3;
import com.xsaxl.xnoteplus.dao.UserDao;
import com.xsaxl.xnoteplus.entity.User;
import com.xsaxl.xnoteplus.inter.FragCallback1;


public class HomeActivity extends AppCompatActivity {

    private int user_id;//用户id
    private User user;//用户
    private UserDao userDao;

    private BlankFragment1 blankFragment1;
    private BlankFragment2 blankFragment2;
    private BlankFragment3 blankFragment3;

    private RadioButton button1;
    private Button button2;
    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setChecked(true);


        blankFragment1 = new BlankFragment1();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();

        userDao = MyApplication.getInstance().getXCartDatabase().getUserDao();


        // 获取登录界面传入的用户ID
        user_id = getIntent().getIntExtra("user_id", 0);
        // 通过id获取用户的全部信息
        user = userDao.queryUserById(user_id);

        // 为fragment设置回调接口，用于fragment向activity传递数据
        blankFragment1.setFragCallback1(new FragCallback1() {
            @Override
            public void sendMsgToActivity(String msg) {
                //这里可以拿到fragment传过来的值
                Toast.makeText(HomeActivity.this, msg, Toast.LENGTH_SHORT).show();

            }
            @Override
            public String getMsgFromActivity(String str) {
                Toast.makeText(HomeActivity.this, "activity收到："+str, Toast.LENGTH_SHORT).show();
                String msg = "整数数据:1,2,3,4";
                return msg;
            }
        });

        replaceFragment(blankFragment1);

        button1.setOnClickListener(v -> {
            replaceFragment(blankFragment1);

        });

        button2.setOnClickListener(v -> {
            replaceFragment(blankFragment2);
        });

        button3.setOnClickListener(v -> {
            replaceFragment(blankFragment3);
        });








    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}