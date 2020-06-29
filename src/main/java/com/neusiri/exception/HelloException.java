package com.neusiri.exception;

/**
 * @author zhangdj
 * @date 2020-06-15 17:08
 */
public class HelloException extends RuntimeException{
    public HelloException() {
        super("有点异常");
    }
}
