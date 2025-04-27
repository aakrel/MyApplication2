package com.example.myapplication.domain

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository){
    fun deleteShopItem(item: ShopItem){
        shopListRepository.deleteShopItem(item)
    }
}