package com.asada.sinon.member

import com.asada.sinon.AppConfig
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MemberServiceTest {

    private val memberService: MemberService

    init {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
    }

    @Test
    fun join() {
        val member = Member(1L, "memberA", Grade.VIP)

        memberService.join(member)
        val findMember = memberService.findMember(1L)

        Assertions.assertThat(member).isEqualTo(findMember)
    }

}