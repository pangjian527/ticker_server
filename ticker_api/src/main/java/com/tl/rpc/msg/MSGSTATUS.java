package com.tl.rpc.msg;

import com.facebook.swift.codec.*;

public enum MSGSTATUS
{
    EFFECTIVE(1), INVALID(0);

    private final int value;

    MSGSTATUS(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
