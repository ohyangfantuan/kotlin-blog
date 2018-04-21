package com.oywy.service

import com.oywy.entity.Article
import com.oywy.web.form.ArticleForm

/**
 * 文章service接口
 * Created by oywy on 2018/4/16.
 */
interface ArticleService {
    fun get(articleId: Long): Article
    fun list(userId: Long): List<Article>
    fun save(articleForm: ArticleForm): Boolean
    fun remove(articleId: Long): Boolean
}