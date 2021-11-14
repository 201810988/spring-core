package com.asada.sinon.order

class Order(
    val memberId: Long,
    val itemName: String,
    val itemPrice: Int,
    val discountPrice: Int,
) {
    /**
     * @return 최종계산금액
     */
    fun calculatePrice() = itemPrice - discountPrice

    override fun toString(): String {
        return "Order(memberId=$memberId, itemName='$itemName', itemPrice=$itemPrice, discountPrice=$discountPrice)"
    }
}