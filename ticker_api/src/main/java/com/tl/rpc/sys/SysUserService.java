package com.tl.rpc.sys;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("SysUserService")
public interface SysUserService
{
    @ThriftService("SysUserService")
    public interface Async
    {
        @ThriftMethod(value = "getByAccount",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<SysUser> getByAccount(
            @ThriftField(value=1, name="serviceToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken serviceToken,
            @ThriftField(value=2, name="account", requiredness=Requiredness.NONE) final String account
        );
    }
    @ThriftMethod(value = "getByAccount",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    SysUser getByAccount(
        @ThriftField(value=1, name="serviceToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken serviceToken,
        @ThriftField(value=2, name="account", requiredness=Requiredness.NONE) final String account
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}