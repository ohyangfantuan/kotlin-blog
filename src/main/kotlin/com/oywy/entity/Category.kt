package com.oywy.entity

import java.util.*

/**
 * 文章类目
 * Created by oywy on 2018/1/8.
 */
data class Category(
//        父类目
        var pid: Long? = null,
//        var parentCategory: Category?,
//        //子类目
//        var childrenCategory: List<Category>?,
//        //用户
//        var user: User? = null,
        //用户
        var userId: Long? = null,
//        //文章集
//        var articleList: List<Article>?,
        //类目名
        var name: String? = null,
        //标识
        var id: Long? = null,
        //注释
        var remark: String? = null,
        //状态
        var status: Int? = null,
        //创建时间
        var createTime: Date? = null,
        //创建人标识
        var creatorId: Long? = null,
        //修改时间
        var operateTime: Date? = null,
        //修改人标识
        var operatorId: Long? = null,
        //操作标识
        var operateFlag: Int? = null

)
