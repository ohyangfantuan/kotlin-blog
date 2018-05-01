package com.oywy.service

import com.oywy.entity.Permission

/**
 * 权限service接口
 * Created by oywy on 2018/4/21.
 */
interface PermissionService {
    fun list(): List<Permission>
}
