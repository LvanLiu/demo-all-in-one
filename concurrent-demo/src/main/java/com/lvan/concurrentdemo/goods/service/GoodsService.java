package com.lvan.concurrentdemo.goods.service;

import com.lvan.concurrentdemo.goods.model.Goods;

import java.util.concurrent.ExecutionException;

/**
 * @author Lvan
 * @since 2021/12/4
 */
public interface GoodsService {

    /**
     * 根据商品id查询商品信息
     */
    Goods fetchGoods(String goodsId) throws ExecutionException, InterruptedException;
}
