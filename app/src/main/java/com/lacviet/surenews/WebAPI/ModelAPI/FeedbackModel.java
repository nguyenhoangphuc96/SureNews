package com.lacviet.surenews.WebAPI.ModelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedbackModel {

    @SerializedName("FieldId")
    @Expose
    private String fieldId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Content")
    @Expose
    private String content;
    @SerializedName("CreateBy")
    @Expose
    private String createBy;
    @SerializedName("CreateDate")
    @Expose
    private String createDate;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("Attachments")
    @Expose
    private String attachments;



    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "FeedbackModel{" +
                "fieldId='" + fieldId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", phone='" + phone + '\'' +
                ", attachments='" + attachments + '\'' +
                '}';
    }
}