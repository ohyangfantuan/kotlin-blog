package com.oywy.mapper

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.oywy.entity.*
import org.springframework.stereotype.Repository

/**
 * Created by oywy on 2018/4/13.
 */
@Repository
interface ArticleMapper : BaseMapper<Article>

@Repository
interface CategoryMapper : BaseMapper<Category>

@Repository
interface CommentMapper : BaseMapper<Comment>

@Repository
interface PermissionMapper : BaseMapper<Permission>

@Repository
interface RoleMapper : BaseMapper<Role>

@Repository
interface UserMapper : BaseMapper<User>