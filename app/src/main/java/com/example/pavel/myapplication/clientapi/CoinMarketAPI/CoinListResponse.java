package com.example.pavel.myapplication.clientapi.CoinMarketAPI;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 7/28/2018.
 */

public class CoinListResponse {
    @SerializedName("data")
    private List<Coin> coinList;
    @SerializedName("metadata")
    private Metadata meta;

    public class Coin {

        @SerializedName("id")
        private int coinId;
        @SerializedName("name")
        private String coinName;
        @SerializedName("symbol")
        private String coinSymbol;
        @SerializedName("website_slug")
        private String coinWebsiteSlug;

        public Coin(int coinId, String coinName, String coinSymbol, String coinWebsiteSlug) {
            this.coinId = coinId;
            this.coinName = coinName;
            this.coinSymbol = coinSymbol;
            this.coinWebsiteSlug = coinWebsiteSlug;
        }

        public int getCoinId() {
            return coinId;
        }

        public void setCoinId(int coinId) {
            this.coinId = coinId;
        }

        public String getCoinName() {
            return coinName;
        }

        public void setCoinName(String coinName) {
            this.coinName = coinName;
        }

        public String getCoinSymbol() {
            return coinSymbol;
        }

        public void setCoinSymbol(String coinSymbol) {
            this.coinSymbol = coinSymbol;
        }

        public String getCoinWebsiteSlug() {
            return coinWebsiteSlug;
        }

        public void setCoinWebsiteSlug(String coinWebsiteSlug) {
            this.coinWebsiteSlug = coinWebsiteSlug;
        }
    }

    public class Metadata {

        @SerializedName("timestamp")
        private String timestamp;
        @SerializedName("num_cryptocurrencies")
        private String num_cryptocurrencies;
        @SerializedName("error")
        private String error;

        public Metadata(String timestamp, String num_cryptocurrencies, String error) {
            this.timestamp = timestamp;
            this.num_cryptocurrencies = num_cryptocurrencies;
            this.error = error;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getNum_cryptocurrencies() {
            return num_cryptocurrencies;
        }

        public void setNum_cryptocurrencies(String num_cryptocurrencies) {
            this.num_cryptocurrencies = num_cryptocurrencies;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public CoinListResponse(List<Coin> coinList, Metadata meta) {
        this.coinList = coinList;
        this.meta = meta;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public Metadata getMeta() {
        return meta;
    }

    public void setMeta(Metadata meta) {
        this.meta = meta;
    }
}
