package com.example.newslist;
public class HeadLineModel {
    private String headlinetext;
    private String headtype;

    public String getHeadlinetext() {
        return headlinetext;
    }

    public void setHeadlinetext(String headlinetext) {
        this.headlinetext = headlinetext;
    }

    public String getHeadtype() {
        return headtype;
    }

    public void setHeadtype(String headtype) {
        this.headtype = headtype;
    }

    public HeadLineModel(String headlinetext, String headtype) {
        this.headlinetext = headlinetext;
        this.headtype=headtype;
    }
}
