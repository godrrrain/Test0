package com.example.vova_degtyarev_prekol

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    fun formatPrice(price: Double, measure: String = "шт", sale: Int = 0): String {
        if (sale != 0) {
            val discountPrice = price * (100 - sale) / 100
            return "$discountPrice/$measure (скидка $sale%)"

        } else {
            return "$price/$measure"
        }
    }


    @Test
    fun printDiscount() {
        println(formatPrice(price = 123.0, measure = "кг", sale = 5))
    }
}