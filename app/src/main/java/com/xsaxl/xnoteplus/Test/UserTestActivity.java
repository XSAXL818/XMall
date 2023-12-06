package com.xsaxl.xnoteplus.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xsaxl.xnoteplus.MyApplication;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.dao.UserDao;
import com.xsaxl.xnoteplus.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserTestActivity extends AppCompatActivity {
    private EditText user_test_acc;
    private EditText user_test_passwd;

    private Button user_test_insert;
    private Button user_test_delete;
    private Button user_test_update;
    private Button user_test_query;
    private TextView user_test_ret;
    private UserDao userDao;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_test);

        user_test_acc = findViewById(R.id.user_test_acc);
        user_test_passwd = findViewById(R.id.user_test_passwd);
        user_test_insert = findViewById(R.id.user_test_insert);
        user_test_delete = findViewById(R.id.user_test_delete);
        user_test_update = findViewById(R.id.user_test_update);
        user_test_query = findViewById(R.id.user_test_query);
        user_test_ret = findViewById(R.id.user_test_ret);

//        userList = new ArrayList<User>();

        userDao = MyApplication.getInstance().getXCartDatabase().getUserDao();

        User user = new User();
        user_test_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUser_acc(user_test_acc.getText().toString());
                user.setUser_passwd(user_test_passwd.getText().toString());
                userDao.insert(user);
            }
        });
        user_test_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userList = userDao.query();
                String all = "";
                for (User user : userList) {
                    all += user.toString() + "\n";
                }
                user_test_ret.setText(all);
            }
        });
    }
}