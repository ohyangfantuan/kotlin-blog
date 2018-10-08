package com.oywy.service.impl

import cn.hutool.core.util.ObjectUtil
import com.oywy.constant.OperateFlag
import com.oywy.constant.RecordStatus
import com.oywy.entity.Article
import com.oywy.mapper.ArticleMapper
import com.oywy.mapper.CategoryMapper
import com.oywy.service.ArticleService
import com.oywy.web.form.ArticleForm
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpSession

/**
 * 文章service实现
 * Created by oywy on 2018/4/16.
 */
@Service
class ArticleServiceImpl(
        val articleMapper: ArticleMapper,
        val categoryMapper: CategoryMapper,
        val httpSession: HttpSession) : ArticleService {

    override fun get(articleId: Long): Article {
        return articleMapper.selectById(articleId)
    }

    override fun list(): List<Article> = articleMapper.selectList(null)

    override fun save(articleForm: ArticleForm): Boolean {
        //category校验
        val category = categoryMapper.selectById(articleForm.categoryId)
        if (ObjectUtil.isNull(category))
            return false
        with(Article()) {
            //字段填充
            id = articleForm.id
            categoryId = articleForm.categoryId
            title = articleForm.title
            content = articleForm.content
            operateTime = Date()
            operatorId = httpSession.getAttribute("userId") as Long
            //!id?新增:更新
            return if (ObjectUtil.isNull(id)) {
                creatTime = Date()
                creatorId = operatorId
                operateFlag = OperateFlag.CREATE
                status = RecordStatus.ENABLED
                userId = operatorId
                articleMapper.insert(this) == 1
            } else {
                operateFlag = OperateFlag.UPDATE
                articleMapper.updateById(this) == 1
            }
        }
    }

    override fun remove(articleId: Long): Boolean {
        return articleMapper.deleteById(articleId) == 1
    }
}