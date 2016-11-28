package com.tl.rpc.order;

import com.facebook.swift.codec.*;

public enum ORDERSTATUS
{
    COMPLETE(1), CANCEL(2);

    private final int value;

    ORDERSTATUS(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
