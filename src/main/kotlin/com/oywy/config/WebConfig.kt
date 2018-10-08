package com.oywy.config

import com.oywy.web.interceptor.AuthInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @author oywy
 * @date 2018/5/12
 */
@Configuration
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
    }

    /**
     * 拦截器注册
     */
    override fun addInterceptors(registry: InterceptorRegistry) {
        with(registry){
            //权限拦截器,排除/admin
            addInterceptor(AuthInterceptor()).excludePathPatterns("/admin/**")
        }
        println("拦截器注册完毕")
    }

}