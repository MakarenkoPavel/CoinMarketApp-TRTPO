# CoinMarketApp
# Requirements Document
#### 1 Introduction
**CoinMarketApp** is a cryptocurrency tracker. It will give you access to cryptocurrency rates, coin market cap , detailed cryptocurrency chartsa and crypto news. Moreover it will allow you ti easily see blockchain cryptocurrency prices and price changes, coin market cap and 24hvolume charts, coin details and advanced charts, coin markets, crypto news of your favorite coins and other altcoins including Bitcoin, Etherium, Ripple, Litecoin, IOTA, Cardano, Steller and many more.
#### **Main Features:**
- Monitor **all polular coins** such as Bitcoin, Etherium, Ripple, IOTA and more
- Add coins you like to **Favorites** and to see coin price quickly
- See **detailed coin overview** and **coin markets** (cryptocurrency exchanges)
- View **interactive charts** of coin price for different time ranges agains either popular currencies of Bitcoin

#### 2 User Requirements
##### 2.1 Software Interfaces
**Develupment tools and Technologies:**
- **Android Studio** as comfortable IDE for android development
- **CoinMarketCap** Web API that gives access to all required data
- **Retrofit** REST Client for Java and Android that makes easy to retrieve and upload JSON (or other structured data) via a REST based webservice 
- **SQLite** database for storing historical coins state
- **Picasso** powerful image downloading and caching library for Android
##### 2.2 User Interfaces
Application main window after preloading looks lote **CoinMarket** window. User can get accses to **SetupCoins** window wia edit button from initial window where he can setup favourite coins list. When user press chart button on initial window **CoinsCnart** window will opens where there is detailed info about coins selected from the favorits coins from initial window.
![alt text](https://github.com/b00m-b00m/CoinMarketApp-TRTPO/blob/master/Documents/mockups/CoinMarket.PNG "Application main window")
![alt text](https://github.com/b00m-b00m/CoinMarketApp-TRTPO/blob/master/Documents/mockups/SetupCoins.PNG "Setup coins window")
![alt text](https://github.com/b00m-b00m/CoinMarketApp-TRTPO/blob/master/Documents/mockups/CoinCharts.PNG "Coins chart window")
##### 2.3 User Characteristics
This application is designed for those cryptocurrency traders who always wants to be up to date about cryptocurrency price changes, get flexibility of setting up favorite coin list and get comfortable way of representing historical coin data
#### 3 System Requirements
Android 5.0.x (Lollipop 21 API level) is required or higher versions of Android
##### 3.1 Functional Requirements
Application is consists of three things:
- initial window provides view of all coins marked as favorites, user can get update by scroll down. Toolbar consists of chart and edit buttons.
- edit window where user can setup all favorite coins radio button and back button.
- chart window consists of historical coins chart and scrollable line of selection coins to be charted.
##### 3.1 Non-Functional Requirements
- All application windows should follow common UI design. Mainly white and gray colors
- Error handling with providing of message or trying to recovery working state
##### 3.1.1 SOFTWARE QUALITY ATTRIBUTES

