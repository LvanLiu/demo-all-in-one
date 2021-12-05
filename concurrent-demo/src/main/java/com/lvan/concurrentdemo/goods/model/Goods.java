package com.lvan.concurrentdemo.goods.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Lvan
 * @since 2021/12/4
 */
@Setter
@Getter
public class Goods {

    private Price price;
    private GoodsStock goodsStock;
}
