package com.xsaxl.xnoteplus.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.xsaxl.xnoteplus.MyApplication;
import com.xsaxl.xnoteplus.OrderHomeActivity;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Util.Util;
import com.xsaxl.xnoteplus.dao.UserDao;
import com.xsaxl.xnoteplus.entity.User;
import com.xsaxl.xnoteplus.inter.FragCallback3;

public class BlankFragment3 extends Fragment {

    private View root;
    private TextView textView2;
    private FragCallback3 fragCallback3;

    private Button order_button1;
    private Button order_button2;
    private Button order_button3;
    private Button order_button4;
    private Button order_button5;
    private Button order_button6;
    private TextView tv_info;
    private User user;
    private UserDao userDao;
    public void setFragCallback3(FragCallback3 iFragmentCallback) {
        this.fragCallback3= iFragmentCallback;
    }

    public BlankFragment3() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if( root == null ) {
            root = inflater.inflate(R.layout.fragment_blank3, container, false);
        }
        order_button1 = root.findViewById(R.id.order_button1);
        order_button2 = root.findViewById(R.id.order_button2);
        order_button3 = root.findViewById(R.id.order_button3);
        order_button4 = root.findViewById(R.id.order_button4);
        order_button5 = root.findViewById(R.id.order_button5);
        order_button6 = root.findViewById(R.id.order_button6);
        textView2 = root.findViewById(R.id.textView2);
        tv_info = root.findViewById(R.id.tv_info);
        userDao = MyApplication.getInstance().getXCartDatabase().getUserDao();

        user = MyApplication.getInstance().getUser();

//        user = userDao.queryUserById(1);

        textView2.setText("用户账号：\n"+user.getUser_acc());
        tv_info.setText("用户介绍：\n"+user.getUser_info());

        Intent intent = new Intent(getActivity(), OrderHomeActivity.class);
        Bundle bundle = new Bundle();


        order_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("select",1);
                startActivity(intent);
            }
        });
        order_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("select",2);
                startActivity(intent);
            }
        });
        order_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("select",3);
                startActivity(intent);
            }
        });
        order_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("select",4);
                startActivity(intent);
            }
        });
        order_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("select",5);
                startActivity(intent);
            }
        });

        order_button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("select",6);
                startActivity(intent);
            }
        });


        return root;
    }


}