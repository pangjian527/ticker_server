package com.tl.rpc.topic;

import com.facebook.swift.codec.*;

public enum TOPICTYPE
{
    CHARGE(1), FREE(0);

    private final int value;

    TOPICTYPE(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
