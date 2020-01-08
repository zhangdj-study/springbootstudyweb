package com.neusiri;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author zhangdj
 * @date 2020/01/07 17:36
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class Son extends Father{

    private String sonId;

    private String sonName;
}
