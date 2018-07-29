package com.example.pavel.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pavel.myapplication.database.CoinDatabaseManager;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Pavel on 7/29/2018.
 */

public class CoinDatabaseViewAdapter extends RecyclerView.Adapter<CoinDatabaseViewAdapter.MyViewHolder> {

    private List<CoinDatabaseManager.DatabaseCoin> coinList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, symbol, price;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            name    = (TextView) itemView.findViewById(R.id.coinName);
            symbol  = (TextView) itemView.findViewById(R.id.coinSymbol);
            image   = (ImageView)itemView.findViewById(R.id.coinImage);
            price   = (TextView) itemView.findViewById(R.id.coinPrice);
        }
    }

    public CoinDatabaseViewAdapter(List<CoinDatabaseManager.DatabaseCoin> coinList) {
        this.coinList = coinList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crypto_list_row, parent, false);

        return new CoinDatabaseViewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CoinDatabaseManager.DatabaseCoin coin = coinList.get(position);

        holder.name.setText(coin.getName());
        holder.symbol.setText(coin.getSymbol());
        holder.price.setText("$ " + coin.getPrice());
        Picasso.get().load(coin.getIcon_url()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }
}
