package com.example.newslist;
public class NewsListModel {
    public static final int HEADLINE_CENTRIC=0;
    public static final int PHOTO_CENTRIC=1;
    public static final int LIST_CENTRIC=2;
    public int data;
    public int type;
    public String text;
    public String dtype;
    public NewsListModel(int type,int data,String text,String dtype){
        this.data=data;
        this.type=type;
        this.text=text;
        this.dtype=dtype;
    }
}
