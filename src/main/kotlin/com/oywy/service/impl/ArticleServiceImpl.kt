package com.oywy.service.impl

import com.oywy.entity.Article
import com.oywy.mapper.ArticleMapper
import com.oywy.service.ArticleService
import org.springframework.stereotype.Service

/**
 * 文章service实现
 * Created by oywy on 2018/4/16.
 */
@Service
class ArticleServiceImpl(val articleMapper: ArticleMapper) : ArticleService {

    override fun get(articleId: Long): Article {
        return articleMapper.selectById(articleId)
    }

    override fun list(userId: Long): List<Article> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(article: Article): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(articleId: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}