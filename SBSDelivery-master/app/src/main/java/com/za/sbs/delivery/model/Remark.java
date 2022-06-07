package com.za.sbs.delivery.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by arkar on 8/27/17.
 */

public class Remark implements Serializable {

    @SerializedName("remark")
    private String remark;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("author")
    private String author;

    public Remark(String remark, String createdAt, String author) {
        this.remark = remark;
        this.createdAt = createdAt;
        this.author = author;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
