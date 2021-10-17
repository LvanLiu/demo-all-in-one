package com.lvan.jpademo.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Lvan
 * @since 2021/10/14
 */
class SpElTest {

    @Test
    void test() {
        String code = "any string";
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression(code);
        String value = (String) expression.getValue();
        System.out.println(value);
    }
}
