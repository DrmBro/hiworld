package org.seckill.exception;

/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
public class SeckillCloseException extends RuntimeException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
