/**
 * @(#)ValidationController.java, 2020-12-01.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.controller;

import com.study.my_springboot.bean.pojo.ValidationTestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@RestController
@RequestMapping("/validation")
public class ValidationController {


    @Autowired
    private LocalValidatorFactoryBean globalValidator;

    @PostMapping("/test1")
    public String test1(@RequestBody ValidationTestPojo pojo){
        return "success";
    }

    @PostMapping("/test2")
    public String test2(@Valid @RequestBody ValidationTestPojo pojo){
        return "success";
    }

    @PostMapping("/test5")
    public String test5(@Validated @RequestBody ValidationTestPojo pojo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuffer sb = new StringBuffer();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                sb.append(fieldError.getDefaultMessage());
            }
            return sb.toString();
        }
        return "success";
    }

    @PostMapping("/test3")
    public String test3(@Validated @RequestBody ValidationTestPojo pojo){
        return "success";
    }

    @PostMapping("/test4")
    public String test4(@Validated @RequestBody ValidationTestPojo pojo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuffer sb = new StringBuffer();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                sb.append(fieldError.getDefaultMessage());
            }
            return sb.toString();
        }
        return "success";
    }

    /**
     * bindingResult 只是让校验不通也能到手动校验的过程
     * @param pojo
     * @param bindingResult
     * @return
     */
    @PostMapping("/test6")
    public String test6(@Validated @RequestBody ValidationTestPojo pojo,BindingResult bindingResult){


        Set<ConstraintViolation<ValidationTestPojo>> validate = globalValidator.validate(pojo);
        String result = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
        System.out.println(result);
        return result;
    }


}