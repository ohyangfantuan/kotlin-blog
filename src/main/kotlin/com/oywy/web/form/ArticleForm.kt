package com.oywy.web.form

import javax.validation.constraints.NotBlank

/**
 * Created by oywy on 2018/4/21.
 */
data class ArticleForm (
        var id: Long?,
        @NotBlank(message = "请选择类目")
        var categoryId: Long,
        @NotBlank(message = "请输入标题")
        var title: String,
        @NotBlank(message = "请输入内容")
        var content: String
)