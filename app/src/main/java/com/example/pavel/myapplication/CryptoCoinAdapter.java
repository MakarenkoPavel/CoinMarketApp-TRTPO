package com.example.pavel.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pavel.myapplication.clientapi.CryptoCompareAPI.CoinListResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Pavel on 7/23/2018.
 */

public class CryptoCoinAdapter extends RecyclerView.Adapter<CryptoCoinAdapter.MyViewHolder> {

    private List<CoinListResponse.Coin> coinList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, symbol, price;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);

            name    = (TextView) view.findViewById(R.id.coinName);
            symbol  = (TextView) view.findViewById(R.id.coinSymbol);
            image   = (ImageView)view.findViewById(R.id.coinImage);
            price   = (TextView) view.findViewById(R.id.coinPrice);
        }
    }

    public CryptoCoinAdapter(List<CoinListResponse.Coin> coinList) {
        this.coinList = coinList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crypto_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CoinListResponse.Coin coin = coinList.get(position);

        holder.name.setText(coin.name);
        holder.symbol.setText(coin.symbol);
        //holder.price.setText(coin.price);
        Picasso.get().load("https://www.cryptocompare.com" + coin.imageUrl).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }
}
