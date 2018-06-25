package com.lacviet.surenews.Model;

public class VideoModel {
    private Integer videoId;
    private String videoTittle;
    private String videoSubTittle;
    private String videoUrl;
    private String videoTime;

    public VideoModel(Integer videoId, String videoTittle, String videoSubTittle, String videoUrl, String videoTime) {
        this.videoId = videoId;
        this.videoTittle = videoTittle;
        this.videoSubTittle = videoSubTittle;
        this.videoUrl = videoUrl;
        this.videoTime = videoTime;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTittle() {
        return videoTittle;
    }

    public void setVideoTittle(String videoTittle) {
        this.videoTittle = videoTittle;
    }

    public String getVideoSubTittle() {
        return videoSubTittle;
    }

    public void setVideoSubTittle(String videoSubTittle) {
        this.videoSubTittle = videoSubTittle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }
}
