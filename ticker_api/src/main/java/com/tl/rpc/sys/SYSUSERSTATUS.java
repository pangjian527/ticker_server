package com.tl.rpc.sys;

import com.facebook.swift.codec.*;

public enum SYSUSERSTATUS
{
    EFFECTIVE(1), INVALID(0);

    private final int value;

    SYSUSERSTATUS(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
