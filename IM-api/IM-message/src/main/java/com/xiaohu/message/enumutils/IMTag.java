package com.xiaohu.message.enumutils;

import lombok.Data;

/**
 * @PackgeName: com.xiaohu.message.enumutils
 * @ClassName: IMTag
 * @Author: xiaohu
 * Date: 2021/5/6 15:50
 * @Description:
 */
public enum IMTag {

    IM_TAG_USER(0,"用户"),
    IM_TAG_CALL(1,"客服");

    public int tag;
    public String describe;

    IMTag(int tag,String describe){
        this.tag = tag;

        this.describe = describe;
    }
}
