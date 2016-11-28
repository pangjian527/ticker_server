package com.tl.rpc.topic;

import com.facebook.swift.codec.*;

public enum TOPICSTATUS
{
    OPEN(1), CLOSE(0);

    private final int value;

    TOPICSTATUS(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
