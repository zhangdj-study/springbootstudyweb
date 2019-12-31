package com.neusiri.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangdj
 * @date 2019/11/20
 */
@Data
@Builder
public class Response<T> implements Serializable {
    /**
     * 返回码
     */
    @ApiModelProperty("返回码")
    private Integer code;

    /**
     * 操作结果信息
     */
    @ApiModelProperty("操作结果信息")
    private String msg;

    /**
     * 返回实体 T
     */
    @ApiModelProperty("返回实体 T")
    private T data;

    /**
     * 判断响应是否成功
     * @return
     */
    public boolean isSuccess(){
        return ResponseEnum.SUCCESS.getCode().equals(this.code);
    }

    public static Response ok(String msg){
        return Response.builder().code(ResponseEnum.SUCCESS.getCode()).msg(msg).build();
    }

    public static <T> Response<T> ok(T data,String msg){
        return Response.<T>builder().code(ResponseEnum.SUCCESS.getCode()).data(data).msg(msg).build();
    }

    public static Response error(String msg){
        return Response.builder().code(ResponseEnum.ERROR.getCode()).msg(msg).build();
    }

    public static <T> Response<T> error(T data,String msg){
        return Response.<T>builder().code(ResponseEnum.ERROR.getCode()).data(data).msg(msg).build();
    }
}
