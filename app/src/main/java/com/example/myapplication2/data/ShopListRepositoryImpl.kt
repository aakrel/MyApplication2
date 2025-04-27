package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.domain.ShopItem
import com.example.myapplication.domain.ShopListRepository
import java.util.TreeSet

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFIEND_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
        updateList()
    }

    override fun deleteShopItem(item: ShopItem) {
        shopList.remove(item)
        updateList()
    }

    override fun editShopItem(item: ShopItem) {
        val old = getShopItemById(item.id)
        shopList.remove(old)
        addShopItem(item)
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun getShopItemById(id: Int): ShopItem {
        return shopList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}