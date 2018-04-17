package com.oywy.config

import com.oywy.service.DemoService
import org.springframework.beans.factory.annotation.Autowired

class MyRunner : Runnable {
    @Autowired
    var demoService: DemoService? = null

    override fun run() {
        demoService?.process()
    }

}