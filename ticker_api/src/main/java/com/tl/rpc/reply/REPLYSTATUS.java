package com.tl.rpc.reply;

import com.facebook.swift.codec.*;

public enum REPLYSTATUS
{
    OPEN(1), CLOSE(0);

    private final int value;

    REPLYSTATUS(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
