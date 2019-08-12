# TaipeiZooPlants
A demo app for Taipei zoo plants.

## 主要架構
* MVVM
* Paging Library
* Retrofit 2
* One Activity, multi Fragments

### **Paging Library**
- 與RecyclerView搭配使用，於列表滑動中動態載入新的資料。
- 每次Request取得資料筆數設定為5。

----

### DataBinding
- 客製化一個BaseBindingRecycler，讓RecyclerView使用起來更方便

----

### UI
- Fragment切換的動畫
- 圖片高度依裝置螢幕比例設置
- 任何長寬大小的數值都使用Multi dimension resource來設置