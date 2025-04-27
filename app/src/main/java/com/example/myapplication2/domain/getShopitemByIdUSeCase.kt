package com.example.myapplication.domain

class getShopitemByIdUSeCase (private val shopListRepository: ShopListRepository){
    fun getShopItemById(id:Int):ShopItem{
        return shopListRepository.getShopItemById(id)
    }
}