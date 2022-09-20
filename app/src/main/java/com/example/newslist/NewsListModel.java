package com.example.newslist;

import java.util.List;

public class NewsListModel <T>{
    public static final int HEADLINE_CENTRIC=0;
    public static final int PHOTO_CENTRIC=1;
    public static final int LIST_CENTRIC=2;
    public int data;
    public int type;
    public String text;
    public String dtype;
    List<T> headLineModels;
    List<T> photoModels;
    List<T> listmodels;
    public NewsListModel(int type,int data,String text,String dtype,List<T> headLineModels){
        this.data=data;
        this.type=type;
        this.text=text;
        this.dtype=dtype;
        this.headLineModels=headLineModels;
        this.photoModels=headLineModels;
        this.listmodels=headLineModels;

    }



}
