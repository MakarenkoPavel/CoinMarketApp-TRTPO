package com.example.pavel.myapplication.setupcoinsactivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pavel.myapplication.R;
import com.example.pavel.myapplication.database.CoinDatabaseManager;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Pavel on 7/29/2018.
 */

public class SetupCoinViewAdapter extends RecyclerView.Adapter<SetupCoinViewAdapter.MyViewHolder> {

    private List<CoinDatabaseManager.DatabaseCoin> coinList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public TextView name;
        public CheckBox coinSelection;

        public MyViewHolder(View itemView) {
            super(itemView);

            name    = (TextView) itemView.findViewById(R.id.setup_coinName);
            icon    = (ImageView)itemView.findViewById(R.id.setup_coinImage);
            coinSelection = (CheckBox) itemView.findViewById(R.id.setup_coinSelection);
        }
    }

    public SetupCoinViewAdapter(List<CoinDatabaseManager.DatabaseCoin> coinList) {
        this.coinList = coinList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setup_list_row, parent, false);

        return new SetupCoinViewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CoinDatabaseManager.DatabaseCoin coin = coinList.get(position);

        holder.name.setText(coin.getName());
        holder.coinSelection.setChecked(coin.isIs_favorite());
        Picasso.get().load("https://www.cryptocompare.com/media/19633/btc.png" ).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }
}
