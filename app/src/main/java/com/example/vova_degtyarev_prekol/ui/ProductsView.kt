package com.example.vova_degtyarev_prekol.ui

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProductsView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(price: Double)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(name: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForSurname(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForThirdName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForMobile(visible: Boolean)
}