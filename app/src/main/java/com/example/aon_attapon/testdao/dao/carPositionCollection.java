package com.example.aon_attapon.testdao.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class carPositionCollection {
    @SerializedName("status_code")          int statusCode;
    @SerializedName("message")              String message;
    @SerializedName("carPosition")          List<carPositions> carPositions;

    public int getStatusCode() {
        return statusCode;
    }

    public List<carPositions> getCarPositions() {
        return carPositions;
    }

    public void setCarPositions(List<carPositions> carPositions) {
        this.carPositions = carPositions;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
