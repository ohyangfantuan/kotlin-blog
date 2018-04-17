package com.oywy.web.resource

import cn.hutool.core.collection.CollUtil
import cn.hutool.core.util.ObjectUtil
import cn.hutool.http.HttpStatus
import com.oywy.service.CategoryService
import com.oywy.util.ApiResult
import com.oywy.web.form.CategoryForm
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 文章类目controller
 * Created by oywy on 2018/4/16.
 */
@RestController
@RequestMapping("/category")
class CategoryResource(val categoryService: CategoryService) {
    @GetMapping("/list")
    fun list(@RequestParam(defaultValue = "0") pid: Long): ApiResult {
        val categoryList = categoryService.list(pid)
        return if (CollUtil.isEmpty(categoryList))
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "没有子节点")
        else
            ApiResult(categoryList, HttpStatus.HTTP_OK, "获取成功")
    }

    @PostMapping("/save")
    fun save(@Valid categoryForm: CategoryForm, bindingResult: BindingResult): ApiResult {
        if (bindingResult.hasErrors())
            return ApiResult(null, HttpStatus.HTTP_NOT_FOUND, bindingResult.allErrors[0].defaultMessage.orEmpty())
        val bool = categoryService.save(categoryForm)
        return if (bool)
            ApiResult(null, HttpStatus.HTTP_OK, "保存成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "id不存在")
    }

    @GetMapping("/{categoryId}")
    fun get(@PathVariable(name = "categoryId", required = true) categoryId: Long): ApiResult {
        val result = categoryService.get(categoryId)
        return if (ObjectUtil.isNotNull(result))
            ApiResult(result, HttpStatus.HTTP_OK, "获取成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "记录不存在")
    }

    @DeleteMapping("/{categoryId}")
    fun remove(@PathVariable(name = "categoryId", required = true) categoryId: Long): ApiResult {
        val bool = categoryService.remove(categoryId)
        return if (bool)
            ApiResult(null, HttpStatus.HTTP_OK, "删除成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "id不存在")
    }
}
