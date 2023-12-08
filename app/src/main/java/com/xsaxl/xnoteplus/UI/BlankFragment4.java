package com.xsaxl.xnoteplus.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xsaxl.xnoteplus.APIActivity;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.api.FkxqsActivity;
import com.xsaxl.xnoteplus.api.KanshijieActivity;
import com.xsaxl.xnoteplus.api.LishiActivity;
import com.xsaxl.xnoteplus.api.ResouActivity;
import com.xsaxl.xnoteplus.api.TianqiActivity;
import com.xsaxl.xnoteplus.api.XingzuoActivity;
import com.xsaxl.xnoteplus.api.YuanshenActivity;
import com.xsaxl.xnoteplus.api.YuluActivity;

public class BlankFragment4 extends Fragment {


    private View root;
    public BlankFragment4() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if( root == null ) {
            root = inflater.inflate(R.layout.activity_api, container, false);
        }

        Button bt = root.findViewById(R.id.bt_yulu);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), YuluActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });
        Button bt2 = root.findViewById(R.id.bt_resou);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), ResouActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt3 = root.findViewById(R.id.bt_xingzuo);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), XingzuoActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt4 = root.findViewById(R.id.bt_lishi);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), LishiActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt7 = root.findViewById(R.id.bt_yuanshen);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), YuanshenActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt6 = root.findViewById(R.id.bt_kanshijie);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), KanshijieActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt8 = root.findViewById(R.id.bt_fkxqs);
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), FkxqsActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });

        Button bt5 = root.findViewById(R.id.bt_tianqi);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), TianqiActivity.class);
                intent.putExtra("aa","bb");
                startActivity(intent);
            }
        });



        // Inflate the layout for this fragment
        return root;
    }
}