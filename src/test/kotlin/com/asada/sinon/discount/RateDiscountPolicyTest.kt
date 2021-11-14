package com.asada.sinon.discount

import com.asada.sinon.AppConfig
import com.asada.sinon.member.Grade
import com.asada.sinon.member.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


internal class RateDiscountPolicyTest {

    private val discountPolicy: DiscountPolicy

    init {
        val appConfig = AppConfig()
        discountPolicy = appConfig.discountPolicy()
    }

    @Test
    @DisplayName("VIP 는 10% 할인이 적용되어야 한다")
    fun vip_success() {
        val member = Member(1L, "memberVIP", Grade.VIP)
        val discount = discountPolicy.discount(member, 10000)

        Assertions.assertThat(discount).isEqualTo(1000)
    }

    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다")
    fun vip_fail() {
        val member = Member(2L, "memberBASIC", Grade.BASIC)
        val discount = discountPolicy.discount(member, 10000)

        Assertions.assertThat(discount).isEqualTo(0)
    }

}
