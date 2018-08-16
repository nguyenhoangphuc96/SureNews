package com.lacviet.surenews.Model;

public class CommentModel {
    String id;
    String name;
    String time;
    String content;

    public CommentModel(String id, String name, String time, String content) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
