package org.seckill.exception;

/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
