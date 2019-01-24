package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SuccessKilled;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuccessKilledDaoTest {

    @Resource
    SuccessKilledDao successKilledDao;

    @Autowired
    SeckillService seckillService;

    @Test
    public void insertSuccessKilled() {
        System.out.println(successKilledDao.insertSuccessKilled(1002L,13520152015L));
    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            long phone = 13501520152L;
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
            System.out.println(execution);
        }else{
            System.out.println(exposer);
        }
    }
}