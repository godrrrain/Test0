package com.example.vova_degtyarev_prekol.ui

import android.os.Bundle
import com.example.vova_degtyarev_prekol.R
import kotlinx.android.synthetic.main.details_layout.*

class DetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_layout)

        detailsBackButton.setOnClickListener {
            finish()
        }
    }
}