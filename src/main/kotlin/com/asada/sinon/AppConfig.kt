package com.asada.sinon

import com.asada.sinon.discount.DiscountPolicy
import com.asada.sinon.discount.FixDiscountPolicy
import com.asada.sinon.discount.RateDiscountPolicy
import com.asada.sinon.member.*
import com.asada.sinon.order.OrderService
import com.asada.sinon.order.OrderServiceImpl

class AppConfig {

    fun memberService(): MemberService = MemberServiceImpl(memberRepository())

    fun orderService(): OrderService = OrderServiceImpl(
        memberRepository(),
        fixDiscountPolicy()
    )

    fun discountPolicy(): DiscountPolicy = RateDiscountPolicy()

    fun memberRepository(): MemberRepository = MemoryMemberRepository()

    fun fixDiscountPolicy(): DiscountPolicy = FixDiscountPolicy()
}

fun main(args: Array<String>) {
    val appConfig = AppConfig()

    val memberService = appConfig.memberService()
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val orderService = appConfig.orderService()
    val order = orderService.createOrder(1L, "itemA", 10000)

    println("order = $order")
}
