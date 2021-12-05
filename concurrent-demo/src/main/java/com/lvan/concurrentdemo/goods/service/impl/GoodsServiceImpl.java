package com.lvan.concurrentdemo.goods.service.impl;

import com.lvan.concurrentdemo.goods.model.Goods;
import com.lvan.concurrentdemo.goods.model.GoodsStock;
import com.lvan.concurrentdemo.goods.model.Price;
import com.lvan.concurrentdemo.goods.service.GoodsService;
import com.lvan.concurrentdemo.goods.thread.QueryGoodsPriceThread;
import com.lvan.concurrentdemo.goods.thread.QueryThreadStockThread;
import lombok.SneakyThrows;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Lvan
 * @since 2021/12/4
 */
public class GoodsServiceImpl implements GoodsService {

    private static final ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(2);
    }

    @SneakyThrows
    @Override
    public Goods fetchGoods(String goodsId) {

        Future<Price> goodsPriceFuture = executorService.submit(new QueryGoodsPriceThread(goodsId));
        Future<GoodsStock> goodsStockFuture = executorService.submit(new QueryThreadStockThread(goodsId));

        Price price = goodsPriceFuture.get();
        GoodsStock goodsStock = goodsStockFuture.get();

        Goods goods = new Goods();
        goods.setGoodsStock(goodsStock);
        goods.setPrice(price);

        return goods;
    }
}
