package com.oywy.web.resource

import cn.hutool.http.HttpStatus
import com.oywy.util.ApiResult
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
class AdminResource {
    @PostMapping("/login")
    fun login(@Valid loginForm: LoginForm, bindingResult: BindingResult, httpSession: HttpSession): ApiResult {
        return if (bindingResult.hasErrors())
            ApiResult(null, HttpStatus.HTTP_BAD_REQUEST, bindingResult.allErrors[0].defaultMessage.orEmpty())
        else {
            httpSession.setAttribute("userId", 1L)
            ApiResult(null, HttpStatus.HTTP_OK, "登陆成功")
        }
    }

    @GetMapping("/logout")
    fun logout(): ApiResult {
        TODO()
    }
}