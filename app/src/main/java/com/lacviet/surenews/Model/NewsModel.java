package com.lacviet.surenews.Model;

public class NewsModel {
    private Integer newsId;
    private String newsTittle;
    private String newsTime;
    private String newsSubTittle;
    private String newsImage;

    public NewsModel(Integer newsId, String newsTittle, String newsTime, String newsSubTittle, String newsImage) {
        this.newsId = newsId;
        this.newsTittle = newsTittle;
        this.newsTime = newsTime;
        this.newsSubTittle = newsSubTittle;
        this.newsImage = newsImage;
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
}
