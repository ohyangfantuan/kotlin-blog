package com.oywy.service.impl

import cn.hutool.core.util.ObjectUtil
import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.oywy.constant.OperateFlag
import com.oywy.constant.RecordStatus
import com.oywy.entity.Comment
import com.oywy.mapper.CommentMapper
import com.oywy.service.CommentService
import com.oywy.web.form.CommentForm
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpSession

/**
 * 评论service实现
 */
@Service
class CommentServiceImpl(
        val commentMapper: CommentMapper,
        val httpSession: HttpSession
) : CommentService {
    override fun list(articleId: Long): List<Comment> {
        return commentMapper.selectList(EntityWrapper<Comment>().eq("article_id", articleId))
    }

    override fun save(commentForm: CommentForm): Boolean {
        with(Comment()) {
            //字段填充
            id = commentForm.id
            articleId = commentForm.articleId
            pid = commentForm.parentId
            content = commentForm.content
            operateTime = Date()
            operatorId = httpSession.getAttribute("userId") as Long
            //!id?新增:更新
            return if (ObjectUtil.isNull(id)) {
                creatTime = Date()
                creatorId = operatorId
                operateFlag = OperateFlag.CREATE
                status = RecordStatus.ENABLED
                commentMapper.insert(this) == 1
            } else {
                operateFlag = OperateFlag.UPDATE
                commentMapper.updateById(this) == 1
            }
        }
    }

    override fun get(commentId: Long): Comment {
        return commentMapper.selectById(commentId)
    }

    override fun remove(commentId: Long): Boolean {
        return commentMapper.deleteById(commentId) == 1
    }
}