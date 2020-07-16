package com.neusiri.response;

import java.io.Serializable;

/**
 * @author zhangdj
 * @date 2020-07-09 18:18
 */
public class AppResponse<T> implements Serializable {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 操作结果信息
     */
    private String msg;

    /**
     * 返回实体 T
     */
    private T data;

    @Override
    public String toString() {
        return "AppResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
