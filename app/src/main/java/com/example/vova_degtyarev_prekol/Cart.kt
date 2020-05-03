package com.example.vova_degtyarev_prekol

class Cart(
    private val listOfProducts: List<Product> = mutableListOf()
) {
    fun getList() = listOfProducts

    fun calcFinalPrice(): Double {
        var sum = 0.0
        listOfProducts.forEach {
            sum += it.calcDiscountPrice()
        }
        return sum
    }

    fun calcWithoutDiscountPrice(): Double {
        var sumPrice = 0.0
        listOfProducts.forEach {
            sumPrice += it.getPrice()
        }
        return sumPrice
    }

    fun calcDiscountFullDiscount(): Double {
        return calcWithoutDiscountPrice() - calcFinalPrice()
    }

}