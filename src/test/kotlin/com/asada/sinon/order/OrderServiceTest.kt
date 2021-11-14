package com.asada.sinon.order

import com.asada.sinon.AppConfig
import com.asada.sinon.member.Grade
import com.asada.sinon.member.Member
import com.asada.sinon.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OrderServiceTest {

    private val memberService: MemberService
    private val orderService: OrderService

    init {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.orderService()
    }

    @Test
    fun createOrder() {
        val memberId = 1L
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10000)
        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }

}