package com.oywy.service

import com.oywy.entity.Category
import com.oywy.web.form.CategoryForm

/**
 * 文章类目service接口
 * Created by oywy on 2018/4/16.
 */
interface CategoryService {
    fun list(pid: Long): List<Category>
    fun save(categoryForm: CategoryForm): Boolean
    fun get(categoryId: Long): Category
    fun remove(categoryId: Long): Boolean
}