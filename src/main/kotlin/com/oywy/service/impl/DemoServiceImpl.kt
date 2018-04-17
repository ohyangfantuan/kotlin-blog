package com.oywy.service.impl

import com.oywy.service.DemoService
import org.springframework.stereotype.Service

/**
 * Created by oywy on 2018/4/10.
 */
@Service
class DemoServiceImpl : DemoService {
    override fun doService() {
        println("执行方法")
        process()
    }
    override fun process(){
        println("执行处理")
    }
}