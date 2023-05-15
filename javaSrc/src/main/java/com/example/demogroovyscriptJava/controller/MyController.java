package com.example.demogroovyscriptJava.controller;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.io.File;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ChenHao on 2023/5/15 is 17:09.
 *
 * @author tsinglink
 */

@RestController
public class MyController {

    @SneakyThrows
    @GetMapping("/{fileName}")
    @ResponseBody
    public ResponseEntity<Object> get(@PathVariable("fileName") String fileName) {

// 调用带参数的groovy shell时，使用bind绑定数据
        Binding binding = new Binding();
        binding.setProperty("name", "aaa");

        GroovyShell groovyShell = new GroovyShell(binding);
        Object result = groovyShell.evaluate(new File("."+File.separator+"config", fileName+".groovy"));

        return ResponseEntity.ok(result);

    }

}
