package com.example.newslist;
public class PhotoModel {
    private String type;
    private String text;
    private int img;

    public PhotoModel(String type, String text, int img) {
        this.type = type;
        this.text = text;
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
