package com.example.vova_degtyarev_prekol.presenters

import com.example.vova_degtyarev_prekol.ui.CatalogView
import moxy.MvpPresenter

class CatalogPresenter : MvpPresenter<CatalogView>() {

    private val list = mutableListOf("Телевизоры", "Телефоны", "Планшеты", "Часы")

    fun setData() {
        viewState.setCategories(list)
    }

    fun removeItem(category: String) {
        val position = list.indexOf(category)
        list.remove(category)
        viewState.remoteItem(position)
    }

}