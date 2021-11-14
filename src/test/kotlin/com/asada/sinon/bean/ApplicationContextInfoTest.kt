package com.asada.sinon.bean

import com.asada.sinon.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest {

    private val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("모든 빈 출력하기")
    fun findAllBean() {
        val beanDefinitionNames = applicationContext.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val bean = applicationContext.getBean(beanDefinitionName)
            println("name = $beanDefinitionName : bean = $bean")
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    fun findAllApplicationBean() {
        val beanDefinitionNames = applicationContext.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName)
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                val bean = applicationContext.getBean(beanDefinitionName)
                println("name = $beanDefinitionName : bean = $bean")
            }
        }
    }

    @Test
    @DisplayName("인프라 빈 출력하기")
    fun findAllInfraBean() {
        val beanDefinitionNames = applicationContext.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName)
            if (beanDefinition.role == BeanDefinition.ROLE_INFRASTRUCTURE) {
                val bean = applicationContext.getBean(beanDefinitionName)
                println("name = $beanDefinitionName : bean = $bean")
            }
        }
    }

}