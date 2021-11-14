package com.asada.sinon.discount

import com.asada.sinon.member.Grade
import com.asada.sinon.member.Member

class FixDiscountPolicy : DiscountPolicy {

    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            discountFixAmount
        } else {
            0
        }
    }
}