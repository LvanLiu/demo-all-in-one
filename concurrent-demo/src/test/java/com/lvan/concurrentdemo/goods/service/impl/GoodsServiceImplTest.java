package com.lvan.concurrentdemo.goods.service.impl;

import com.lvan.concurrentdemo.goods.model.Goods;
import com.lvan.concurrentdemo.goods.service.GoodsService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lvan
 * @since 2021/12/4
 */
@Slf4j
class GoodsServiceImplTest {

    private GoodsService goodsService = new GoodsServiceImpl();

    @SneakyThrows
    @Test
    void fetchGoods() {

        Goods goods = goodsService.fetchGoods("123456");
        System.out.println(goods.getGoodsStock().getCount());
        System.out.println(goods.getPrice().getPrice());
    }
}