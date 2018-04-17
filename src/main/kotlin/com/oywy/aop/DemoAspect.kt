package com.oywy.aop

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

/**
 * Created by oywy on 2018/4/10.
 */
@Aspect
@Component
class DemoAspect {
    @Before("execution(* com.oywy.service.impl.*.*(..))")
    fun doAspect() {
        println("执行方法前")
    }
}