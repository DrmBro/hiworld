package org.seckill.dao;


import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
public interface SeckillDao {


    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);


    Seckill queryById(@Param("SeckillId") long SeckillId);


    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
