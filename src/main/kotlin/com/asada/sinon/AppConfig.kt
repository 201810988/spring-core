package com.asada.sinon

import com.asada.sinon.discount.DiscountPolicy
import com.asada.sinon.discount.FixDiscountPolicy
import com.asada.sinon.discount.RateDiscountPolicy
import com.asada.sinon.member.*
import com.asada.sinon.order.OrderService
import com.asada.sinon.order.OrderServiceImpl
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memberService(): MemberService = MemberServiceImpl(memberRepository())

    @Bean
    fun orderService(): OrderService = OrderServiceImpl(
        memberRepository(),
        fixDiscountPolicy()
    )

    @Bean
    fun discountPolicy(): DiscountPolicy = RateDiscountPolicy()

    @Bean
    fun memberRepository(): MemberRepository = MemoryMemberRepository()

    @Bean
    fun fixDiscountPolicy(): DiscountPolicy = FixDiscountPolicy()
}

fun main(args: Array<String>) {

    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val orderService = applicationContext.getBean("orderService", OrderService::class.java)
    val order = orderService.createOrder(1L, "itemA", 10000)

    println("order = $order")
}
