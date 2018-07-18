package com.lacviet.surenews.WebAPI.ModelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllCategoryJsonResponse {
    @SerializedName("CategoryModels")
    @Expose
    private List<CategoryModel> categoryModels = null;

    public List<CategoryModel> getCategoryModels() {
        return categoryModels;
    }

    public void setCategoryModels(List<CategoryModel> categoryModels) {
        this.categoryModels = categoryModels;
    }

}