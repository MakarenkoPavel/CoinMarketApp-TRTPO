# Use Case
---
![UseCase](https://github.com/b00m-b00m/CoinMarketApp-TRTPO/blob/master/Documents/usecase/Flow_of_event.PNG)
# 1 Actors

| Actor | Description |
|:--|:--|
| User | person that uses application |

# 2 Use cases
## 2.1 Add coin to favorite list
1. Starts when user press edit button from main window
2. User make changes to local database by changing state of radio buttons of appropriate coins
3. Application saves data every time user changed radio button
4. User may go back to main window by pressing back button

## 2.2 Update coin price info
1. Starts when user scrolls down main window 
2. Application makes request to server by public API
3. Server may response successfully or inform about some failure happens, or don't response at all
4. In case of some failure or absence of response application inform user about error by message and previous successfully updated datas will be uses

## 2.3 Show favorite coins price
1. Starts when user login in application
2. Application make request to local database
3. Data from database will be shown in list view

## 2.4 Show datailed coins charts
1. Starts when user press chart button from main window
2. Application make request to local database
3. Data from database will be shown in specific chart view
4. User may add coin to chart view by 
5. User may remove coin from chart
