package com.oywy.web.resource

import cn.hutool.core.collection.CollUtil
import cn.hutool.core.util.ObjectUtil
import cn.hutool.http.HttpStatus
import com.oywy.service.CommentService
import com.oywy.common.ApiResult
import com.oywy.web.form.CommentForm
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 评论controller
 * Created by oywy on 2018/4/21.
 */
@Controller
@RequestMapping("/comment")
class CommentResource(val commentService: CommentService) {
    @GetMapping("/list")
    fun list(articleId: Long): ApiResult {
        val categoryList = commentService.list(articleId)
        return if (CollUtil.isEmpty(categoryList))
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "记录不存在")
        else
            ApiResult(categoryList, HttpStatus.HTTP_OK, "获取成功")
    }

    @PostMapping("/save")
    fun save(@Valid commentForm: CommentForm, bindingResult: BindingResult): ApiResult {
        if (bindingResult.hasErrors())
            return ApiResult(null, HttpStatus.HTTP_NOT_FOUND, bindingResult.allErrors[0].defaultMessage.orEmpty())
        val bool = commentService.save(commentForm)
        return if (bool)
            ApiResult(null, HttpStatus.HTTP_OK, "保存成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "id不存在")
    }

    @GetMapping("{commentId}")
    fun get(commentId: Long): ApiResult {
        val result = commentService.get(commentId)
        return if (ObjectUtil.isNotNull(result))
            ApiResult(result, HttpStatus.HTTP_OK, "获取成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "记录不存在")
    }

    @DeleteMapping("{commentId}")
    fun remove(@PathVariable(name = "commentId", required = true) commentId: Long): ApiResult {
        val bool = commentService.remove(commentId)
        return if (bool)
            ApiResult(null, HttpStatus.HTTP_OK, "删除成功")
        else
            ApiResult(null, HttpStatus.HTTP_NOT_FOUND, "id不存在")
    }
}