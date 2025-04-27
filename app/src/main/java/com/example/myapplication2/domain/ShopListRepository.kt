package com.example.myapplication.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(item: ShopItem)
    fun deleteShopItem(item: ShopItem)
    fun editShopItem(item: ShopItem)
    fun getShopList(): LiveData<List<ShopItem>>
    fun getShopItemById(id:Int):ShopItem
}