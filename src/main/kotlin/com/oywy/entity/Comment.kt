package com.oywy.entity

import java.util.*

/**
 * 评论
 * Created by oywy on 2018/1/8.
 */
data class Comment(
        //文章
        var articleId: Long? = null,
        //用户
        var userId: Long? = null,
        //父评论
        var pid: Long? = null,
        //内容
        var content: String? = null,
        //标识
        var id: Long? = null,
        //注释
        var remark: String? = null,
        //状态
        var status: Int? = null,
        //创建时间
        var creatTime: Date? = null,
        //创建人标识
        var creatorId: Long? = null,
        //修改时间
        var operateTime: Date? = null,
        //修改人标识
        var operatorId: Long? = null,
        //操作标识
        var operateFlag: Int? = null
)
