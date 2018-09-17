package com.oywy.web.resource

import cn.hutool.core.collection.CollUtil
import cn.hutool.core.util.ObjectUtil
import cn.hutool.http.HttpStatus
import com.oywy.service.ArticleService
import com.oywy.common.ApiResult
import com.oywy.web.form.ArticleForm
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 文章controller
 * Created by oywy on 2018/4/21.
 */
@RestController
@RequestMapping("/article")
class ArticleResource(val articleService: ArticleService) {
    @GetMapping("/{articleId}")
    fun get(@PathVariable(name = "articleId", required = true) articleId: Long): ApiResult {
        val result = articleService.get(articleId)
        return if (ObjectUtil.isNotNull(result))
            ApiResult(result, HttpStatus.HTTP_OK, "获取成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "记录不存在")
    }

    @GetMapping("/list")
    fun list(@RequestParam(required = true) userId: Long): ApiResult {
        val categoryList = articleService.list(userId)
        return if (CollUtil.isEmpty(categoryList))
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "记录不存在")
        else
            ApiResult(categoryList, HttpStatus.HTTP_OK, "获取成功")
    }

    @PostMapping("/save")
    fun save(@Valid articleForm: ArticleForm,bindingResult: BindingResult): ApiResult {
        if (bindingResult.hasErrors())
            return ApiResult(null, HttpStatus.HTTP_NOT_FOUND, bindingResult.allErrors[0].defaultMessage.orEmpty())
        val bool = articleService.save(articleForm)
        return if (bool)
            ApiResult(null, HttpStatus.HTTP_OK, "保存成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "id不存在")
    }

    @DeleteMapping("/{articleId}")
    fun remove(@PathVariable(name = "articleId", required = true) articleId: Long): ApiResult {
        val bool = articleService.remove(articleId)
        return if (bool)
            ApiResult(null, HttpStatus.HTTP_OK, "删除成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "id不存在")
    }
}