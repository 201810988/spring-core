package com.asada.sinon.discount

import com.asada.sinon.member.Member

interface DiscountPolicy {

    /**
     * @return 할인 금액
     */
    fun discount(member: Member, price: Int): Int
}