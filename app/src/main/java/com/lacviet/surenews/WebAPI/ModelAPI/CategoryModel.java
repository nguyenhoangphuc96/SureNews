package com.lacviet.surenews.WebAPI.ModelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryModel {
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("GroupId")
    @Expose
    private Object groupId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Object getGroupId() {
        return groupId;
    }

    public void setGroupId(Object groupId) {
        this.groupId = groupId;
    }

}

