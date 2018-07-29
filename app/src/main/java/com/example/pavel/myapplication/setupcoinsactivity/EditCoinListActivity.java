package com.example.pavel.myapplication.setupcoinsactivity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.pavel.myapplication.R;
import com.example.pavel.myapplication.database.CoinDatabaseManager;

import java.util.List;

public class EditCoinListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SetupCoinViewAdapter viewAdapter;
    private CoinDatabaseManager coinDatabaseManager;

    //private CheckBox coinSelectionCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_coin_list);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });

        coinDatabaseManager = new CoinDatabaseManager(this);
        List<CoinDatabaseManager.DatabaseCoin> coinList = coinDatabaseManager.getAllCoins();

        recyclerView = (RecyclerView) findViewById(R.id.setup_view);

        viewAdapter = new SetupCoinViewAdapter(coinList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
    }
}
