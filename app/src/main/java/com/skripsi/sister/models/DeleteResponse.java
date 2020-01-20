package com.skripsi.sister.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fizhu on 28,November,2019
 * Hvyz.anbiya@gmail.com
 */
public class DeleteResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
