package org.seckill.dto;/**
 * @Author: Drm
 * @Description:
 * @Date: Created in 22:13 2018/12/8
 * @Modified By:
 */

import lombok.Data;

/**
 * @Description //TODO
 * @Author Drm
 * @Date $ $
 **/
@Data
public class SeckillResult<T> {
    private boolean success;

    private T data;

    private String error;

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
