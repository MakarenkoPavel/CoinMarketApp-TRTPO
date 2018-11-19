package com.example.pavel.myapplication;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.CryptoCompareAPI;
import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.CryptoCompareService;
import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.HistoricalDailyChartData;
import com.example.pavel.myapplication.database.*;
import com.example.pavel.myapplication.setupcoinsactivity.EditCoinListActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_DATABASE_MESSAGE = "coinsDatabase";

    private CoinDatabaseManager coinDatabaseManager;
    private List<CoinDatabaseManager.DatabaseCoin> coinList;

    private SwipeRefreshLayout swipeRefreshLayout;
    private CoinDatabaseViewAdapter viewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();

        coinDatabaseManager = new CoinDatabaseManager(this);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresfLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.textview_text, R.color.textview_back);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                coinDatabaseManager.updateDatabase();
                setupRecyclerView();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        /* Check for first time launch */
        Boolean isFirstLaunch = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstLaunch", true);
        if(isFirstLaunch) {
            prepareDatabase();
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstLaunch", false).apply();

        coinDatabaseManager.updateDatabase();
        setupRecyclerView();
    }

    private void setupRecyclerView() {

        List<CoinDatabaseManager.DatabaseCoin> coinList = coinDatabaseManager.getAllCoins();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        viewAdapter = new CoinDatabaseViewAdapter(coinDatabaseManager.getFavoriteCoins());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
    }

    private void setupToolbar() {

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setElevation(0);
        setSupportActionBar(myToolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
    }

    private void prepareDatabase() {

        coinDatabaseManager.insertCoin(1, "Bitcoin", "BTC", "0",
                "https://www.cryptocompare.com/media/19633/btc.png", true);
        coinDatabaseManager.insertCoin(2, "Litecoin", "LTC", "0",
                "https://www.cryptocompare.com/media/19782/litecoin-logo.png", true);
        coinDatabaseManager.insertCoin(52, "XRP", "XRP", "0",
                "https://www.cryptocompare.com/media/34477776/xrp.png", true);
        coinDatabaseManager.insertCoin(66, "Nxt", "NXT", "0",
                "https://www.cryptocompare.com/media/20627/nxt.png", true);
        coinDatabaseManager.insertCoin(74, "Dogecoin", "DOGE", "0",
                "https://www.cryptocompare.com/media/19684/doge.png", false);
        coinDatabaseManager.insertCoin(109, "DigiByte", "DGB", "0",
                "https://www.cryptocompare.com/media/12318264/7638-nty_400x400.jpg", false);
        coinDatabaseManager.insertCoin(118, "ReddCoin", "RDD", "0",
                "https://www.cryptocompare.com/media/19887/rdd.png", false);
        coinDatabaseManager.insertCoin(131, "Dash", "DASH", "0",
                "https://www.cryptocompare.com/media/33842920/dash.png", false);
        coinDatabaseManager.insertCoin(213, "MonaCoin", "MONA", "0",
                "https://www.cryptocompare.com/media/19801/mona.png", false);
        coinDatabaseManager.insertCoin(328, "Monero", "XMR", "0",
                "https://www.cryptocompare.com/media/19969/xmr.png", false);
        coinDatabaseManager.insertCoin(372, "Bytecoin", "BCN", "0",
                "https://www.cryptocompare.com/media/19632/bte.png", false);
    }

    public void editBtnClick(View view) {
        Intent intent = new Intent(this, EditCoinListActivity.class);
        startActivityForResult(intent, 0);
    }

    public void chartBtnClick(View view) {
        Intent intent = new Intent(this, activityChartCoin.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("result", "FINISH");
        setupRecyclerView();
    }

}
