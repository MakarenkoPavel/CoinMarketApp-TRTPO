package com.example.pavel.myapplication.clientapi.CoinMarketAPI;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

/**
 * Created by Pavel on 7/28/2018.
 */

public interface CoinMarketService {

    @GET("v2/listings")
    Call<CoinListResponse> getCoinList();

    @GET("v2/ticker/{id}/")
    Call<TickerResponse> getTickerInfo(@Path("id") String coinId);

    //@GET("/data/price?fsym={coin}&tsyms={currency}")
    //Call<Integer> getPrice(@Path("coin") String coin, @Path("currency") String currency);
}
