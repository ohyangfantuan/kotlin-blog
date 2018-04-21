package com.oywy.web.form

import javax.validation.constraints.NotBlank

/**
 * Created by oywy on 2018/4/21.
 */
data class CommentForm(
        var id: Long?,
        @NotBlank(message = "请选择文章")
        var articleId: Long,
        @NotBlank(message = "请选择父节点")
        var parentId: Long,
        @NotBlank(message = "请输入内容")
        var content: String
        )