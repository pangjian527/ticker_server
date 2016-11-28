package com.tl.rpc.common;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

@ThriftStruct("RpcException")
public final class RpcException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public RpcException() {
    }

    private int errorId;

    @ThriftField(value=1, name="errorId", requiredness=Requiredness.NONE)
    public int getErrorId() { return errorId; }

    @ThriftField
    public void setErrorId(final int errorId) { this.errorId = errorId; }

    private String errorContent;

    @ThriftField(value=2, name="errorContent", requiredness=Requiredness.NONE)
    public String getErrorContent() { return errorContent; }

    @ThriftField
    public void setErrorContent(final String errorContent) { this.errorContent = errorContent; }
}
