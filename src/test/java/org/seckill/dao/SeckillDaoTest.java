package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.service.impl.SeckillServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillDaoTest {

    @Resource
    SeckillDao seckillDao;


    @Test
    public void reduceNumber() {
        System.out.println(seckillDao.reduceNumber(1000L,new Date()));
    }

    @Test
    public void queryById() {
        System.out.println(seckillDao.queryById(1000));
    }

    @Test
    public void queryAll() {
        System.out.println(seckillDao.queryAll(0,4));
    }
}