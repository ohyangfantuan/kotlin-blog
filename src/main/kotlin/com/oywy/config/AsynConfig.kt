package com.oywy.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by oywy on 2018/4/10.
 */
@Configuration
class AsynConfig {
    @Bean
    fun pool(): ExecutorService {
        val executor = Executors.newSingleThreadExecutor()
        return executor
    }

    @Bean
    fun runner(): Runnable {
        return MyRunner()
    }
}
