package com.dream.xqt.enums;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 23:22
 */
public enum UUIDBizTypeEnum {
    USER_ID(101, "用户id"),
    ;

    /**
     * 类型
     */
    private final Integer type;

    /**
     * 描述
     */
    private final String desc;

    UUIDBizTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
