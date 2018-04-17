package com.oywy.service.impl

import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube

/**
 * Created by oywy on 2018/4/17.
 */
fun main(args: Array<String>) {
    print(Color.RED)
}
enum class Color(val code:Int){
    RED(1),YELLOW(2),GREEN(3);

    override fun toString(): String {
        return code.toString()
    }}