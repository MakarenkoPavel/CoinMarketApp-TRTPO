package com.example.pavel.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.CryptoCompareAPI;
import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.CryptoCompareService;
import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.HistoricalCoinSnapshot;
import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.HistoricalDailyChartData;
import com.example.pavel.myapplication.database.CoinDatabaseManager;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activityChartCoin extends AppCompatActivity {

    private CoinDatabaseManager coinDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_coin);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        coinDatabaseManager = new CoinDatabaseManager(this);
        List<CoinDatabaseManager.DatabaseCoin> fCoins = coinDatabaseManager.getFavoriteCoins();
        
        for(CoinDatabaseManager.DatabaseCoin coin : fCoins) {

            CryptoCompareService service = CryptoCompareAPI.getRetrofitInstance().create(CryptoCompareService.class);
            Call<HistoricalDailyChartData> call = service.getHistoricalDailyChartInfo(coin.getSymbol(), "USD", "10");
            call.enqueue(new Callback<HistoricalDailyChartData>() {

                @Override
                public void onResponse(Call<HistoricalDailyChartData> call, Response<HistoricalDailyChartData> response) {
                    HistoricalDailyChartData data = response.body();

                    if(data != null) {
                        GraphView graph = (GraphView) findViewById(R.id.graph);
                        graph.removeAllSeries();

                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

                        for (int i = 0; i < data.chartData.size(); i++) {
                            series.appendData(new DataPoint(i, Double.parseDouble(data.chartData.get(i).open)), true, 256);
                        }

                        series.setColor(getRandColor());
                        graph.addSeries(series);
                    }
                }

                @Override
                public void onFailure(Call<HistoricalDailyChartData> call, Throwable t) {
                    Log.d("update status", "can not upload coin data");
                }
            });
        }
    }

    public void dailyBtnClick(View view) {
        List<CoinDatabaseManager.DatabaseCoin> fCoins = coinDatabaseManager.getFavoriteCoins();

        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.removeAllSeries();
        for(CoinDatabaseManager.DatabaseCoin coin : fCoins) {

            CryptoCompareService service = CryptoCompareAPI.getRetrofitInstance().create(CryptoCompareService.class);
            Call<HistoricalDailyChartData> call = service.getHistoricalDailyChartInfo(coin.getSymbol(), "USD", "10");
            call.enqueue(new Callback<HistoricalDailyChartData>() {

                @Override
                public void onResponse(Call<HistoricalDailyChartData> call, Response<HistoricalDailyChartData> response) {
                    HistoricalDailyChartData data = response.body();

                    if(data != null) {
                        GraphView graph = (GraphView) findViewById(R.id.graph);
                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

                        for (int i = 0; i < data.chartData.size(); i++) {
                            series.appendData(new DataPoint(i, Double.parseDouble(data.chartData.get(i).open)), true, 256);
                        }

                        series.setColor(getRandColor());
                        graph.addSeries(series);
                    }
                }

                @Override
                public void onFailure(Call<HistoricalDailyChartData> call, Throwable t) {
                    Log.d("update status", "can not upload coin data");
                }
            });
        }
    }

    public void hourlyBtnClick(View view) {
        List<CoinDatabaseManager.DatabaseCoin> fCoins = coinDatabaseManager.getFavoriteCoins();

        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.removeAllSeries();
        for(CoinDatabaseManager.DatabaseCoin coin : fCoins) {

            CryptoCompareService service = CryptoCompareAPI.getRetrofitInstance().create(CryptoCompareService.class);
            Call<HistoricalDailyChartData> call = service.getHistoricalHourlyChartInfo(coin.getSymbol(), "USD", "10");
            call.enqueue(new Callback<HistoricalDailyChartData>() {

                @Override
                public void onResponse(Call<HistoricalDailyChartData> call, Response<HistoricalDailyChartData> response) {
                    HistoricalDailyChartData data = response.body();

                    if(data != null) {
                        GraphView graph = (GraphView) findViewById(R.id.graph);
                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

                        for (int i = 0; i < data.chartData.size(); i++) {
                            series.appendData(new DataPoint(i, Double.parseDouble(data.chartData.get(i).open)), true, 256);
                        }

                        series.setColor(getRandColor());
                        graph.addSeries(series);
                    }
                }

                @Override
                public void onFailure(Call<HistoricalDailyChartData> call, Throwable t) {
                    Log.d("update status", "can not upload coin data");
                }
            });
        }
    }

    public void minyteBtnClick(View view) {
        List<CoinDatabaseManager.DatabaseCoin> fCoins = coinDatabaseManager.getFavoriteCoins();

        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.removeAllSeries();
        for(CoinDatabaseManager.DatabaseCoin coin : fCoins) {

            CryptoCompareService service = CryptoCompareAPI.getRetrofitInstance().create(CryptoCompareService.class);
            Call<HistoricalDailyChartData> call = service.getHistoricalMinuteChartInfo(coin.getSymbol(), "USD", "10");
            call.enqueue(new Callback<HistoricalDailyChartData>() {

                @Override
                public void onResponse(Call<HistoricalDailyChartData> call, Response<HistoricalDailyChartData> response) {
                    HistoricalDailyChartData data = response.body();

                    if(data != null) {
                        GraphView graph = (GraphView) findViewById(R.id.graph);
                        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

                        for (int i = 0; i < data.chartData.size(); i++) {
                            series.appendData(new DataPoint(i, Double.parseDouble(data.chartData.get(i).open)), true, 256);
                        }

                        series.setColor(getRandColor());
                        graph.addSeries(series);
                    }
                }

                @Override
                public void onFailure(Call<HistoricalDailyChartData> call, Throwable t) {
                    Log.d("update status", "can not upload coin data");
                }
            });
        }
    }

    public int getRandColor() {
        int Min = 0;
        int Max = 255;
        return Color.rgb(Min + (int)(Math.random() * ((Max - Min) + 1)),
                Min + (int)(Math.random() * ((Max - Min) + 1)),
                Min + (int)(Math.random() * ((Max - Min) + 1)));
    }
}
