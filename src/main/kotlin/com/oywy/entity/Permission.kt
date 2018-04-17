package com.oywy.entity

import java.util.*

/**
 * 权限
 * Created by oywy on 2018/1/8.
 */
data class Permission(
        //父权限
        var parentPermission: Permission?,
        //子权限
        var childrenPermission: List<Permission>?,
        //权限名
        var name: String?,
        //菜单标识
        var menu: Int?,
        //统一资源标识符
        var uri: String?,
        //角色集
        var roleList: List<Role>?,
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
