package com.lvan.concurrentdemo.goods.thread;

import com.lvan.concurrentdemo.goods.model.Price;
import com.lvan.concurrentdemo.goods.service.GoodsPriceService;
import com.lvan.concurrentdemo.goods.service.impl.GoodsPriceServiceImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/12/4
 */
public class QueryGoodsPriceThread implements Callable<Price> {

    private String goodsId;
    private final GoodsPriceService goodsPriceService;

    public QueryGoodsPriceThread(String goodsId) {
        this.goodsId = goodsId;
        this.goodsPriceService = new GoodsPriceServiceImpl();
    }

    @Override
    public Price call() throws Exception {
        //模拟SQL查询耗时
        TimeUnit.SECONDS.sleep(1);
        return goodsPriceService.fetchGoodsPrice(goodsId);
    }
}
