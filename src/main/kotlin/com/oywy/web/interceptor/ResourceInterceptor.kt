package com.oywy.web.interceptor

import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.ServletRequestWrapper
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by oywy on 2018/4/17.
 */
class ResourceInterceptor:HandlerInterceptor{
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        TODO()
        return super.preHandle(request, response, handler)
    }
}