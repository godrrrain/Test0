package com.example.vova_degtyarev_prekol.ui

import android.os.Bundle
import com.example.vova_degtyarev_prekol.R
import kotlinx.android.synthetic.main.cart_layout.*

class CartActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_layout)

        cartBackButton.setOnClickListener {
            finish()
        }

    }
}