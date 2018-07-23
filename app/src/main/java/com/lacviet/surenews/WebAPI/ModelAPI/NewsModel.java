package com.lacviet.surenews.WebAPI.ModelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsModel {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Author")
    @Expose
    private Object author;
    @SerializedName("FriendlyName")
    @Expose
    private Object friendlyName;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("PublishedDate")
    @Expose
    private String publishedDate;
    @SerializedName("Body")
    @Expose
    private Object body;
    @SerializedName("ItemImg")
    @Expose
    private String itemImg;
    @SerializedName("ReadCounter")
    @Expose
    private Integer readCounter;
    @SerializedName("CategoryId")
    @Expose
    private String categoryId;
    @SerializedName("Relatival")
    @Expose
    private Object relatival;
    @SerializedName("Content")
    @Expose
    private Object content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getAuthor() {
        return author;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public Object getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(Object friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public Integer getReadCounter() {
        return readCounter;
    }

    public void setReadCounter(Integer readCounter) {
        this.readCounter = readCounter;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Object getRelatival() {
        return relatival;
    }

    public void setRelatival(Object relatival) {
        this.relatival = relatival;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
