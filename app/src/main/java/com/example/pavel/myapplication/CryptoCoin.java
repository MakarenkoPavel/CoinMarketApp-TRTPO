package com.example.pavel.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pavel on 7/23/2018.
 */

public class CryptoCoin {

    @SerializedName("Id")
    private int coinId;

    @SerializedName("SortOrder")
    private int coinPriority;

    @SerializedName("Url")
    private String coinUrl;

    @SerializedName("imageUrl")
    private String coinImageUrl;

    @SerializedName("Symbol")
    private String coinSymbol;

    @SerializedName("CoinName")
    private String coinName;

    @SerializedName("Algorithm")
    private String coinAlgorithm;

    @SerializedName("ProofType")
    private String coinProofType;

    private String coinPrice;

    public CryptoCoin(int coinId, int coinPriority, String coinUrl, String coinImageUrl, String coinSymbol, String coinName, String coinAlgorithm, String coinProofType, String coinPrice) {
        this.coinId = coinId;
        this.coinPriority = coinPriority;
        this.coinUrl = coinUrl;
        this.coinImageUrl = coinImageUrl;
        this.coinSymbol = coinSymbol;
        this.coinName = coinName;
        this.coinAlgorithm = coinAlgorithm;
        this.coinProofType = coinProofType;
        this.coinPrice = coinPrice;
    }

    public CryptoCoin(String imageUrl, String name, String symbol) {
        coinImageUrl = imageUrl;
        coinName = name;
        coinSymbol = symbol;
    }

    public int getCoinId() {
        return coinId;
    }

    public int getCoinPriority() {
        return coinPriority;
    }

    public String getCoinUrl() {
        return coinUrl;
    }

    public String getCoinImageUrl() {
        return coinImageUrl;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public String getCoinName() {
        return coinName;
    }

    public String getCoinAlgorithm() {
        return coinAlgorithm;
    }

    public String getCoinProofType() {
        return coinProofType;
    }

    public String getCoinPrice() {
        return coinPrice;
    }

    public int id() {
        return coinId;
    }

    public int priority() {
        return coinPriority;
    }

    public String url() {
        return coinUrl;
    }

    public String imageUrl() {
        return coinImageUrl;
    }

    public String symbol() {
        return coinSymbol;
    }

    public String name() {
        return coinName;
    }

    public String price() {
        return coinPrice;
    }

    private String algorithm() {
        return coinAlgorithm;
    }

    private String proofType() {
        return coinProofType;
    }
}
