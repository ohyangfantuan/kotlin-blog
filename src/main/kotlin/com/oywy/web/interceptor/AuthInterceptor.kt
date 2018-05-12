package com.oywy.web.interceptor

import cn.hutool.core.util.ObjectUtil
import cn.hutool.http.Method
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author oywy
 * @date 2018/5/12
 */
class AuthInterceptor(
        //必须登入的操作
        private val onlyForLogin: List<String> = listOf(Method.DELETE, Method.POST, Method.PUT).map { it.toString() }
) : HandlerInterceptor {

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        //session
        val session = request.session
        //method
        val method = request.method

        //method 为 必须登录的操作且session中包含userId  或者 method 不为 必须登陆的操作,才允许
        return  method !in onlyForLogin||ObjectUtil.isNotNull(session.getAttribute("userId"))
    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {

    }
}
