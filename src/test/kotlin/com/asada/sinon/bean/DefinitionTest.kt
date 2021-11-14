package com.asada.sinon.bean

import com.asada.sinon.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class DefinitionTest {

    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    fun findApplicationBean() {
        val beanDefinitionNames = applicationContext.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName)

            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                println("beanDefinition = $beanDefinition")
            }
        }
    }
}