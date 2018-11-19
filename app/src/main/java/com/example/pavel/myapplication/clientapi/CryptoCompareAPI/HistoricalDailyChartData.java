package com.example.pavel.myapplication.clientapi.CryptoCompareAPI;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Map;

public class HistoricalDailyChartData {

    @SerializedName("Response")
    public String response;
    @SerializedName("Type")
    public String type;
    @SerializedName("Aggregated")
    public String aggregated;
    @SerializedName("Data")
    public ArrayList<HistoricalCoinSnapshot> chartData;

    @SerializedName("TimeTo")
    public String timeTo;
    @SerializedName("TimeFrom")
    public String timeFrom;
    @SerializedName("FirstValueInArray")
    public String firstValueInArray;

    @SerializedName("ConversionType")
    public ConversionType conversionType;
    @SerializedName("RateLimit")
    public RateLimit rateLimit;
    @SerializedName("HasWarning")
    public String hasWarning;

    public class ConversionType {

        @SerializedName("type")
        public String type;
        @SerializedName("conversionSymbol")
        public String conversionSymbol;

        public ConversionType(String type, String conversionSymbol) {
            this.type = type;
            this.conversionSymbol = conversionSymbol;
        }

        public String getType() {
            return type;
        }

        public String getConversionSymbol() {
            return conversionSymbol;
        }
    }

    public class  RateLimit {

    }

    public HistoricalDailyChartData(String response, String type, String aggregated, ArrayList<HistoricalCoinSnapshot> chartData, String timeTo, String timeFrom, String firstValueInArray, ConversionType conversionType, RateLimit rateLimit, String hasWarning) {
        this.response = response;
        this.type = type;
        this.aggregated = aggregated;
        this.chartData = chartData;
        this.timeTo = timeTo;
        this.timeFrom = timeFrom;
        this.firstValueInArray = firstValueInArray;
        this.conversionType = conversionType;
        this.rateLimit = rateLimit;
        this.hasWarning = hasWarning;
    }

    public String getResponse() {
        return response;
    }

    public String getType() {
        return type;
    }

    public String getAggregated() {
        return aggregated;
    }

    public ArrayList<HistoricalCoinSnapshot> getChartData() {
        return chartData;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public String getFirstValueInArray() {
        return firstValueInArray;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public RateLimit getRateLimit() {
        return rateLimit;
    }

    public String getHasWarning() {
        return hasWarning;
    }
}
