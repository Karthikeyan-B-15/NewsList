package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsListAdapter adapter;
    private List<NewsListModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        list.add(new NewsListModel(NewsListModel.HEADLINE_CENTRIC,R.mipmap.ic_launcher_foreground,"This is Text","img"));
        list.add(new NewsListModel(NewsListModel.PHOTO_CENTRIC,R.mipmap.ic_launcher_foreground,"This is Text","img"));
        list.add(new NewsListModel(NewsListModel.PHOTO_CENTRIC,R.mipmap.ic_launcher_foreground,"This is Text","video"));
        list.add(new NewsListModel(NewsListModel.LIST_CENTRIC,R.mipmap.ic_launcher_foreground,"This is Text","img"));
        recyclerView=(RecyclerView) findViewById(R.id.newsrecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new NewsListAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}