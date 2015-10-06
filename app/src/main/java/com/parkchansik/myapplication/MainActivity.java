package com.parkchansik.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);//리사이클뷸ㄹ 가져옴
        recyclerView.addItemDecoration(new VerticalDividerDecoration(this));
        mAdapter = new MyAdapter();
        mAdapter.setOnItemClickListener(new ViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Toast.makeText(MainActivity.this, "name : " + name , Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(mAdapter);//세팅함
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);//어떤 모양으로 뷷ㄹ을 배치할꺼야 ?? 여기서 하는거야
//        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false);//
        recyclerView.setLayoutManager(manager);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 40; i++) {
            mAdapter.add("item" + i);
        }
    }
}
