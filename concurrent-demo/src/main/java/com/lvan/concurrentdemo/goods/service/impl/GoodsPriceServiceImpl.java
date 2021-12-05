package com.lvan.concurrentdemo.goods.service.impl;

import com.lvan.concurrentdemo.goods.model.Price;
import com.lvan.concurrentdemo.goods.service.GoodsPriceService;

import java.math.BigDecimal;

/**
 * @author Lvan
 * @since 2021/12/4
 */
public class GoodsPriceServiceImpl implements GoodsPriceService {

    @Override
    public Price fetchGoodsPrice(String goodsId) {

        Price price = new Price();
        price.setPrice(BigDecimal.valueOf(100));
        return price;
    }
}
