package com.oywy.web.resource

import cn.hutool.http.HttpStatus
import com.oywy.service.UserService
import com.oywy.common.ApiResult
import com.oywy.web.form.LoginForm
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession
import javax.validation.Valid

/**
 * 后台管理controller
 * Created by oywy on 2018/4/16.
 */
@RestController
@RequestMapping("/admin")
class AdminResource(val userService: UserService) {
    @PostMapping("/login")
    fun login(@Valid loginForm: LoginForm, bindingResult: BindingResult, httpSession: HttpSession): ApiResult {
        return if (bindingResult.hasErrors())
            ApiResult(null, HttpStatus.HTTP_BAD_REQUEST, bindingResult.allErrors[0].defaultMessage.orEmpty())
        else {
            val user = userService.getByUserName(loginForm.username)
            when {
                user == null -> ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "用户名不正确")
                loginForm.password == user.pwd -> {
                    httpSession.setAttribute("userId", user.id)
                    ApiResult(null, HttpStatus.HTTP_OK, "登陆成功")
                }
                else -> ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "密码不正确")
            }
        }
    }

    @GetMapping("/logout")
    fun logout(httpSession: HttpSession): ApiResult {
        return if (httpSession.getAttribute("userId") == null)
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "你丫就没登陆")
        else {
            httpSession.invalidate()
            ApiResult(null, HttpStatus.HTTP_OK, "登出成功")
        }
    }
}