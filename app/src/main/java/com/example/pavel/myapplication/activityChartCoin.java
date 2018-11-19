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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activityChartCoin extends AppCompatActivity {

    private HistoricalDailyChartData data;

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

        CryptoCompareService service = CryptoCompareAPI.getRetrofitInstance().create(CryptoCompareService.class);
        Call<HistoricalDailyChartData> call = service.getHistoricalDailyChartInfo("BTC", "USD", "10");
        call.enqueue(new Callback<HistoricalDailyChartData>() {

            @Override
            public void onResponse(Call<HistoricalDailyChartData> call, Response<HistoricalDailyChartData> response) {

                data = response.body();
            }

            @Override
            public void onFailure(Call<HistoricalDailyChartData> call, Throwable t) {

                Log.d("update status", "can not upload coin data");
            }
        });

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>();

        for(int i = 0; i < data.chartData.size(); i++) {
            series2.appendData(new DataPoint(i , i), true, 256);
        }


        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 4),
                new DataPoint(1, 2),
                new DataPoint(2, 8),
                new DataPoint(3, 9),
                new DataPoint(4, 10)
        });

        series2.setColor(Color.GREEN);
        series3.setColor(Color.RED);

        graph.addSeries(series2);
        graph.addSeries(series3);
    }
}
