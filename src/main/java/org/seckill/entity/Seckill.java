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
public class Seckill {

    private long seckillId;

    private String name;

    private int number;

    private Date startTime;

    private Date endTime;

    private Date createTime;



}
