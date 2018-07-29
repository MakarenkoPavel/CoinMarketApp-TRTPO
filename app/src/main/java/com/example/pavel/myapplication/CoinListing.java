package com.example.pavel.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Pavel on 7/24/2018.
 */

public class CoinListing {

    @SerializedName("data")
    public List<Coin> coinList;
    @SerializedName("metadata")
    public State responseState;

    public class Coin {

        @SerializedName("id")
        public int coinId;
        @SerializedName("name")
        public String coinName;
        @SerializedName("symbol")
        public String coinSymbol;
        @SerializedName("website_slug")
        public String coinWebsiteSlug;
    }

    public class State {

        @SerializedName("timestamp")
        public String uptime;
        @SerializedName("num_cryptocurrencies")
        public int coinsNum;
        @SerializedName("error")
        public String responseError;
    }
}
