package com.example.pavel.myapplication.clientapi.CryptoCompareAPI;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Pavel on 7/24/2018.
 */

public class CoinListResponse {

    @SerializedName("Response")
    public String response;
    @SerializedName("Message")
    public String message;
    @SerializedName("Data")
    public Map<String, Coin> coinMap;
    @SerializedName("BaseImageUrl")
    public String baseImageUrl;
    @SerializedName("BaseLinkUrl")
    public String baseLinkUrl;

    public class Coin {

        @SerializedName("Id")
        public int id;
        @SerializedName("Url")
        public String url;
        @SerializedName("ImageUrl")
        public String imageUrl;
        @SerializedName("Name")
        public String name;
        @SerializedName("Symbol")
        public String symbol;
        @SerializedName("CoinName")
        public String coinName;
        @SerializedName("FullName")
        public String fullName;
        @SerializedName("Algorithm")
        public String algorithm;
        @SerializedName("ProofType")
        public String proofType;
        @SerializedName("FullyPremined")
        public String fulluPremined;
        @SerializedName("TotalCoinSupply")
        public String totalCoinSupply;
        @SerializedName("BuiltOn")
        public String builtOn;
        @SerializedName("SmartContractAddress")
        public String smartContractAddress;
        @SerializedName("PreMinedValue")
        public String preMinedValue;
        @SerializedName("TotalCoinsFreeFloat")
        public String totalCoinsFreeFloat;
        @SerializedName("SortOrder")
        public String sortOrder;
        @SerializedName("Sponsored")
        public String sponsored;
        @SerializedName("IsTrading")
        public String isTrading;
    }

    public CoinListResponse(String response, String message, Map<String, Coin> coinMap, String baseImageUrl, String baseLinkUrl) {
        this.response = response;
        this.message = message;
        this.coinMap = coinMap;
        this.baseImageUrl = baseImageUrl;
        this.baseLinkUrl = baseLinkUrl;
    }

    public String getResponse() {
        return response;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Coin> getCoinMap() {
        return coinMap;
    }

    public List<Coin> getCoinList() {
        return new ArrayList<Coin>(coinMap.values());
    }

    public String getBaseImageUrl() {
        return baseImageUrl;
    }

    public String getBaseLinkUrl() {
        return baseLinkUrl;
    }
}
