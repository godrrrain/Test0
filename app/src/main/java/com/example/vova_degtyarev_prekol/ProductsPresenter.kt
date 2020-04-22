package com.example.vova_degtyarev_prekol

import android.text.TextUtils
import moxy.MvpPresenter

class ProductsPresenter : MvpPresenter<ProductsView>() {
    private val iphoneCase = Product(price = 130.0, salePercent = 30, productName = "iPhone Case")
    private val samsungCase = Product(price = 160.0, salePercent = 40, productName = "Samsung Case")
    private val nokiaCase = Product(price = 100.0, salePercent = 10, productName = "Nokia Case")

    private val cartMain = Cart(listOf(iphoneCase, samsungCase, nokiaCase))


    private val model = CreateOrderModel()

    fun getCart() = cartMain

    fun checkName(text: String) {
        if (!checkSymbols(text)) model.name = text
        viewState.showErrorForName(checkSymbols(text))
    }

    fun checkSurname(text: String) {
        if (!checkSymbols(text)) model.surname = text
        viewState.showErrorForSurname(checkSymbols(text))
    }

    fun checkThirdName(text: String) {
        if (!checkSymbols(text)) model.thirdName = text
        viewState.showErrorForThirdName(checkSymbols(text))
    }

    private fun checkSymbols(text: String): Boolean = text.length < 2


    fun checkMobile(text: String) {
        if (!checkMobileSymbols(text)) model.mobile = text
        viewState.showErrorForMobile(checkMobileSymbols(text))
    }

    private fun checkMobileSymbols(text: String): Boolean {
        if (text.firstOrNull() == '+' && text.length == 12) {
            if (TextUtils.isDigitsOnly(text.subSequence(1, 12))) {
                return false
            }
        } else if (text.firstOrNull() != '+' && text.length == 11) {
            if (TextUtils.isDigitsOnly(text)) {
                return false
            }
        }
        return true
    }


    fun pricePrint() {
        var allPrice: Double = 0.0
        cartMain.getList().forEach { product ->
            allPrice += product.calcDiscountPrice()
        }
        viewState.print(allPrice)
    }

    fun productNamePrint() {
        cartMain.getList().forEach { product ->
            viewState.print(product.getProductName())
        }
    }

    fun productNameWithPricePrint() {
        cartMain.getList().forEach { product ->
            viewState.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }
}