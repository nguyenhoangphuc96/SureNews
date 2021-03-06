package com.lacviet.surenews.Model;

public class HomeNewsModel {
    private Integer newsId;
    private String newsTittle;
    private String newsSubTittle;
    private String newsImage;
    private String newsTime;
    private String newslink;

    public HomeNewsModel(Integer newsId, String newsTittle, String newsSubTittle, String newsImage, String newsTime, String newslink) {
        this.newsId = newsId;
        this.newsTittle = newsTittle;
        this.newsSubTittle = newsSubTittle;
        this.newsImage = newsImage;
        this.newsTime = newsTime;
        this.newslink = newslink;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTittle() {
        return newsTittle;
    }

    public void setNewsTittle(String newsTittle) {
        this.newsTittle = newsTittle;
    }

    public String getNewsSubTittle() {
        return newsSubTittle;
    }

    public void setNewsSubTittle(String newsSubTittle) {
        this.newsSubTittle = newsSubTittle;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewslink() {
        return newslink;
    }

    public void setNewslink(String newslink) {
        this.newslink = newslink;
    }
}
