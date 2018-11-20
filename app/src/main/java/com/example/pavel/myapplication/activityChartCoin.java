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
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activityChartCoin extends AppCompatActivity {

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
                HistoricalDailyChartData data = response.body();

                if(data != null) {
                    GraphView graph = (GraphView) findViewById(R.id.graph);
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

                    for (int i = 0; i < data.chartData.size(); i++) {
                        series.appendData(new DataPoint(i, Double.parseDouble(data.chartData.get(i).open)), true, 256);
                    }

                    series.setColor(Color.RED);
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
