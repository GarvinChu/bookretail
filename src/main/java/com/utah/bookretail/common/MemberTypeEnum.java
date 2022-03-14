package com.utah.bookretail.common;

import java.util.Objects;

/**
 * 会员级别，1 Coper，2 Silver ，3 Gold
 */
public enum MemberTypeEnum {
    COPER(1, "Coper"),
    SILVER(2, "Silver"),
    GOLD(3, "Gold");

    private int type;
    private String name;

    MemberTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }


    public String getName() {
        return name;
    }

    public static MemberTypeEnum getMemberTypeEnumByType(Integer type) {
        for (MemberTypeEnum memberTypeEnum : MemberTypeEnum.values()) {
            if (Objects.equals(memberTypeEnum.getType(), type)) {
                return memberTypeEnum;
            }

        }
        return COPER;
    }
}
