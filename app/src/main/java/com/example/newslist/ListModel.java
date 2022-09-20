package com.example.newslist;
public class ListModel {
    private int limg;
    private String ltext;

    public ListModel(int limg, String ltext) {
        this.limg = limg;
        this.ltext = ltext;
    }

    public int getLimg() {
        return limg;
    }

    public void setLimg(int limg) {
        this.limg = limg;
    }

    public String getLtext() {
        return ltext;
    }

    public void setLtext(String ltext) {
        this.ltext = ltext;
    }
}
