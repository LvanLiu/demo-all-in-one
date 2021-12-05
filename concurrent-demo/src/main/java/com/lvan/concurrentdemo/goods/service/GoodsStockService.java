package com.lvan.concurrentdemo.goods.service;

import com.lvan.concurrentdemo.goods.model.GoodsStock;

/**
 * @author Lvan
 * @since 2021/12/4
 */
public interface GoodsStockService {

    /**
     * 根据商品id查询商品库存
     */
    GoodsStock fetchGoodsStock(String  goodsId);
}
