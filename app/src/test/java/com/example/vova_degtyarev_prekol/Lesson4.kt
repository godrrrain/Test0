package com.example.vova_degtyarev_prekol

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Lesson4 {

    private val cartPresenter = CartPresenter()
    @Test
    fun example() {
        cartPresenter.cartFullPrint()
    }
}

class CartPresenter {
    private val iphoneCase = Product(price = 130.0, salePercent = 30, productName = "iPhone Case")
    private val samsungCase = Product(price = 160.0, salePercent = 40, productName = "Samsung Case")
    private val nokiaCase = Product(price = 100.0, salePercent = 10, productName = "Nokia Case")

    private val pricePrinter: PricePrinter = ProductionPrintPrice()

    private val cartMain = Cart(listOf(iphoneCase, samsungCase, nokiaCase))

    fun cartFullPrint() {
        cartMain.getList().forEach { product ->
            pricePrinter.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
        pricePrinter.print(cartMain.calcFinalPrice())
    }

}

class Cart(
    private val listOfProducts: List<Product> = emptyList()
) {
    fun getList() = listOfProducts

    fun calcFinalPrice(): Double {
        var sum = 0.0
        listOfProducts.forEach {
            sum += it.calcDiscountPrice()
        }
        return sum
    }

}

class ProductPresenter {
    private val iphoneCase = Product(price = 130.0, salePercent = 30, productName = "iPhone Case")
    private val samsungCase = Product(price = 160.0, salePercent = 40, productName = "Samsung Case")

    private val pricePrinter: PricePrinter = ProductionPrintPrice()

    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint() {
        products.forEach { product ->
            pricePrinter.print(product.calcDiscountPrice())
        }
    }

    fun productNamePrint() {
        products.forEach { product ->
            pricePrinter.print(product.getProductName())
        }
    }

    fun productNameWithPricePrint() {
        products.forEach { product ->
            pricePrinter.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }

}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val productName: String = "unknown"
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)

    fun getProductName(): String = productName
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)

    fun print(name: String)
}

class ProductionPrintPrice : PricePrinter {

    override fun print(price: Double) {
        if (price % 1 == 0.0) {
            println(price.toInt())
        } else {
            println(String.format("%.2f", price))
        }

    }

    override fun print(name: String) {
        println(name)
    }

}