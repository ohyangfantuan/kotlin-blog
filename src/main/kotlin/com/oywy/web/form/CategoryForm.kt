package com.oywy.web.form

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * Created by oywy on 2018/4/17.
 */
data class CategoryForm(
        val id: Long?,
        @NotBlank(message = "请输入名称")
        @Size(max = 10, message = "最大长度10位")
        val name: String,
        @NotBlank(message = "请选择父节点")
        val parentId: Long
)