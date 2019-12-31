package com.neusiri.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangdj
 * @date 2019/11/20
 */
@AllArgsConstructor
@Getter
public enum ResponseEnum {

    /**
     * 操作成功 返回0
     */
    SUCCESS(0),

    /**
     * 操作失败 返回-1
     */
    ERROR(-1);
    /**
     * 操作代码
     */
    private Integer code;
}
