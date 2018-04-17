package com.oywy

import com.oywy.entity.User
import com.oywy.mapper.UserMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinBlogApplicationTests {
    @Autowired
    var userMapper:UserMapper? = null

    @Test
    fun contextLoads() {
    }
}
