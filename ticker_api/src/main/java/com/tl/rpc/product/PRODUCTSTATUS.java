package com.tl.rpc.product;

import com.facebook.swift.codec.*;

public enum PRODUCTSTATUS
{
    SALE(0), OPEN(1);

    private final int value;

    PRODUCTSTATUS(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
