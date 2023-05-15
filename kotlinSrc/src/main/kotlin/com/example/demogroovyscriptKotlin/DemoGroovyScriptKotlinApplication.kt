package com.example.demogroovyscriptKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class TsinglinkSyDataApplication


fun main(args: Array<String>) {

    val runApplication = runApplication<TsinglinkSyDataApplication>(*args)


    println("################### 项目成功启动 ###################")

}