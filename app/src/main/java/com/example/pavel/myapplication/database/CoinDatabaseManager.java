package com.example.pavel.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pavel.myapplication.clientapi.CoinMarketAPI.CoinMarketAPI;
import com.example.pavel.myapplication.clientapi.CoinMarketAPI.CoinMarketService;
import com.example.pavel.myapplication.clientapi.CoinMarketAPI.TickerResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pavel on 7/28/2018.
 */

public class CoinDatabaseManager extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Coin.db";
    private static final String COIN_TABLE = "coin_table";
    private static final String CHART_TABLE = "chart_table";

    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String SYMBOL = "SYMBOL";
    private static final String PRICE = "PRICE";
    private static final String ICON_URL = "ICON_URL";
    private static final String IS_FAVORITE = "IS_FAVORITE";

    private static final String TRUE = "true";
    private static final String FALSE = "false";

    public class DatabaseCoin {

        private int id;
        private String name;
        private String symbol;
        private String price;
        private String icon_url;
        private boolean is_favorite;

        public DatabaseCoin(int id, String name, String symbol, String price, String icon_url, boolean is_favorite) {
            this.id = id;
            this.name = name;
            this.symbol = symbol;
            this.price = price;
            this.icon_url = icon_url;
            this.is_favorite = is_favorite;
        }

        public DatabaseCoin(int id, String name, String symbol, String price) {
            this.id = id;
            this.name = name;
            this.symbol = symbol;
            this.price = price;
        }

        public DatabaseCoin(int id, String name, String symbol, String price, boolean is_favorite) {
            this.id = id;
            this.name = name;
            this.symbol = symbol;
            this.price = price;
            this.is_favorite = is_favorite;
            this.is_favorite = false;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public boolean isIs_favorite() {
            return is_favorite;
        }

        public void setIs_favorite(boolean is_favorite) {
            this.is_favorite = is_favorite;
        }
    }

    public CoinDatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + COIN_TABLE +
                    " (ID INTEGER PRIMARY KEY," +
                    " NAME TEXT," +
                    " SYMBOL TEXT," +
                    " PRICE TEXT," +
                    " ICON_URL TEXT," +
                    " IS_FAVORITE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + COIN_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean insertCoin(int id, String name, String symbol, String price, String iconUrl, boolean isFavorite) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(SYMBOL, symbol);
        contentValues.put(PRICE, price);
        contentValues.put(ICON_URL, iconUrl);
        contentValues.put(IS_FAVORITE, isFavorite ? 1 : 0);

        return sqLiteDatabase.insert(COIN_TABLE, null, contentValues) != -1;
    }

    public boolean insertCoin(int id, String name, String symbol, String price, boolean isFavorite) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(SYMBOL, symbol);
        contentValues.put(PRICE, price);
        contentValues.put(IS_FAVORITE, isFavorite ? 1 : 0);

        return sqLiteDatabase.insert(COIN_TABLE, null, contentValues) != -1;
    }

    public boolean insertCoin(int id, String name, String symbol, String price) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(SYMBOL, symbol);
        contentValues.put(PRICE, price);
        contentValues.put(IS_FAVORITE, 0);

        return sqLiteDatabase.insert(COIN_TABLE, null, contentValues) != -1;
    }

    public void updateCoin(String id,String name,String symbol, String price, String iconUrl, boolean isFavorite) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(SYMBOL, symbol);
        contentValues.put(PRICE, price);
        contentValues.put(ICON_URL, iconUrl);
        contentValues.put(IS_FAVORITE, isFavorite ? 1 : 0);

        sqLiteDatabase.update(COIN_TABLE, contentValues, "ID = ?",new String[] { id });
    }

    public void updateCoin(String id,String name,String symbol, String price, boolean isFavorite) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(SYMBOL, symbol);
        contentValues.put(PRICE, price);
        contentValues.put(IS_FAVORITE, isFavorite ? 1 : 0);

        sqLiteDatabase.update(COIN_TABLE, contentValues, "ID = ?",new String[] { id });
    }

    public Integer deleteCoin(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(COIN_TABLE, "ID = ?",new String[] {id});
    }

    public List<DatabaseCoin> getAllCoins() {
        List<DatabaseCoin> coinList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + COIN_TABLE;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseCoin coin = new DatabaseCoin(
                        Integer.parseInt(cursor.getString(0)),  // id
                        cursor.getString(1),                    // name
                        cursor.getString(2),                    // symbol
                        cursor.getString(3),                    // price
                        cursor.getString(4),                    // icon url
                        cursor.getInt(5) > 0);        // favorite

                coinList.add(coin);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return coinList;
    }

    public List<DatabaseCoin> getFavoriteCoins() {
        List<DatabaseCoin> coinList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM " + COIN_TABLE + " WHERE " + IS_FAVORITE + " = 1", null);

        if (cursor.moveToFirst()) {
            do {
                DatabaseCoin coin = new DatabaseCoin(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        Boolean.parseBoolean(cursor.getString(5)));

                coinList.add(coin);
            } while (cursor.moveToNext());
        }

        return coinList;
    }

    public void makeCoinFavorite(DatabaseCoin coin) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE " + COIN_TABLE + " SET " + IS_FAVORITE + " = 1 WHERE ID = " + coin.getId());
    }

    public void makeCoinFavorite(int coinId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE " + COIN_TABLE + " SET " + IS_FAVORITE + " = 1 WHERE ID = " + coinId);
    }

    public void unmakeCoinFavorite(DatabaseCoin coin) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE " + COIN_TABLE + " SET " + IS_FAVORITE + " = 0 WHERE ID = " + coin.getId());
    }

    public void unmakeCoinFavorite(int coinId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE " + COIN_TABLE + " SET " + IS_FAVORITE + " = 0 WHERE ID = " + coinId);
    }

    public void deleteAllCoins() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(COIN_TABLE, null, null);
    }

    public void updateCoinPrice(int id, String price) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(PRICE, price);
        sqLiteDatabase.update(COIN_TABLE, values, ID + "=" + id, null);
    }

    public int getCoinCount() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + COIN_TABLE, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void updateDatabase() {

        String selectQuery = "SELECT * FROM " + COIN_TABLE;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Integer id = Integer.parseInt(cursor.getString(0));

                CoinMarketService service = CoinMarketAPI.getRetrofitInstance().create(CoinMarketService.class);
                Call<TickerResponse> call = service.getTickerInfo(id.toString());
                call.enqueue(new Callback<TickerResponse>() {
                    @Override
                    public void onResponse(Call<TickerResponse> call, Response<TickerResponse> response) {

                        TickerResponse data = response.body();
                        updateCoinPrice(data.getCoin().getId(), data.getCoin().getPrice().get("USD").getPrice());
                    }

                    @Override
                    public void onFailure(Call<TickerResponse> call, Throwable t) {
                        Log.d("update status", "can not upload coin data");
                    }
                });

            } while (cursor.moveToNext());
        }

        cursor.close();
    }
}
