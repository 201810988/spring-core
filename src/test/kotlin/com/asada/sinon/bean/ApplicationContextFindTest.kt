package com.asada.sinon.bean

import com.asada.sinon.AppConfig
import com.asada.sinon.member.MemberService
import com.asada.sinon.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextFindTest {
    private val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 이름으로 조회")
    fun findBeanByName() {
        val memberService = applicationContext.getBean("memberService", MemberService::class.java)
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    fun findBeanByType() {
        val memberService = applicationContext.getBean(MemberService::class.java)
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("빈 구체타입으로 조회")
    fun findBeanByName2() {
        val memberService = applicationContext.getBean("memberService", MemberServiceImpl::class.java)
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    fun findBeanByNameX() {
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException::class.java) {
            applicationContext.getBean(
                "...",
                MemberService::class.java
            )
        }
    }

    @Test
    @DisplayName("빈 타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    fun findBeanByTypeDuplicate() {

    }
}