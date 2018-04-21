package com.oywy.service

import com.oywy.entity.Category
import com.oywy.entity.Comment
import com.oywy.web.form.CommentForm

/**
 * 评论service接口
 * Created by oywy on 2018/4/21.
 */
interface CommentService {
    fun list(articleId: Long): List<Comment>
    fun save(commentForm: CommentForm): Boolean
    fun get(commentId: Long): Comment
    fun remove(commentId: Long): Boolean
}