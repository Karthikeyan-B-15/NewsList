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
    private List<HeadLineModel> headlist;
    private List<PhotoModel> photolist;
    private List<ListModel> modelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        list.add(new NewsListModel(NewsListModel.HEADLINE_CENTRIC,R.drawable.n1,"This is sample news without video","img",getHead()));
        list.add(new NewsListModel(NewsListModel.PHOTO_CENTRIC,R.drawable.n2,"This is sample news without video","img",getPhotolist()));
        list.add(new NewsListModel(NewsListModel.PHOTO_CENTRIC,R.drawable.n3,"This is sample news with video","video",getPhotolist()));
        list.add(new NewsListModel(NewsListModel.LIST_CENTRIC,R.drawable.n4,"This is sample news without video","img",getModelList()));
        list.add(new NewsListModel(NewsListModel.LIST_CENTRIC,R.drawable.n5,"This is sample news without video","img",getModelList()));
        recyclerView=(RecyclerView) findViewById(R.id.newsrecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        SpaceDecorator decorator=new SpaceDecorator(20);
        recyclerView.addItemDecoration(decorator);
        adapter=new NewsListAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }
    public List<HeadLineModel> getHead(){
        headlist=new ArrayList<>();
        headlist.add(new HeadLineModel("This is sample news with video","video"));
        headlist.add(new HeadLineModel("This is sample news with video","video"));
        headlist.add(new HeadLineModel("This is sample news without video",""));
        headlist.add(new HeadLineModel("This is sample news without video",""));
        return headlist;
    }
    public List<PhotoModel> getPhotolist(){
        photolist=new ArrayList<>();
        photolist.add(new PhotoModel("video","This is sample news with video",R.drawable.n6));
        photolist.add(new PhotoModel("","This is sample news without video",R.drawable.n7));
        photolist.add(new PhotoModel("video","This is sample news with video",R.drawable.n8));
        photolist.add(new PhotoModel("","This is sample news without video",R.drawable.n9));
        return photolist;
    }
    public List<ListModel> getModelList(){
        modelList=new ArrayList<>();
        modelList.add(new ListModel(R.drawable.n5,"This is sample news without video"));
        modelList.add(new ListModel(R.drawable.n1,"This is sample news without video"));
        modelList.add(new ListModel(R.drawable.n7,"This is sample news without video"));
        modelList.add(new ListModel(R.drawable.n2,"This is sample news without video"));
        return modelList;
    }
}