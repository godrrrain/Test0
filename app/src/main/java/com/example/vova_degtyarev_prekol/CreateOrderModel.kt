package com.example.vova_degtyarev_prekol

/**
 * Модель для создания заказа
 */

data class CreateOrderModel(
    var name: String = "",

    var surname: String = "",

    var thirdName: String = "",

    var mobile: String = ""
) {
}