package com.oywy.config

import com.baomidou.mybatisplus.plugins.PaginationInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by oywy on 2018/3/13.
 */
@Configuration
@MapperScan("com.oywy.mapper")
class MybatisPlusConfig
