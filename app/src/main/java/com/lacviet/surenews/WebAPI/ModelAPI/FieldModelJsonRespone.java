package com.lacviet.surenews.WebAPI.ModelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FieldModelJsonRespone {

    @SerializedName("FieldModels")
    @Expose
    private List<FieldModel> fieldModels = null;

    public List<FieldModel> getFieldModels() {
        return fieldModels;
    }

    public void setFieldModels(List<FieldModel> fieldModels) {
        this.fieldModels = fieldModels;
    }

}