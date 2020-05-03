package com.example.vova_degtyarev_prekol.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.vova_degtyarev_prekol.R
import com.example.vova_degtyarev_prekol.presenters.ProductsPresenter
import com.example.vova_degtyarev_prekol.ui.CatalogActivity.Companion.IS_USER_AUTH
import com.example.vova_degtyarev_prekol.ui.CatalogActivity.Companion.PRODUCT_ID
import com.example.vova_degtyarev_prekol.ui.CatalogActivity.Companion.REQUEST_AUTH
import kotlinx.android.synthetic.main.activity_main.*

class CheckoutActivity : BaseActivity(),
    ProductsView {

    private val presenter =
        ProductsPresenter()
    private var isAuth: Boolean = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productId = intent.extras?.getInt(PRODUCT_ID, -1)
        Log.d(tag, productId.toString())

        checkoutNumberOfProducts.text = "Товары в корзине(${presenter.getCart().getList().size})"
        checkoutValueOfNumberOfProducts.text =
            "${presenter.getCart().calcWithoutDiscountPrice()} руб"

        checkoutValueOfDiscount.text = "-${presenter.getCart().calcDiscountFullDiscount()} руб"

        checkoutSumValue.text = "${presenter.getCart().calcFinalPrice()} руб"
        checkoutPay.setOnClickListener {
            isAuth = true
            setResult(REQUEST_AUTH, Intent().apply {
                putExtra(IS_USER_AUTH, isAuth)
            })
            Toast.makeText(this, "Переход на страницу оплаты", Toast.LENGTH_SHORT).show()
        }

        checkoutBackButton.setOnClickListener {
            finish()
        }


        presenter.attachView(this)

        setListeners()

    }

    private fun setListeners() {
        checkoutPersonalDataSurname.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkSurname(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPersonalDataName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPersonalDataThirdName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkThirdName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPersonalDataMobile.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkMobile(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price: $price", Toast.LENGTH_LONG).show()
    }

    override fun print(name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun EditText.showError(visible: Boolean) {
        val drawable = if (visible) R.drawable.ic_error
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)

    }

    override fun showErrorForSurname(visible: Boolean) {
        checkoutPersonalDataSurname.showError(visible)
    }

    override fun showErrorForName(visible: Boolean) {
        checkoutPersonalDataName.showError(visible)
    }

    override fun showErrorForThirdName(visible: Boolean) {
        checkoutPersonalDataThirdName.showError(visible)
    }

    override fun showErrorForMobile(visible: Boolean) {
        checkoutPersonalDataMobile.showError(visible)
    }

}
