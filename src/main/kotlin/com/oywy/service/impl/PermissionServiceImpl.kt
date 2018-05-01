package com.oywy.service.impl

import com.oywy.entity.Permission
import com.oywy.mapper.PermissionMapper
import com.oywy.service.PermissionService
import org.springframework.stereotype.Service

/**
 * 权限service实现
 */
@Service
class PermissionServiceImpl(val PermissionMapper: PermissionMapper) : PermissionService {
    override fun list(): List<Permission> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}