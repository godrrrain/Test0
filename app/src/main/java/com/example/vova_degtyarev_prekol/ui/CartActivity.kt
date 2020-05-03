package com.example.vova_degtyarev_prekol.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vova_degtyarev_prekol.Product
import com.example.vova_degtyarev_prekol.R
import com.example.vova_degtyarev_prekol.presenters.CartPresenter
import kotlinx.android.synthetic.main.cart_layout.*

class CartActivity : BaseActivity(), CartView {

    private val presenter = CartPresenter()
    private val adapter = CartListAdapter { product ->
        presenter.removeItem(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_layout)

        cartBackButton.setOnClickListener {
            finish()
        }

        cartListRV.layoutManager = LinearLayoutManager(this)
        cartListRV.adapter = adapter
        presenter.attachView(this)
        presenter.setData()
    }

    override fun setCategories(list: List<Product>) {
        adapter.setData(list)
    }

    override fun remoteItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }
}