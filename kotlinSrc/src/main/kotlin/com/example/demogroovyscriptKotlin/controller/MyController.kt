package com.example.demogroovyscriptKotlin.controller

import groovy.lang.Binding
import groovy.lang.GroovyShell
import lombok.SneakyThrows
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class MyController {

    @SneakyThrows
    @GetMapping("/{fileName}")
    @ResponseBody
    fun get(@PathVariable("fileName") fileName: String): ResponseEntity<Any> {

        // 调用带参数的groovy shell时，使用bind绑定数据
        val binding = Binding()
        binding.setProperty("name", "aaa")
        val groovyShell = GroovyShell(binding)
        val result = groovyShell.evaluate(
            File(
                ".${File.separator}config",
                "$fileName.groovy"
            )
        )
        return ResponseEntity.ok(result)
    }


}