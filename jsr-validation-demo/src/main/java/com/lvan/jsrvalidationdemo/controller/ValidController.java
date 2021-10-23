package com.lvan.jsrvalidationdemo.controller;

import com.lvan.jsrvalidationdemo.model.LoginInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lvan
 * @date 2021/10/22
 */
@RestController
@RequestMapping
public class ValidController {

    /**
     * 产生 MissingServletRequestParameterException 条件：
     * - 使用了@RequestParam注解
     * - 缺失必填参数
     */
    @GetMapping("missingServletRequestParameter")
    public void missingServletRequestParameterException(@RequestParam String account, @RequestParam String password) {
    }

    /**
     * 产生 BindException 条件：
     * - 没有使用@RequestParam注解，但使用了@Valid注解,
     * - 必填参数缺失
     */
    @GetMapping("bindException")
    public void bindException(@Valid LoginInfo loginInfo) {
    }

    /**
     * 产生 MethodArgumentNotValidException 条件：
     * - 使用了@RequestBody 以及 @Valid注解，
     * - 必填参数缺失
     */
    @PostMapping("methodArgumentNotValidException")
    public void methodArgumentNotValidException(@RequestBody @Valid LoginInfo loginInfo) {
    }

    /**
     * 产生 HttpMessageNotReadableException 条件：
     * - 使用了@RequestBody 但是请求时不传body, 或者空json( {} )
     */
    @PostMapping("httpMessageNotReadableException")
    public void httpMessageNotReadableException(@RequestBody LoginInfo loginInfo) {
    }

    /**
     * 产生 ConstraintViolationException 条件：
     * - 使用了@Validated注解（SpringBoot提供），
     * - 缺失必填参数
     */
    @GetMapping("constraintViolationException")
    public void constraintViolationException(@Validated LoginInfo loginInfo) {
    }
}
