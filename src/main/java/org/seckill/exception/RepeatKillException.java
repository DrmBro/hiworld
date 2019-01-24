package org.seckill.exception;

/**
 * Demo class
 *
 * @author Drm
 * @date 2018/12/7
 */
public class RepeatKillException extends RuntimeException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
