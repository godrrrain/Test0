package com.example.vova_degtyarev_prekol

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Lesson4 {

    @Test
    fun example() {

        val iphoneCase = Product(price = 100.0, salePercent = 30)
        val samsungCase = Product(price = 160.0, salePercent = 40)

        val pricePrinter: PricePrinter = ProductionPrintPrice()

        val products = listOf(iphoneCase, samsungCase)
        val discountPrices = products.map { it.calcDiscountPrice() }

        discountPrices.forEach { discountPrice ->
            pricePrinter.print(discountPrice)
        }

        val cartMain = Cart(products)
        pricePrinter.print(cartMain.calcFinalPrice())

    }
}

class Cart(
    private val listOfProducts: List<Product> = emptyList()
) {
    fun calcFinalPrice(): Double {
        var sum = 0.0
        listOfProducts.forEach {
            sum += it.calcDiscountPrice()
        }
        return sum
    }

}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
}

class ProductionPrintPrice : PricePrinter {

    override fun print(price: Double) {
        if (price % 1 == 0.0) {
            println(price.toInt())
        } else {
            println(String.format("%.2f", price))
        }

    }

}