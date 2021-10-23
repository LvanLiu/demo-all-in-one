package com.lvan.jsrvalidationdemo;

import org.junit.jupiter.api.Test;

import java.net.URLDecoder;

/**
 * @author lvan
 * @date 2021/10/22
 */
public class Url {

    @Test
    void url() throws Exception{
        String message = "openid=o27sy6lifwiqy9azo-an0t_p8cpy&unionid=ov8ok09rmehqc0zxwbtahgu54k8o&nickname=%e5%88%98%e9%b9%8f%e9%a3%9e&sex=0&province=&city=&country=&headimg=https%3a%2f%2fthirdwx.qlogo.cn%2fmmopen%2fvi_32%2fq0j4twgtftlibbd8shiawh8usm1ic5wpvyvydo5uz5zagt17vibwltzaw7sntnwdvzolfia7vpwa0icjykubeqemmauw%2f132&syscode=0&packagename=com.angogo.stewardvip&isaggdll=0&loc=1&wifi=0&_tid=1634899389%2c278b47ce-1076-444e-a3c7-6c498ef54022";
        String decode = URLDecoder.decode(message, "utf-8");
        System.out.println(decode);
    }
}
