package com.lvan.concurrentdemo.goods.service.impl;

import com.lvan.concurrentdemo.goods.model.GoodsStock;
import com.lvan.concurrentdemo.goods.service.GoodsStockService;

/**
 * 商品库存服务。
 *
 * @author Lvan
 * @since 2021/12/4
 */
public class GoodsStockServiceImpl implements GoodsStockService {

    @Override
    public GoodsStock fetchGoodsStock(String goodsId) {

        GoodsStock goodsStock = new GoodsStock();
        goodsStock.setCount(100);

        return goodsStock;
    }
}
