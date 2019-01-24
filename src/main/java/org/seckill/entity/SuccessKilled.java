package org.seckill.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
public class SuccessKilled {
    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

    private Seckill seckill;

}
