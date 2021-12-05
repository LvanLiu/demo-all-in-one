package com.lvan.concurrentdemo.goods.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Lvan
 * @since 2021/12/4
 */
@Getter
@Setter
public class Price {

    /**
     * 商品原价
     */
    private BigDecimal price;
}
