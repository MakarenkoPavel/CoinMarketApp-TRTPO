package com.example.pavel.myapplication.clientapi.CryptoCompareAPI;

import com.google.gson.annotations.SerializedName;

public class HistoricalCoinSnapshot {

    @SerializedName("time")
    public String time;
    @SerializedName("close")
    public String close;
    @SerializedName("high")
    public String high;
    @SerializedName("low")
    public String low;
    @SerializedName("open")
    public String open;
    @SerializedName("volumefrom")
    public String volumefrom;
    @SerializedName("volumeto")
    public String volumeto;

    public HistoricalCoinSnapshot(String time, String close, String high, String low, String open, String volumefrom, String volumeto) {
        this.time = time;
        this.close = close;
        this.high = high;
        this.low = low;
        this.open = open;
        this.volumefrom = volumefrom;
        this.volumeto = volumeto;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public void setVolumefrom(String volumefrom) {
        this.volumefrom = volumefrom;
    }

    public void setVolumeto(String volumeto) {
        this.volumeto = volumeto;
    }

    public String getTime() {
        return time;
    }

    public String getClose() {
        return close;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getOpen() {
        return open;
    }

    public String getVolumefrom() {
        return volumefrom;
    }

    public String getVolumeto() {
        return volumeto;
    }
}
