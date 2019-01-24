package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
@SuppressWarnings({"ALL", "AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc"})
public interface SeckillService {

    /**
     * fetch data by rule id
     *
     * @return List
     */
    List<Seckill> getSeckillList();

    /**
     * fetch data by rule id
     *
     * @param seckillId
     * @return Seckill
     */
    Seckill getById(long seckillId);

    /**
     * fetch data by rule id
     *
     * @param seckillId
     * @return Exposer
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * fetch data by rule id
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return SeckillExecution
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws RepeatKillException, SeckillCloseException, SeckillException;
}
