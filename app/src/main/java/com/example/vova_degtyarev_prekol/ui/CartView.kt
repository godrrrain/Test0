package com.example.vova_degtyarev_prekol.ui

import com.example.vova_degtyarev_prekol.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CartView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCategories(list: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun remoteItem(position: Int)
}