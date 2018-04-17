package com.oywy.web.form

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * Created by oywy on 2018/4/16.
 */
data class LoginForm(
        @field:NotBlank(message = "请输入帐号")
        val username: String,
        @field:NotBlank(message = "请输入密码")
        @field:Size(min = 6, max = 8, message = "最小长度6位,最大长度12位")
        val password: String
)