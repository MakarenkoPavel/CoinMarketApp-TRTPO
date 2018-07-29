package com.example.pavel.myapplication.clientapi.CoinMarketAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pavel on 7/24/2018.
 */

public class CoinMarketAPI {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://api.coinmarketcap.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
