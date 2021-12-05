package com.lvan.concurrentdemo.goods.service;

import com.lvan.concurrentdemo.goods.model.Price;

/**
 * @author Lvan
 * @since 2021/12/4
 */
public interface GoodsPriceService {

    /**
     * 根据商品id获取商品价格
     */
    Price fetchGoodsPrice(String goodsId);
}
