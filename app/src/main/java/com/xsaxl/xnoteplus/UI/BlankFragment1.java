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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.Adapter.SpuAdapter;
import com.xsaxl.xnoteplus.GoodDetailActivity;
import com.xsaxl.xnoteplus.MyApplication;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.SearchActivity;
import com.xsaxl.xnoteplus.Util.GridSpacingItemDecoration;
import com.xsaxl.xnoteplus.dao.SpuDao;
import com.xsaxl.xnoteplus.entity.Spu;
import com.xsaxl.xnoteplus.inter.Frag1SenHome;
import com.xsaxl.xnoteplus.inter.FragCallback1;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment1 extends Fragment {

    private View root;
    private FragCallback1 fragCallback1;
    private List<Spu> spus;
    private RecyclerView good_recyclerView;
    private TextView frag1_et;
    private Button frag1_button;
    private int user_id;//用户id
    private String user_name;//用户名
    private SpuDao spuDao;
    private Frag1SenHome frag1SenHome;// 用于
    int cnt = 0;


    public void setFragCallback1(FragCallback1 iFragmentCallback) {
        this.fragCallback1 = iFragmentCallback;
    }

    public BlankFragment1() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null){
            root = inflater.inflate(R.layout.fragment_blank1, container, false);
        }
        spuDao = MyApplication.getInstance().getXCartDatabase().getSpuDao();

        spus = new ArrayList<>();

        spus = spuDao.query();

//        Spu good1 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good2 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good3 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good4 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good5 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good6 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good7 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good8 = new Spu("小米10", 3999, R.drawable.laoshu);
//        good1.setSpu_id(1);
//        good2.setSpu_id(2);
//        good3.setSpu_id(3);
//        good4.setSpu_id(4);
//
//        spus.add(good1);
//        spus.add(good2);
//        spus.add(good3);
//        spus.add(good4);
//        spus.add(good5);
//        spus.add(good6);
//        spus.add(good7);
//        spus.add(good8);






        good_recyclerView = root.findViewById(R.id.frag1_recyclerView);
        frag1_et = root.findViewById(R.id.frag1_et);
        frag1_button = root.findViewById(R.id.frag1_button);

        SpuAdapter goodAdapter = new SpuAdapter(spus, getContext());
        good_recyclerView.setAdapter(goodAdapter);
        int spacing = 1;
        if( cnt == 0 ){
            cnt = 1;
            spacing = (int) getResources().getDisplayMetrics().density * 10;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(root.getContext(), 2);
        good_recyclerView.setLayoutManager(gridLayoutManager);
        good_recyclerView.addItemDecoration(new GridSpacingItemDecoration(spacing));


        goodAdapter.setOnItemClickListener(new SpuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(root.getContext(), "sku " + spus.get(position).getSpu_id(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(root.getContext(), GoodDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("spu_id", spus.get(position).getSpu_id());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



        frag1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        frag1_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}