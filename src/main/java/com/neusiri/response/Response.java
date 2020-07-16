package com.neusiri.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhangdj
 * @date 2019/11/20
 * 建造者模式的公共响应实体
 */
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

    public Response(ResponseBuilder<T> builder){
        this.code = builder.code;
        this.msg = builder.msg;
        this.data = builder.data;
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

    public Response(){}

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


    public static <T> ResponseBuilder builder(){
        return new ResponseBuilder<T>();
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    static class ResponseBuilder<T>{

        private Integer code;

        private String msg;

        private T data;

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

        public ResponseBuilder code(Integer code){
            this.code = code;
            return this;
        }

        public ResponseBuilder msg(String msg){
            this.msg = msg;
            return this;
        }

        public ResponseBuilder data(T data){
            this.data = data;
            return this;
        }

        public Response build(){
            return new Response(this);
        }
    }

    public static void main(String[] args) {
        Response response = new ResponseBuilder<>().code(99).msg("msg").data("999").build();
        System.out.println(response);
    }
}
