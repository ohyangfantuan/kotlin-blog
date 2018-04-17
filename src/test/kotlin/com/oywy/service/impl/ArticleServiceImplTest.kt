package com.oywy.service.impl

import com.oywy.KotlinBlogApplicationTests
import com.oywy.service.ArticleService
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by oywy on 2018/4/16.
 */
class ArticleServiceImplTest : KotlinBlogApplicationTests() {
    @Autowired
    var articleService: ArticleService? = null

    @Test
    fun getArticle() {
        val article = articleService?.get(2)
        print(article)
    }

}