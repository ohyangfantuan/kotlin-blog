package com.oywy.entity

import java.util.*

/**
 * 用户
 * Created by oywy on 2018/1/8.
 */
data class User(
        //用户名
        var name: String? = null,
        //密码
        var pwd: String? = null,
//        //文章集
//        var articleList: List<Article>?,
//        //评论集
//        var commentList: List<Comment>?,
//        //角色集
//        var roleList: List<Role>?,
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
