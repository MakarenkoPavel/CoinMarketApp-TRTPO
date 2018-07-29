package com.example.pavel.myapplication.setupcoinsactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        public int id;
        public ImageView icon;
        public TextView name;
        public CheckBox coinSelection;

        private CoinDatabaseManager coinDatabaseManager;

        public MyViewHolder(View itemView, Context context) {
            super(itemView);

            coinDatabaseManager = new CoinDatabaseManager(context);
            name    = (TextView) itemView.findViewById(R.id.setup_coinName);
            icon    = (ImageView)itemView.findViewById(R.id.setup_coinImage);
            coinSelection = (CheckBox) itemView.findViewById(R.id.setup_coinSelection);

            coinSelection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if (isChecked) {
                        Log.d("status", "checked");
                        Log.d("id", "id: " + id);
                        Log.d("name", "name: " + name.getText());

                        coinDatabaseManager.makeCoinFavorite(id);
                    }
                    else {
                        Log.d("status", "unchecked");
                        Log.d("id", "id: " + id);
                        Log.d("name", "name: " + name.getText());

                        coinDatabaseManager.unmakeCoinFavorite(id);
                    }
                }
            });
        }
    }

    public SetupCoinViewAdapter(List<CoinDatabaseManager.DatabaseCoin> coinList) {
        this.coinList = coinList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setup_list_row, parent, false);

        return new SetupCoinViewAdapter.MyViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CoinDatabaseManager.DatabaseCoin coin = coinList.get(position);

        holder.id = coin.getId();
        holder.name.setText(coin.getName());
        holder.coinSelection.setChecked(coin.isIs_favorite());
        Picasso.get().load("https://www.cryptocompare.com/media/19633/btc.png" ).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }
}
