package com.example.dgsdemokotlin

import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component

@Component
class TracingBeanPostProcessor: BeanPostProcessor {
    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        return bean
    }

    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        println(bean.toString().plus(" - ").plus(beanName))
        return bean
    }
}