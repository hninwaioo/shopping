package com.za.sbs.delivery.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by arkar on 1/8/18.
 */

public class Ticket implements Serializable {

    private String message;

    @SerializedName("user_name")
    private String createdBy;

    private String createdAt;

    private boolean solved;

    public Ticket(String message, String createdBy, String createdAt, boolean solved) {
        this.message = message;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.solved = solved;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
