package com.lacviet.surenews.Model;

public class DetailModel {
    String Text;
    String Photo;

    public DetailModel(String text, String photo) {
        Text = text;
        Photo = photo;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
