package com.oywy.service.impl

import cn.hutool.core.util.ObjectUtil
import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.oywy.constant.OperateFlag
import com.oywy.constant.RecordStatus
import com.oywy.web.form.CategoryForm
import com.oywy.entity.Category
import com.oywy.mapper.CategoryMapper
import com.oywy.service.CategoryService
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpSession

/**
 * 文章类目service实现
 * Created by oywy on 2018/4/16.
 */
@Service
class CategoryServiceImpl(val categoryMapper: CategoryMapper, val httpSession: HttpSession) : CategoryService {
    override fun list(pid: Long): List<Category> {
        return categoryMapper.selectList(EntityWrapper<Category>().eq("pid", pid))
    }

    override fun save(categoryForm: CategoryForm): Boolean {
        with(Category()) {
            //字段填充
            id = categoryForm.id
            name = categoryForm.name
            pid = categoryForm.parentId
            operateTime = Date()
            operatorId = httpSession.getAttribute("userId") as Long
            //!id?新增:更新
            return if (ObjectUtil.isNull(id)) {
                creatTime = Date()
                creatorId = operatorId
                operateFlag = OperateFlag.CREATE
                status = RecordStatus.ENABLED
                userId = operatorId
                categoryMapper.insert(this) == 1
            } else {
                operateFlag = OperateFlag.UPDATE
                categoryMapper.updateById(this) == 1
            }
        }

    }

    override fun remove(categoryId: Long): Boolean {
        //这个考虑,还是真删吧
        return categoryMapper.deleteById(categoryId) == 1
    }
}