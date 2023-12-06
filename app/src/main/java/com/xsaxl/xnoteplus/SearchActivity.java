package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xsaxl.xnoteplus.Adapter.SpuAdapter;
import com.xsaxl.xnoteplus.Util.GridSpacingItemDecoration;
import com.xsaxl.xnoteplus.dao.SpuAttrDao;
import com.xsaxl.xnoteplus.dao.SpuDao;
import com.xsaxl.xnoteplus.entity.Spu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SearchActivity extends AppCompatActivity {


    private Button search_back;
    private EditText search_input;
    private Button search_ensure;
    private Button search_store;
    private Button search_class1;
    private Button search_class2;
    private Button search_class3;
    private Button search_all;
    private RecyclerView search_recyclerView;
    private List<Spu> spus;
    private SpuDao spuDao;
    private SpuAttrDao spuAttrDao;
    private int reverse = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_back = findViewById(R.id.search_back);
        search_input = findViewById(R.id.search_input);
        search_ensure = findViewById(R.id.search_ensure);
        search_store = findViewById(R.id.search_store);
        search_class1 = findViewById(R.id.search_class1);
        search_class2 = findViewById(R.id.search_class2);
        search_class3 = findViewById(R.id.search_class3);
        search_recyclerView = findViewById(R.id.search_recyclerView);
        search_all = findViewById(R.id.search_all);

        spuDao = MyApplication.getInstance().getXCartDatabase().getSpuDao();
        spuAttrDao = MyApplication.getInstance().getXCartDatabase().getSpuAttrDao();

        spus = new ArrayList<Spu>();

        spus = spuDao.query();

//        Spu good1 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good2 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good3 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good4 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good5 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good6 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good7 = new Spu("小米10", 3999, R.drawable.laoshu);
//        Spu good8 = new Spu("小米10", 3999, R.drawable.laoshu);
//
//        goods.add(good1);
//        goods.add(good2);
//        goods.add(good3);
//        goods.add(good4);
//        goods.add(good5);
//        goods.add(good6);
//        goods.add(good7);
//        goods.add(good8);



        SpuAdapter goodAdapter = new SpuAdapter(spus, this);
        search_recyclerView.setAdapter(goodAdapter);
        int spacing = (int) getResources().getDisplayMetrics().density * 10;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        search_recyclerView.setLayoutManager(gridLayoutManager);
        search_recyclerView.addItemDecoration(new GridSpacingItemDecoration(spacing));

        goodAdapter.setOnItemClickListener(new SpuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText( SearchActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SearchActivity.this, GoodDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("spu_id",spus.get(position).getSpu_id());
                bundle.putString("spu_name",spus.get(position).getSpu_name());
                bundle.putDouble("spu_price",spus.get(position).getSpu_price());
                bundle.putInt("spu_sales",spus.get(position).getSpu_sales());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        search_ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取出搜索内容
                String spu_name = search_input.getText().toString();
                // 检索List
//                spus = spuDao.querySpuByName(spu_name);
                List<Spu> data = new ArrayList<>();
//                data = spuDao.querySpuById(1);
                spus.clear();
                spus.addAll(spuDao.querySpuByName(spu_name));
                spus.add(spuDao.querySpuById(1));
//                Toast.makeText(SearchActivity.this, spu_name, Toast.LENGTH_SHORT).show();
                // 显示搜索结果
                search_recyclerView.getAdapter().notifyDataSetChanged();
//                goodAdapter.notifyDataSetChanged();

            }
        });

        search_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spus.clear();
                spus.addAll(spuDao.query());
                search_recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        search_class2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(spus,Collections.reverseOrder());

                if( reverse == 0 ){
                    Collections.reverse(spus);
                    reverse = 1;
                } else {
                    reverse = 0;
                }

                search_recyclerView.getAdapter().notifyDataSetChanged();
            }
        });





    }
}