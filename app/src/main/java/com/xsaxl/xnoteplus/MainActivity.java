package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.xsaxl.xnoteplus.dao.UserDao;
import com.xsaxl.xnoteplus.entity.User;



public class MainActivity extends AppCompatActivity {

    private Button loginEnsure;
    private Button loginCancel;
    private TextView inputAcc;
    private TextView inputPasswd;
    private SharedPreferences preferences;
    private CheckBox rememberCheck;
    private CheckBox autoLogin;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        loginEnsure = findViewById(R.id.login_ensure);
        loginCancel = findViewById(R.id.login_cancel);
        inputAcc = findViewById(R.id.input_acc);
        inputPasswd = findViewById(R.id.input_passwd);
        rememberCheck = findViewById(R.id.remember);
        autoLogin = findViewById(R.id.auto_login);
        // 获取数据库操作对象
        userDao = MyApplication.getInstance().getXCartDatabase().getUserDao();


        // 配置信息
       // 获取SharedPreferences对象，用于完成记住密码和自动登录功能
        preferences = getSharedPreferences("login", MODE_PRIVATE);
        // 启动意图
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);

        // 勾选过自动登录
        if( preferences.getBoolean("autoLogin",false) ){
            Bundle bundle = new Bundle();
            bundle.putString("user_acc",preferences.getString("acc",""));
            bundle.putInt("user_id",1);
            intent.putExtras(bundle);

            User user = userDao.queryUserById(1);

            MyApplication.getInstance().setUser(user);

            startActivity(intent);


            finish();
        }
        // 设置点击事件,取消后直接退出应用
        loginCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 加载用户信息
        reload();// 判断是否有登录历史,有的话加载信息
        // 点击登录
        loginEnsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 如果不满11位
                if( inputAcc.getText().toString().length() != 11 ){
                    Toast.makeText(MainActivity.this,"请输入11位手机号码",Toast.LENGTH_SHORT).show();
                    return;
                }
                // 如果密码为空
                if( inputPasswd.getText().toString().equals("") ){
                    Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                // 获取账号在数据库中的密码
                User user = userDao.queryUserByAcc(inputAcc.getText().toString());
                // 如果密码不正确
                if( !user.getUser_passwd().equals(inputPasswd.getText().toString()) ){
                    Toast.makeText(MainActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                    return;
                }

                // 登录成功
                // 如果勾选了记住密码，将账号密码存入SharedPreferences
                if( rememberCheck.isChecked() ){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("acc",inputAcc.getText().toString());
                    editor.putString("passwd",inputPasswd.getText().toString());
                    editor.putBoolean("isRemember",rememberCheck.isChecked());
                    editor.putBoolean("autoLogin",autoLogin.isChecked());
                    editor.commit();

                }

                // 将账号即该账号的user_id传入下一个页面,便于获取用户信息等其他操作
                Bundle bundle = new Bundle();
//                bundle.putString("user_acc",inputAcc.getText().toString());
                bundle.putInt("user_id",user.getUser_id());
//                bundle.putString("passwd",inputPasswd.getText().toString());
                intent.putExtras(bundle);
                MyApplication.getInstance().setUser(user);
                startActivity(intent);
                finish();
            }
        });

        // 给inputAcc添加文本变更监听器，当输入11位手机号码后，收回键盘
        inputAcc.addTextChangedListener(new TextWatcher() {
            // 文本变更前
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            // 文本变更中
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 获取输入的手机号码
                String acc = s.toString();
                // 判断手机号码是否为11位
                if( acc.length() == 11 ){
                    // 关闭输入键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputAcc.getWindowToken(),0);

                }
            }
            // 文本变更后
            @Override
            public void afterTextChanged(Editable s) {
                if ( s.length() != 11 ){
                    rememberCheck.setChecked(false);
                    autoLogin.setChecked(false);
                    // 红色边框警告
                    inputAcc.setBackgroundResource(R.drawable.input_error);
                }else{
                    // 绿色边框
                    inputAcc.setBackgroundResource(R.drawable.input_normal);
                }

            }
        });
    }

    private void reload(){
        boolean remember = preferences.getBoolean("isRemember",false);
        if( remember ){
            String acc = preferences.getString("acc","");
            String passwd = preferences.getString("passwd","");
            inputAcc.setText(acc);
            inputPasswd.setText(passwd);
            rememberCheck.setChecked(true);
        }

    }


}