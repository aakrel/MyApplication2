package com.example.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ShopListRepositoryImpl
import com.example.myapplication.domain.DeleteShopItemUseCase
import com.example.myapplication.domain.EditShopItemUseCase
import com.example.myapplication.domain.GetShopListUseCase
import com.example.myapplication.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repos = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repos)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repos)
    private val editShopItemUseCase = EditShopItemUseCase(repos)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(item: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(item)
    }

    fun changeEnableState(item: ShopItem) {
        val newItem = item.copy(enabled = !item.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}