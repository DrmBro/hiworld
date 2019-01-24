package org.seckill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.seckill.SeckillStatEnum;
import org.seckill.entity.SuccessKilled;

@Data
@AllArgsConstructor
@ToString
/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
public class SeckillExecution {

    private long seckillId;

    private int state;

    private String stateInfo;

    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
    }
}
