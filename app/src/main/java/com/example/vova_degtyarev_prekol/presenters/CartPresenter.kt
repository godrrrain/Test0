package com.example.vova_degtyarev_prekol.presenters

import com.example.vova_degtyarev_prekol.Product
import com.example.vova_degtyarev_prekol.ui.CartView
import moxy.MvpPresenter

class CartPresenter : MvpPresenter<CartView>() {
    private val cartMain = mutableListOf(
        Product(price = 350.0, salePercent = 30, productName = "Плюшевый медведь"),
        Product(price = 70.0, salePercent = 50, productName = "Киндер"),
        Product(price = 30.0, salePercent = 50, productName = "Тетрадь 48 листов"),
        Product(price = 90.0, salePercent = 20, productName = "Тетрадь 96 листов"),
        Product(price = 130.0, salePercent = 50, productName = "Рубашка серая XL"),
        Product(price = 135.0, salePercent = 30, productName = "Биг Мак"),
        Product(price = 10.0, salePercent = 35, productName = "Пакет мусорный"),
        Product(price = 190.0, salePercent = 40, productName = "Шаурма с сыром"),
        Product(price = 1030.0, salePercent = 70, productName = "Тетрадь с матаном"),
        Product(price = 4950.0, salePercent = 5, productName = "Сдача матана"),
        Product(price = 2.0, salePercent = 10, productName = "Пожалуйста"),
        Product(price = 200.0, salePercent = 10, productName = "Набор ручек")
    )

    fun setData() {
        viewState.setCategories(cartMain)
    }

    fun removeItem(product: Product) {
        val position = cartMain.indexOf(product)
        cartMain.remove(product)
        viewState.remoteItem(position)
    }
}