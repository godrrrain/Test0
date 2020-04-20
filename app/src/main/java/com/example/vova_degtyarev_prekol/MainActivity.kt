package com.example.vova_degtyarev_prekol

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductsView {

    private val presenter = ProductsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iphoneCase = Product(price = 130.0, salePercent = 30, productName = "iPhone Case")
        val samsungCase = Product(price = 160.0, salePercent = 40, productName = "Samsung Case")
        val nokiaCase = Product(price = 100.0, salePercent = 10, productName = "Nokia Case")
        val cartMain = Cart(listOf(iphoneCase, samsungCase, nokiaCase))

        checkoutNumberOfProducts.text = "Товары в корзине(${cartMain.getList().size})"
        checkoutValueOfNumberOfProducts.text = "${cartMain.calcWithoutDiscountPrice()} руб"

        checkoutValueOfDiscount.text = "-${cartMain.calcDiscountFullDiscount()} руб"

        checkoutSumValue.text = "${cartMain.calcFinalPrice()} руб"
        checkoutPay.setOnClickListener {
            Toast.makeText(this, "Переход на страницу оплаты", Toast.LENGTH_SHORT).show()
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
