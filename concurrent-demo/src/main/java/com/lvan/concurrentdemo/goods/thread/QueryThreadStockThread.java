package com.lvan.concurrentdemo.goods.thread;

import com.lvan.concurrentdemo.goods.model.GoodsStock;
import com.lvan.concurrentdemo.goods.service.GoodsStockService;
import com.lvan.concurrentdemo.goods.service.impl.GoodsStockServiceImpl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/12/4
 */
public class QueryThreadStockThread implements Callable<GoodsStock> {

    private String goodsId;
    private final GoodsStockService goodsStockService;

    public QueryThreadStockThread(String goodsId) {
        this.goodsId = goodsId;
        this.goodsStockService = new GoodsStockServiceImpl();
    }

    @Override
    public GoodsStock call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return goodsStockService.fetchGoodsStock(goodsId);
    }
}
