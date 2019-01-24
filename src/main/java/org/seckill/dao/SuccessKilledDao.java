package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
public interface SuccessKilledDao {

    /**
     * fetch data by rule id
     *
     * @param seckillId
     * @param userPhone
     * @return int
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * fetch data by rule id
     *
     * @param seckillId
     * @param userPhone
     * @return SuccessKilled
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
