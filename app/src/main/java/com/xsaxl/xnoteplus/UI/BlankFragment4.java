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
import com.xsaxl.xnoteplus.ResouActivity;
import com.xsaxl.xnoteplus.YuluActivity;

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
        Button bt11 = root.findViewById(R.id.bt_shuashipin);


        // Inflate the layout for this fragment
        return root;
    }
}