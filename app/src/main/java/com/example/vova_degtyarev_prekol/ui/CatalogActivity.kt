package com.example.vova_degtyarev_prekol.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vova_degtyarev_prekol.R
import com.example.vova_degtyarev_prekol.presenters.CatalogPresenter
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity : BaseActivity(), CatalogView {

    private val presenter =
        CatalogPresenter()
    private val adapter = CategoryAdapter { category ->
        presenter.removeItem(category)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        catalogCheckoutButton.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java).apply {
                putExtra(PRODUCT_ID, 1000)
            }
            startActivityForResult(intent, REQUEST_AUTH)
        }

        categoryRV.layoutManager = LinearLayoutManager(this)
        categoryRV.adapter = adapter
        presenter.attachView(this)
        presenter.setData()

        catalogCartButton.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (REQUEST_AUTH == requestCode) {
            val isUserAuth = data?.extras?.getBoolean(IS_USER_AUTH)
            Log.d(tag, isUserAuth.toString())
        }
    }

    override fun setCategories(list: List<String>) {
        adapter.setData(list)
    }

    override fun remoteItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 10
        const val IS_USER_AUTH = "IS_USER_AUTH"
    }
}

