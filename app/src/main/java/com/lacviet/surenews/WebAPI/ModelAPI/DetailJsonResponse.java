package com.lacviet.surenews.WebAPI.ModelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailJsonResponse {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Author")
    @Expose
    private String author;
    @SerializedName("FriendlyName")
    @Expose
    private String friendlyName;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("PublishedDate")
    @Expose
    private String publishedDate;
    @SerializedName("Body")
    @Expose
    private String body;
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
    private List<ContentModel> content = null;
    @SerializedName("Tags")
    @Expose
    private List<String> tags = null;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
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

    public List<ContentModel> getContent() {
        return content;
    }

    public void setContent(List<ContentModel> content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}