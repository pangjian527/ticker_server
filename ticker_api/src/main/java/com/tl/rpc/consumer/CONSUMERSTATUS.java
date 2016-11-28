package com.tl.rpc.consumer;

import com.facebook.swift.codec.*;

public enum CONSUMERSTATUS
{
    EFFECTIVE(1), INVALID(0);

    private final int value;

    CONSUMERSTATUS(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
